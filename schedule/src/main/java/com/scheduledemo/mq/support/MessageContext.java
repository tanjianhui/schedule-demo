package com.scheduledemo.mq.support;

/**
 * Created by tanjianhui on 2017/3/11.
 */
public class MessageContext {
    private String routingKey;
    private String headerKey;
    private String headerMode;

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getHeaderKey() {
        return headerKey;
    }

    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    public String getHeaderMode() {
        return headerMode;
    }

    public void setHeaderMode(String headerMode) {
        this.headerMode = headerMode;
    }
}
