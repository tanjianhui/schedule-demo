package com.scheduledemo.schedule;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tanjianhui on 2017/3/10.
 */
@Component("amazonScheduler")
public class AmazonScheduler {
    private final static String AMA_CHECK = "AMA_CHECK";
    private final static String AMA_SUBMIT_PRODUCT = "AMA_SUBMIT_PRODUCT";
    private final static String AMA_SUBMIT_PRODUCT_IMAGE = "AMA_SUBMIT_PRODUCT_IMAGE";
    private final static String AMA_SUBMIT_PRODUCT_RELATIONSHIP = "AMA_SUBMIT_PRODUCT_RELATIONSHIP";
    private final static String AMA_SUBMIT_INVENTORY = "AMA_SUBMIT_INVENTORY";
    private final static String AMA_SUBMIT_FULFILLMENT = "AMA_SUBMIT_FULFILLMENT";
    private final static String AMA_RECOVER_EXECUTION = "AMA_RECOVER_EXECUTION";
    private final static String AMA_RECOVER_EXECUTION_TIME_BY = "AMA_RECOVER_EXECUTION_TIME_BY";

    private final static String ROUTING_KEY = "AMAZON_FEED_API_QUEUE_KEY";
    private final static String HEADER_KEY = "com.gm.dropship.bean.request.GmRequestAmazonFeedMessage";
    private final static String HEADER_MODE = "AMAZON_FEED";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void check(){
        sendMessage(AMA_CHECK);
    }

    public void submitProduct(){
        sendMessage(AMA_SUBMIT_PRODUCT);
    }

    public void submitProductImage(){
        sendMessage(AMA_SUBMIT_PRODUCT_IMAGE);
    }

    public void submitProductRelationship(){
        sendMessage(AMA_SUBMIT_PRODUCT_RELATIONSHIP);
    }

    public void submitInventory(){
        sendMessage(AMA_SUBMIT_INVENTORY);
    }

    public void submitFulfillment(){
        sendMessage(AMA_SUBMIT_FULFILLMENT);
    }

    public void recoverExecution(){
        sendMessage(AMA_RECOVER_EXECUTION);
    }

    public void recoverExecutionTimeBy(){
        sendMessage(AMA_RECOVER_EXECUTION_TIME_BY);
    }

    private void sendMessage(String taskType){
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("taskType", taskType);

        rabbitTemplate.convertAndSend(ROUTING_KEY,
                MessageBuilder.withBody(JSON.toJSONString(messageMap).getBytes(Charset.defaultCharset()))
                        .setHeader("KEY", HEADER_KEY).setHeader("MODE", HEADER_MODE).build());
    }
}
