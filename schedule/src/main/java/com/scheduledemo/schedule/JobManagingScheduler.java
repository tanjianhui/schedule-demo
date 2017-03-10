package com.scheduledemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanjianhui on 2017/2/21.
 * 订单同步调度器
 */
@Component("jobManagingScheduler")
public class JobManagingScheduler {
    private static final Logger logger = LoggerFactory.getLogger(JobManagingScheduler.class);

    @Autowired
    private RabbitTemplate manageJobTemplate;

    // TODO 增加切面，记录调度器执行情况（执行中，成功，失败）
    public void execute(){
        logger.info("StockSyncScheduler.execute Start...");

        manageJobTemplate.convertAndSend("");


        logger.info("StockSyncScheduler.execute Complete...");
    }

}
