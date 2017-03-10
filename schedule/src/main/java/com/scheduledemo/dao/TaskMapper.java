package com.scheduledemo.dao;

import com.scheduledemo.model.Task;
import com.scheduledemo.model.TaskExample;
import com.scheduledemo.sdk.dal.mybatis.BaseMapper;

public interface TaskMapper extends BaseMapper<Integer, Task, TaskExample> {

}