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
        encoder.addParam("username","104954726");
        encoder.addParam("password","");

        return encoder.getResult();
    }

    public static byte[] getLgoinReqMsg2(int roomId){
        Encoder encoder = new Encoder("loginreq");
        encoder.addParam("roomid",roomId);
        encoder.addParam("username","104954726");
        encoder.addParam("password","1234567890123456");

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

    public static byte[] sendMsg(){
        Encoder encoder = new Encoder("chatmsg");
        encoder.addParam("rid","11017");
        encoder.addParam("uid","104954726");
        encoder.addParam("nn","");
        encoder.addParam("txt","hello9090");
        encoder.addParam("cid","c8831fc3f25b45f63a49020000000000");
        encoder.addParam("ic","avanew@Sface@S201701@S21@S20@Se4b9882bb494f6cd938befbf58fba907");
        encoder.addParam("level","12");
        encoder.addParam("bnn","");
        encoder.addParam("bl","0");
        encoder.addParam("brid","0");
        encoder.addParam("hc","");
        encoder.addParam("el","eid@AA=1500000113@ASetp@AA=1@ASsc@AA=1@ASef@AA=0@AS@S");

        return encoder.getResult();
    }

    public static byte[] chatMessage(String content){
        Encoder encoder = new Encoder("chatmessage");
        encoder.addParam("content","sueprsnail.....");

        return encoder.getResult();
    }
}
