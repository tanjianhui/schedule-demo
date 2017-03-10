package com.scheduledemo.dao;

import com.scheduledemo.model.Scheduler;
import com.scheduledemo.model.SchedulerExample;
import java.util.List;

import com.scheduledemo.sdk.dal.mybatis.BaseMapper;

public interface SchedulerMapper extends BaseMapper<Integer, Scheduler, SchedulerExample>{
    int updateStatusBatch(List<Scheduler> recordList);
}