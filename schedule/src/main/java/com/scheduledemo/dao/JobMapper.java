package com.scheduledemo.dao;

import com.scheduledemo.model.Job;
import com.scheduledemo.model.JobExample;
import com.scheduledemo.sdk.dal.mybatis.BaseMapper;

import java.util.Date;

public interface JobMapper extends BaseMapper<Integer, Job, JobExample> {
    void processTimeoutJob(Date now);
}