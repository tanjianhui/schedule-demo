package com.scheduledemo.service;

import com.scheduledemo.dao.SchedulerMapper;
import com.scheduledemo.model.Scheduler;
import com.scheduledemo.model.SchedulerExample;
import com.scheduledemo.sdk.schedule.SchedulerStatus;
import com.scheduledemo.sdk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/3/7.
 */
@Service("schedulerService")
public class SchedulerService extends BaseService<Integer, Scheduler, SchedulerExample, SchedulerMapper> {
    @Autowired
    private SchedulerMapper schedulerMapper;

    @Override
    protected SchedulerMapper getMapper() {
        return schedulerMapper;
    }

    public List<Scheduler> getNotSchedulingTaskList(){
        SchedulerExample schedulerExample = new SchedulerExample();
        schedulerExample.createCriteria().andStatusEqualTo(SchedulerStatus.NO.getKey());
        return this.schedulerMapper.selectByExample(schedulerExample);
    }

    public int updateStatusBatch(List<Scheduler> schedulerList){
        Date now = new Date();
        for(Scheduler scheduler : schedulerList){
            scheduler.setLastUpdateBy("scheduler");
            scheduler.setLastUpdateTime(now);
        }
        return this.schedulerMapper.updateStatusBatch(schedulerList);
    }

}
