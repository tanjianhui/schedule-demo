package com.scheduledemo.model;

import java.util.List;

/**
 * Created by tanjianhui on 2017/3/11.
 */
public class TaskRetryRule {
    private Integer failCountFloor; // 失败次数下限
    private Integer failCountUpper; // 失败次数上线
    private Integer retryInterval;  // 重试时间间隔（单位：分钟）

    public TaskRetryRule(){

    }

    public TaskRetryRule(Integer failCountFloor, Integer failCountUpper, Integer retryInterval){
        this.failCountFloor = failCountFloor;
        this.failCountUpper = failCountUpper;
        this.retryInterval = retryInterval;
    }

    public Integer getFailCountFloor() {
        return failCountFloor;
    }

    public void setFailCountFloor(Integer failCountFloor) {
        this.failCountFloor = failCountFloor;
    }

    public Integer getFailCountUpper() {
        return failCountUpper;
    }

    public void setFailCountUpper(Integer failCountUpper) {
        this.failCountUpper = failCountUpper;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public static TaskRetryRule getTaskRetry(Integer failCounter, List<TaskRetryRule> taskRetryRuleList){
        if(null != failCounter && null != taskRetryRuleList && !taskRetryRuleList.isEmpty()){
            for(TaskRetryRule taskRetryRule : taskRetryRuleList){
                if(null != taskRetryRule
                        && failCounter.compareTo(taskRetryRule.getFailCountFloor()) >= 0
                        && failCounter.compareTo(taskRetryRule.getFailCountUpper()) <= 0){
                    return taskRetryRule;
                }
            }
        }

        return null;
    }
}
