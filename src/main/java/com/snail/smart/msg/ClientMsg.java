package com.snail.smart.msg;

import com.snail.smart.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author snail
 * @create 2017/04/26
 */
public class ClientMsg {
    private static final Logger logger = LoggerFactory.getLogger(ClientMsg.class);

    public static final int MSG_HEADER = 689;

    //登录请求消息
    public static byte[] getLoginReqMsg(int roomId){
        Encoder encoder = new Encoder("loginreq");
        encoder.addParam("roomid",roomId);
        encoder.addParam("username","");
        encoder.addParam("password","");

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

    //step one
    public static byte[] validateLoginReq(int roomId){
        Encoder encoder = new Encoder("loginreq");

        String devId = getDevId();
        String rt = String.valueOf(System.currentTimeMillis()/1000);
        String vk = StringUtils.md5(rt+"7oE9nPEG9xXV69phU31FYCLUagKeYtsF"+devId);

        encoder.addParam("username","104954726");
        encoder.addParam("ct",0);
        encoder.addParam("password","");
        encoder.addParam("roomid",roomId);
        encoder.addParam("devid",devId);
        encoder.addParam("rt",rt);
        encoder.addParam("vk",vk);
        encoder.addParam("ver","20150929");
        encoder.addParam("aver","2017050701");
        encoder.addParam("ltkid","22718325");
        encoder.addParam("biz","1");
        encoder.addParam("stk","3ac47831a30fb493");
        //logger.info("validate msg={}",encoder);


        return encoder.getResult();
    }

    //step two
    public static byte[] qtlnq(){
        Encoder encoder = new Encoder("qtlnq");

        return encoder.getResult();
    }

    //step three
    public static byte[] chatmessage(String content){
        Encoder encoder = new Encoder("chatmessage");
        encoder.addParam("receiver",0);
        encoder.addParam("content",content);
        encoder.addParam("scope","");
        encoder.addParam("col",0);
        encoder.addParam("pid","");
        encoder.addParam("p2p",0);
        encoder.addParam("nc",0);
        encoder.addParam("rev",0);
        //logger.debug("chatmessage request msg={}",encoder);

        return encoder.getResult();
    }

    private static String getDevId(){
        UUID uuid =UUID.randomUUID();

        return uuid.toString().replace("-", "").toUpperCase();
    }



    public static void main(String[] args){
        String devicId = "15C327B2D6BF6544DE342F81A9074BA6",rt = "1494232576", middle = "7oE9nPEG9xXV69phU31FYCLUagKeYtsF";
        //14537958227oE9nPEG9xXV69phU31FYCLUagKeYtsFDF9E4515E0EE766B39F8D8A2E928BB7C
        String md5 = StringUtils.md5(rt+middle+devicId);
        //4fc6e613fc650a058757331ed6c8a619
        System.out.println("md5="+md5);

    }
}
