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
@Component("processJobResultConsumer")
public class ProcessJobResultConsumer implements MessageListener{
    private static final Logger logger = LoggerFactory.getLogger(ProcessJobResultConsumer.class);

    @Autowired
    private JobService jobService;

    @Override
    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        logger.info("消息内容：{}", messageBody);

        JSONObject jsonObject = JSON.parseObject(new String(message.getBody()));

        Integer jobId = jsonObject.getInteger("jobTaskId");
        String status = jsonObject.getInteger("status").toString();
        String errorMessage = jsonObject.getString("errorMessage");

        Job record  = new Job();
        record.setJobId(jobId);
        record.setStatus(status.toString());
        record.setRemark(errorMessage);

        jobService.processJobResult(record);
    }
}
