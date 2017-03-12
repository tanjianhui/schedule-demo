package com.scheduledemo.mq.support;

/**
 * Created by tanjianhui on 2017/3/11.
 */
public enum RoutingKeyEnum {
    InventoryApiQueueKey("INVENTORY_API_QUEUE_KEY")
    ;

    private String key;

    RoutingKeyEnum(String key){
        this.key = key;
    }
}
