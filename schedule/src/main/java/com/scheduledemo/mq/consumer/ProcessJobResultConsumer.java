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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/3/8.
 */
@Component("processJobResultConsumer")
public class ProcessJobResultConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ProcessJobResultConsumer.class);

    @Autowired
    private JobService jobService;

    public void listen(String message){
        // TODO 成功，更新作业状态未Done

        // TODO 失败，重试或更新状态为失败

        // TODO 更新作业结果后，通知作业管理流程
    }
}
