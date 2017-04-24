package com.snail.smart.enums;

/**
 * @author snail
 * @create 2017/04/24
 */
public enum ResponseCodeEnum {

    SUCCESS(0,"成功"),
    FAIL(1,"失败");

    ResponseCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResponseCodeEnum getResponseCode(int code){
        for(ResponseCodeEnum respCode:ResponseCodeEnum.values()){
            if(respCode.getCode()==code){
                return respCode;
            }
        }

        return null;
    }
}
