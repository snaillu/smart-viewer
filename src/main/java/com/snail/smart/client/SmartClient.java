package com.snail.smart.client;

import com.snail.smart.msg.Decoder;
import com.snail.smart.task.SendGiftMsgTask;

import java.util.List;

/**
 * @author snail
 * @create 2017/05/09
 */
public class SmartClient {
    private static int DEFAULT_GROUP_ID = -9999;

    private ServerLoginClient loginClient;
    private BulletScreenClient bulletClient;

    private boolean isSendMsg;


    public SmartClient(int roomId,int userId,boolean isSendMsg){
        loginClient = new ServerLoginClient(roomId,userId);
        bulletClient = new BulletScreenClient(roomId,DEFAULT_GROUP_ID);
        if(isSendMsg){
            SendGiftMsgTask task = SendGiftMsgTask.getInstance(this);
            task.start();
        }
        this.isSendMsg = isSendMsg;
    }

    //get bullet screen message
    public List<Decoder> getBulletMsg(){
        return bulletClient.getServerMsg();
    }

    //send a chat message
    public void sendChatMsg(String text){
        loginClient.chatmessage(text);
    }

    //return the server ready status
    public boolean isReady(){
        return loginClient.isReady()&&bulletClient.isReady();
    }

    public boolean isSendMsg() {
        return isSendMsg;
    }
}
