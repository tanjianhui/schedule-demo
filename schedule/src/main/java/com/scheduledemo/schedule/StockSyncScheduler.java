package com.scheduledemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanjianhui on 2017/2/21.
 * 订单同步调度器
 */
@Component("stockSyncScheduler")
public class StockSyncScheduler {
    private static final Logger logger = LoggerFactory.getLogger(StockSyncScheduler.class);

    @Value("${stocksync.job.url}")
    private String jobUrl;

    // TODO 增加切面，记录调度器执行情况（执行中，成功，失败）
    public void execute(){
        ResponseEntity<String> str = new RestTemplate().postForEntity(jobUrl,
                getPost(String.valueOf("{}")),
                String.class);
    }

    public static HttpEntity<String> getPost(String json) {
        HttpEntity<String> formEntity = null;
        if (json != null && !"".equals(json)) {
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType
                    .parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            formEntity = new HttpEntity<String>(json, headers);
        }
        return formEntity;
    }

}
