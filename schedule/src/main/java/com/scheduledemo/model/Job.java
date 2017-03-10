package com.scheduledemo.model;

import java.util.Date;

public class Job {
    private Integer jobId;

    private Integer tasId;

    private Integer strId;

    private Integer deaId;

    private Integer plaId;

    private String businessParameter;

    private Date startTime;

    private Date completeTime;

    private Date estimateCompleteTime;

    private Date estimateLongestCompleteTime;

    private Integer priority;

    private Integer failCounter;

    private Date nextRunTime;

    private String status;

    private String remark;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getTasId() {
        return tasId;
    }

    public void setTasId(Integer tasId) {
        this.tasId = tasId;
    }

    public Integer getStrId() {
        return strId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public Integer getDeaId() {
        return deaId;
    }

    public void setDeaId(Integer deaId) {
        this.deaId = deaId;
    }

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public String getBusinessParameter() {
        return businessParameter;
    }

    public void setBusinessParameter(String businessParameter) {
        this.businessParameter = businessParameter;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getEstimateCompleteTime() {
        return estimateCompleteTime;
    }

    public void setEstimateCompleteTime(Date estimateCompleteTime) {
        this.estimateCompleteTime = estimateCompleteTime;
    }

    public Date getEstimateLongestCompleteTime() {
        return estimateLongestCompleteTime;
    }

    public void setEstimateLongestCompleteTime(Date estimateLongestCompleteTime) {
        this.estimateLongestCompleteTime = estimateLongestCompleteTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getFailCounter() {
        return failCounter;
    }

    public void setFailCounter(Integer failCounter) {
        this.failCounter = failCounter;
    }

    public Date getNextRunTime() {
        return nextRunTime;
    }

    public void setNextRunTime(Date nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}