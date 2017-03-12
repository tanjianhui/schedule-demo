package com.scheduledemo.mq.producer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.scheduledemo.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanjianhui on 2017/3/9.
 */
@Component("executeJobProducer")
public class ExecuteJobProducer {
    private static final Logger logger = LoggerFactory.getLogger(ExecuteJobProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void execute(Job job){

        Map<String, Object> header = new HashMap<>();
        header.put("sendType", job.getPlaId());
        header.put("receiver", "system");
        header.put("sender", "system");
        header.put("sendDate", System.currentTimeMillis());
        header.put("jobTaskId", job.getJobId());

        logger.info("businessParameter : {}", job.getBusinessParameter());
        JSONObject jsonObject = JSON.parseObject(job.getBusinessParameter());

        Map<String, Object> message = new HashMap<>();
        message.put("header", header);
        message.putAll(jsonObject);

        String jsonString = JSON.toJSONString(message, SerializerFeature.WriteMapNullValue);
        logger.info("jsonString : {}", jsonString);
        rabbitTemplate.convertAndSend("INVENTORY_API_QUEUE_KEY",
                    MessageBuilder.withBody(jsonString.getBytes(Charset.defaultCharset()))
                            .setHeader("KEY", "com.gm.dropship.bean.request.GmRequestRefreshInventoryMessage")
                            .setHeader("MODE", "INVENTORY").build());
    }
}
