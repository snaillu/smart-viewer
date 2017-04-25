package com.snail.smart.vo;


import com.snail.smart.enums.ResponseCodeEnum;

/**
 * @author snail
 * @create 2017/04/24
 */
public class ServiceResponse<T> {
    private int code;
    private String msg;
    private T result;

    public ServiceResponse(){
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMsg();
    }

    public static ServiceResponse failResponse(){
        ServiceResponse response = new ServiceResponse();
        response.setCode(ResponseCodeEnum.FAIL.getCode());
        response.setMsg(ResponseCodeEnum.FAIL.getMsg());

        return response;
    }


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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
