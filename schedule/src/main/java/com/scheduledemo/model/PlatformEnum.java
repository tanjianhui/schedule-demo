package com.scheduledemo.model;

/**
 * Created by tanjianhui on 2017/3/9.
 */
public enum PlatformEnum {
    AMAZON(1),
    EBAY(2);

    private Integer key;

    PlatformEnum(Integer key){
        this.key = key;
    }

    public Integer getKey(){
        return this.key;
    }

    public boolean isPlatform(Integer key){
        return this.key.equals(key);
    }
}
