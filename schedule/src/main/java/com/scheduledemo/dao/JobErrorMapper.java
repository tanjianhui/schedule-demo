package com.scheduledemo.dao;

import com.scheduledemo.model.JobError;
import com.scheduledemo.model.JobErrorExample;
import com.scheduledemo.sdk.dal.mybatis.BaseMapper;

public interface JobErrorMapper extends BaseMapper<Integer, JobError, JobErrorExample> {
}