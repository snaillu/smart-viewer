package com.snail.smart.msg;

/**
 * @author snail
 * @create 2017/04/26
 */
public class ClientMsg {
    public static final int MSG_HEADER = 689;

    //登录请求消息
    public static byte[] getLoginReqMsg(int roomId){
        Encoder encoder = new Encoder("loginreq");
        encoder.addParam("roomid",roomId);

        return encoder.getResult();
    }

    //客户端心跳消息
    public static byte[] getKeepLiveMsg(int timestamp){
        Encoder encoder = new Encoder("keeplive");
        encoder.addParam("tick",timestamp);

        return encoder.getResult();
    }

    //入组消息
    public static byte[] getJoinGroupMsg(int roomId, int groupId){
        Encoder encoder = new Encoder("joingroup");
        encoder.addParam("rid",roomId);
        encoder.addParam("gid",groupId);

        return encoder.getResult();
    }

    //登出消息
    public static byte[] getLogoutMsg(){
        Encoder encoder = new Encoder("logout");

        return encoder.getResult();
    }
}
