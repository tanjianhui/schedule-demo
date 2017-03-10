package com.scheduledemo.model;

/**
 * Created by tanjianhui on 2017/3/8.
 */
public enum JobStatus {
    NEW("1"),
    INITIAL("2"),
    PROCESSING("3"),
    TIMEOUT("4"),
    DONE("5"),
    FAIL("6"),
    KILLED("7");

    private String key;

    JobStatus(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
