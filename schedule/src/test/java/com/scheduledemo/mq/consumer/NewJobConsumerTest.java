package com.scheduledemo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scheduledemo.model.TaskRetryRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
}
