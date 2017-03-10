package com.scheduledemo.schedule;

import com.scheduledemo.sdk.schedule.JobDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanjianhui on 2017/2/21.
 * 调度管理调度器
 */
@Component("scheduleManagingScheduler")
public class ScheduleManagingScheduler {
    @Autowired
    private JobDetailManager jobDetailManager;

    public void execute(){
        jobDetailManager.manageJobDetail();
    }
}
