package com.scheduledemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by tanjianhui on 2017/2/8.
 */
@Component("jobConsumer")
public class JobConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JobConsumer.class);

    public void listen(String str) {
        logger.info("listen: {}", str);
        try{
            Thread.sleep(30000L);
        }catch (InterruptedException e){

        }
    }

    public void listen1(String str) {
        logger.info("listen1: {}", str);
        try{
            Thread.sleep(30000L);
        }catch (InterruptedException e){

        }
    }
}
