package com.snail.smart.enums;

/**
 * @author snail
 * @create 2017/04/21
 */
public enum RoomApiEnum {
    ALL_LIVE("http://capi.douyucdn.cn/api/v1/live","全部直播");

    RoomApiEnum(String api,String msg){
        this.api = api;
        this.msg = msg;
    }

    private String api;
    private String msg;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
