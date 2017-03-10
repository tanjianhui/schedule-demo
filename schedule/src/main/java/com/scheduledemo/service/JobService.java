package com.scheduledemo.service;

import com.scheduledemo.dao.JobMapper;
import com.scheduledemo.model.Job;
import com.scheduledemo.model.JobExample;
import com.scheduledemo.model.JobStatus;
import com.scheduledemo.sdk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by tanjianhui on 2017/3/7.
 */
@Service("jobService")
public class JobService extends BaseService<Integer, Job, JobExample, JobMapper> {
    @Autowired
    private JobMapper jobMapper;

    @Override
    protected JobMapper getMapper() {
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

}
