package com.scheduledemo.service;

import com.scheduledemo.dao.JobMapper;
import com.scheduledemo.model.*;
import com.scheduledemo.sdk.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/3/7.
 */
@Service("jobService")
public class JobService extends BaseService<Integer, Job, JobExample, JobMapper> {
    private static final Logger logger = LoggerFactory.getLogger(JobService.class);

    @Autowired private JobMapper jobMapper;

    @Autowired private JobErrorService jobErrorService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override protected JobMapper getMapper() {
        return jobMapper;
    }


    /**
     * 处理超时作业
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processTimeoutJob(){
        JobExample jobExample = new JobExample();
        jobExample.createCriteria()
                .andStatusIn(
                        Arrays.asList(
                                JobStatus.INITIAL.getKey(), JobStatus.PROCESSING.getKey(), JobStatus.TIMEOUT.getKey()))
                .andEstimateLongestCompleteTimeLessThan(new Date());

        Job job = new Job();
        job.setStatus(JobStatus.TIMEOUT.getKey());

        jobMapper.updateByExampleSelective(job, jobExample);
    }

    @Transactional
    public int updateJobStatusByPrimaryKey(Job record){
        record.setLastUpdateBy("admin");
        record.setLastUpdateTime(new Date());
        return jobMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 处理作业结果
     */
    @Transactional
    public void processJobResult(Job record){
        Integer jobId = record.getJobId();
        String status = record.getStatus();

        Job job = this.jobMapper.selectByPrimaryKey(jobId);
        if(null == job){
            logger.warn("无法在数据库中发现该作业[jobId:{}]", jobId);
            return ;
        }

        if(JobStatus.PROCESSING.getKey().equals(status)){ // 状态转变为PROCESSING
            if(!JobStatus.INITIAL.checkStatus(job.getStatus())){
                logger.warn("该作业[jobId:{}]的当前状态非INITIAL，而是{}，系统不做处理。", jobId, JobStatus.getByKey(job.getStatus()));
                return ;
            }

            this.updateJobStatusByPrimaryKey(record);
        }else if(JobStatus.DONE.checkStatus(status)){ // 状态转变为DONE
            if(!JobStatus.checkStatus(job.getStatus(), new JobStatus[]{JobStatus.INITIAL, JobStatus.PROCESSING})){
                logger.warn("该作业[jobId:{}]的当前状态非INITIAL或PROCESSING，而是{}，系统不做处理。",
                        jobId, JobStatus.getByKey(job.getStatus()));
                return ;
            }

            record.setCompleteTime(new Date());
            this.updateJobStatusByPrimaryKey(record);

            rabbitTemplate.convertAndSend("JOB_MANAGE_API_QUEUE_KEY",
                    MessageBuilder.withBody("MANAGE_JOB".getBytes()));
        }else if(JobStatus.FAIL.checkStatus(status)){
            if(!JobStatus.checkStatus(job.getStatus(), new JobStatus[]{JobStatus.INITIAL, JobStatus.PROCESSING})){
                logger.warn("该作业[jobId:{}]的当前状态非INITIAL或PROCESSING，而是{}，系统不做处理。",
                        jobId, JobStatus.getByKey(job.getStatus()));
                return ;
            }

            List<TaskRetryRule> taskRetryRuleList = taskService.getTaskRetryRuleByPrimaryKey(job.getTasId());
            Integer failCounter = job.getFailCounter() + 1;
            TaskRetryRule taskRetryRule = null;
            if(null == taskRetryRuleList
                    || null == (taskRetryRule = TaskRetryRule.getTaskRetry(failCounter, taskRetryRuleList))){

                record.setCompleteTime(new Date());
                this.updateJobStatusByPrimaryKey(record);
            }else{
                record.setStatus(JobStatus.NEW.getKey());
                record.setFailCounter(failCounter);
                record.setNextRunTime(
                        new Date(System.currentTimeMillis() + taskRetryRule.getRetryInterval() * 60000));

                this.updateJobStatusByPrimaryKey(record);
            }

            JobError jobError = new JobError();
            jobError.setJobId(jobId);
            jobError.setErrorMessage(job.getRemark());
            jobError.setCreateBy("admin");
            jobError.setCreateTime(new Date());

            jobErrorService.insertSelective(jobError);

            rabbitTemplate.convertAndSend("JOB_MANAGE_API_QUEUE_KEY",
                    MessageBuilder.withBody("MANAGE_JOB".getBytes()));
        }
    }
}
