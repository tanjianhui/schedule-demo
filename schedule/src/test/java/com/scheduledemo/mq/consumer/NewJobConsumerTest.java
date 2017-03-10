package com.scheduledemo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by tanjianhui on 2017/3/8.
 */
public class NewJobConsumerTest {
    private static final Logger logger = LoggerFactory.getLogger(NewJobConsumerTest.class);
    @Test
    public void test(){
        JSONObject jsonObject = JSON.parseObject("{\"refreshInventory\":{\"proId\":null,\"strId\":null,\"qty\":null}}");

        logger.info("{}", jsonObject);
    }
}
