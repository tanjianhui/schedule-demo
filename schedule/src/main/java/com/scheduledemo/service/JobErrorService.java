package com.scheduledemo.service;

import com.scheduledemo.dao.JobErrorMapper;
import com.scheduledemo.dao.JobMapper;
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
@Service("jobErrorService")
public class JobErrorService extends BaseService<Integer, JobError, JobErrorExample, JobErrorMapper> {
    @Autowired
    private JobErrorMapper jobErrorMapper;

    @Override
    protected JobErrorMapper getMapper() {
        return jobErrorMapper;
    }

}
