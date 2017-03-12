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
    KILLED("7"),
    NONE("NONE");

    private String key;

    JobStatus(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public static JobStatus getByKey(String key){
        JobStatus[] jobStatusArray = JobStatus.values();
        for(JobStatus jobStatus : jobStatusArray){
            if(jobStatus.getKey().equals(key)){
                return jobStatus;
            }
        }
        return NONE;
    }

    public Boolean checkStatus(String key){
        return this.getKey().equals(key);
    }

    public static Boolean checkStatus(String key, JobStatus[] jobStatuses){
        for(JobStatus jobStatus : jobStatuses){
            if(jobStatus.getKey().equals(key)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
