package com.scheduledemo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scheduledemo.model.TaskRetryRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by tanjianhui on 2017/3/8.
 */
public class NewJobConsumerTest {
    private static final Logger logger = LoggerFactory.getLogger(NewJobConsumerTest.class);
    @Test
    public void test(){
        JSONObject jsonObject = JSON.parseObject("{\"jobTaskType\":1,\"jobTaskId\":null,\"strId\":84,\"developerId\":123,\"plataeformType\":2,\"business\":null,\"status\":null,\"refreshInventory\":{\"proId\":578,\"strId\":null,\"qty\":12}}");

        logger.info("{}", jsonObject);

        List<TaskRetryRule> taskRetryRuleList = new ArrayList<>();
        taskRetryRuleList.add(new TaskRetryRule(1, 3, 1));
        taskRetryRuleList.add(new TaskRetryRule(4, 6, 5));
        taskRetryRuleList.add(new TaskRetryRule(7, 9, 10));

        String taskRetryRuleListJson = JSON.toJSONString(taskRetryRuleList);
        logger.info("{}",taskRetryRuleListJson);

        taskRetryRuleList = JSON.parseArray(taskRetryRuleListJson, TaskRetryRule.class);
        logger.info("{}", taskRetryRuleList);
    }

    @Test
    public void testSetEx(){
        Jedis jedis = new Jedis("it721.net", 6379);
        logger.info("setex return : {}", jedis.setex("lock", 10, UUID.randomUUID().toString()));
        logger.info("setex return : {}", jedis.setex("lock", 10, UUID.randomUUID().toString()));
    }

    @Test
    public void testSetNx() throws Exception{
        Jedis jedis = new Jedis("it721.net", 6379);
        logger.info("setnx return : {}", jedis.setnx("lock", UUID.randomUUID().toString()));
        jedis.expire("lock", 10);
        logger.info("{}",jedis.ttl("lock"));
        Thread.sleep(8000L);
        logger.info("setnx return : {}", jedis.setnx("lock", UUID.randomUUID().toString()));
        Thread.sleep(2000L);
        logger.info("setnx return : {}", jedis.setnx("lock", UUID.randomUUID().toString()));
    }

    @Test
    public void testIncreDecre() throws Exception{
        Jedis jedis = new Jedis("it721.net", 6379);
        jedis.set("counter", "1");
        logger.info(jedis.get("counter"));
        jedis.expire("counter", 5);
        jedis.incr("counter");
        logger.info(jedis.get("counter"));
        jedis.decr("counter");
        logger.info(jedis.get("counter"));
    }

    @Test
    public void test1() throws Exception{
        Jedis jedis = new Jedis("10.10.28.220", 6379);
        logger.info("{}", jedis.keys("*"));
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis("10.10.28.220", 6379);
//        jedis.info
    }
}
