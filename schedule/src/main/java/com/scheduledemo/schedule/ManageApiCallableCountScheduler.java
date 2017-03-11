package com.scheduledemo.schedule;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.UUID;

/**
 * Created by tanjianhui on 2017/3/10.
 */
public class ManageApiCallableCountScheduler {
    private List<ApiCallableCountMetadata> apiCallableCountMetadataList;

    public void execute(){
        Jedis jedis = new Jedis("it721.net", 6379);

        for(ApiCallableCountMetadata apiCallableCountMetadata : apiCallableCountMetadataList){
            String counterPrefix = apiCallableCountMetadata.getCounterPrefix();
            String uuid = UUID.randomUUID().toString().replace("-","");
            jedis.setex(counterPrefix + "_LOCK", 2, uuid);
        }
    }

    public static class ApiCallableCountMetadata{
        private String counterPrefix;
        private int resumeIntervalInSecond;

        public String getCounterPrefix() {
            return counterPrefix;
        }

        public void setCounterPrefix(String counterPrefix) {
            this.counterPrefix = counterPrefix;
        }

        public int getResumeIntervalInSecond() {
            return resumeIntervalInSecond;
        }

        public void setResumeIntervalInSecond(int resumeIntervalInSecond) {
            this.resumeIntervalInSecond = resumeIntervalInSecond;
        }
    }
}
