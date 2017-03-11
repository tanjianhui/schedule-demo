package com.scheduledemo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scheduledemo.model.Job;
import com.scheduledemo.model.JobExample;
import com.scheduledemo.model.JobStatus;
import com.scheduledemo.model.Task;
import com.scheduledemo.service.JobService;
import com.scheduledemo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/3/8.
 */
@Component("newJobConsumer")
public class NewJobConsumer implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(NewJobConsumer.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private TaskService taskService;

    public void handle(String message){
        logger.info("开始生成作业，接收到的消息如下：\n{}", message);

        JSONObject jsonObject = JSON.parseObject(message);
        Integer strId = jsonObject.getInteger("strId");
        Integer developerId = jsonObject.getInteger("developerId");
        Integer tasId = jsonObject.getInteger("jobTaskType");
        Integer plataeformType = jsonObject.getInteger("plataeformType");
        String business = jsonObject.getString("business");
        String businessName = jsonObject.getString("businessName");

        // 获取相关任务数据
        Task task = taskService.selectByPrimaryKey(tasId);
        if(null == task){
            logger.error("找不到相应的任务定义。tasId:{}", tasId);
            return;
        }

        Job job = new Job();
        job.setTasId(tasId);
        job.setStrId(strId);
        job.setDeaId(developerId);
        job.setPlaId(plataeformType);
        job.setBusinessParameter("{\"" + businessName + "\":" + business + "}");
        job.setStartTime(new Date());
        job.setEstimateCompleteTime(new Date(job.getStartTime().getTime() + task.getEstimateCostTime() * 60000));
        job.setEstimateLongestCompleteTime(new Date(job.getStartTime().getTime() + task.getEstimateMaxCostTime() * 60000));
        job.setPriority(task.getPriority());
        job.setFailCounter(0);
        job.setNextRunTime(job.getStartTime());
        job.setStatus(JobStatus.NEW.getKey());
        job.setCreateBy("admin");
        job.setCreateTime(job.getStartTime());

        if("0".equals(task.getConcurrency())){ // 不支持并发的作业
            // 如当前存在同任务编号和店铺编号，且状态为New、Initial、Processing和Timeount的作业
            // 则不执行，直接将作业状态置为Done，并记录相关信息
            JobExample jobExample = new JobExample();
            jobExample.createCriteria().andTasIdEqualTo(job.getTasId()).andStrIdEqualTo(job.getStrId());
            List<Job> duplicateJobList = jobService.selectByExample(jobExample);
            if(!duplicateJobList.isEmpty()){
                StringBuilder remark = new StringBuilder();
                remark.append("存在以下未完成的重复作业：\n");
                for(Job duplicateJob : duplicateJobList){
                    remark.append("jobId : ").append(duplicateJob.getJobId()).append("\n");
                }

                job.setStatus(JobStatus.DONE.getKey());
                job.setRemark(remark.toString());
                logger.info("当前作业[jobId:{}, taskId:{}, strId:{}]，{}", job.getJobId(), job.getTasId(),
                        job.getStrId(), job.getRemark());
            }
        }

        jobService.insertSelectiveRN(job);

        logger.info("完成生成作业");
    }

    @Override
    public void onMessage(Message message) {
        this.handle(new String(message.getBody()));
    }
}
