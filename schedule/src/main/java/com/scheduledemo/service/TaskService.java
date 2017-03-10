package com.scheduledemo.service;

import com.scheduledemo.dao.JobMapper;
import com.scheduledemo.dao.TaskMapper;
import com.scheduledemo.model.*;
import com.scheduledemo.sdk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by tanjianhui on 2017/3/7.
 */
@Service("taskService")
public class TaskService extends BaseService<Integer, Task, TaskExample, TaskMapper> {
    @Autowired
    private TaskMapper jobMapper;

    @Override
    protected TaskMapper getMapper() {
        return jobMapper;
    }
}
