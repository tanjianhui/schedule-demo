package com.scheduledemo.model;

import java.util.Date;

public class Task {
    private Integer tasId;

    private String name;

    private Integer estimateCostTime;

    private Integer estimateMaxCostTime;

    private Integer priority;

    private String concurrency;

    private String retryRule;

    private String remark;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public Integer getTasId() {
        return tasId;
    }

    public void setTasId(Integer tasId) {
        this.tasId = tasId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimateCostTime() {
        return estimateCostTime;
    }

    public void setEstimateCostTime(Integer estimateCostTime) {
        this.estimateCostTime = estimateCostTime;
    }

    public Integer getEstimateMaxCostTime() {
        return estimateMaxCostTime;
    }

    public void setEstimateMaxCostTime(Integer estimateMaxCostTime) {
        this.estimateMaxCostTime = estimateMaxCostTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(String concurrency) {
        this.concurrency = concurrency;
    }

    public String getRetryRule() {
        return retryRule;
    }

    public void setRetryRule(String retryRule) {
        this.retryRule = retryRule;
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