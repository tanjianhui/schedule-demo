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
        JSONObject jsonObject = JSON.parseObject("{\"jobTaskType\":1,\"jobTaskId\":null,\"strId\":84,\"developerId\":123,\"plataeformType\":2,\"business\":null,\"status\":null,\"refreshInventory\":{\"proId\":578,\"strId\":null,\"qty\":12}}");

        logger.info("{}", jsonObject);
    }
}
