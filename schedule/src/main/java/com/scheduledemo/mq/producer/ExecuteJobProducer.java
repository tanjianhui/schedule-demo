package com.scheduledemo.mq.producer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.scheduledemo.model.Job;
import com.scheduledemo.mq.support.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class ExecuteJobProducer implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(ExecuteJobProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ApplicationContext applicationContext;

    public void execute(Job job){
        Map<String, Object> header = new HashMap<>();
        header.put("sendType", job.getPlaId());
        header.put("receiver", "system");
        header.put("sender", "system");
        header.put("sendDate", System.currentTimeMillis());
        header.put("jobTaskId", job.getJobId());

//        logger.info("businessParameter : {}", job.getBusinessParameter());
        JSONObject jsonObject = JSON.parseObject(job.getBusinessParameter());

        Map<String, Object> message = new HashMap<>();
        message.put("header", header);
        message.putAll(jsonObject);

        String jsonString = JSON.toJSONString(message, SerializerFeature.WriteMapNullValue);

        MessageContext messageContext = this.getMessageContext(job.getTasId());
        if(null == messageContext){
            logger.error("未能找到该作业任务相关的配置信息，退出作业执行。[jobId:{}]，[tasId:{}]",
                    job.getJobId(), job.getTasId());
            return ;
        }

        rabbitTemplate.convertAndSend("INVENTORY_API_QUEUE_KEY",
                    MessageBuilder.withBody(jsonString.getBytes(Charset.defaultCharset()))
                            .setHeader("KEY", "com.gm.dropship.bean.request.GmRequestRefreshInventoryMessage")
                            .setHeader("MODE", "INVENTORY").build());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private MessageContext getMessageContext(Integer tasId){
        Map<Integer, MessageContext> messageContextMap =
                (Map<Integer, MessageContext>)applicationContext.getBean("jobMessageContextMap");
        if(null == messageContextMap){
            return null;
        }
        return messageContextMap.get(tasId);
    }
}
