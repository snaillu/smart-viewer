package com.snail.smart.enums;

/**
 * @author snail
 * @create 2017/04/24
 */
public enum DouYuApiEnum {
    //栏目分类行功
    FIRST_CATEGORY("http://capi.douyucdn.cn/api/v1/getColumnList","一级分类列表"),

    //直播相关
    ALL_LIVE("http://capi.douyucdn.cn/api/v1/live","全部直播");

    DouYuApiEnum(String api,String msg){
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
