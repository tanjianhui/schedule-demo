package com.scheduledemo.sdk.schedule;

/**
 * Created by tanjianhui on 2017/2/9.
 */
public enum SchedulerStatus {
    NO("0"), // 未生效
    YES("1"); // 已生效

    private String key;

    SchedulerStatus(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
