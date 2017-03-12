package com.scheduledemo.service;

import com.alibaba.fastjson.JSON;
import com.scheduledemo.dao.JobMapper;
import com.scheduledemo.dao.TaskMapper;
import com.scheduledemo.model.*;
import com.scheduledemo.sdk.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/3/7.
 */
@Service("taskService")
public class TaskService extends BaseService<Integer, Task, TaskExample, TaskMapper> {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskMapper jobMapper;

    @Override
    protected TaskMapper getMapper() {
        return jobMapper;
    }

    public List<TaskRetryRule> getTaskRetryRuleByPrimaryKey(Integer tasId){
        List<TaskRetryRule> taskRetryRuleList = new ArrayList<>();
        if(null == tasId){
            logger.warn("任务主键为[{}].", tasId);
            return taskRetryRuleList;
        }

        Task task = this.jobMapper.selectByPrimaryKey(tasId);
        if(null == task){
            logger.warn("数据库中无该任务记录。[任务主键:{}].", tasId);
            return taskRetryRuleList;
        }

        try {
            taskRetryRuleList = JSON.parseArray(task.getRetryRule(), TaskRetryRule.class);
        }catch (Exception e){
            logger.warn("解析重试规则异常。[业务规则：{}]", task.getRetryRule(), e);
        }
        return taskRetryRuleList;
    }
}
