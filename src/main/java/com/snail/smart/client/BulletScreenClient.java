package com.snail.smart.client;

import com.snail.smart.msg.ClientMsg;
import com.snail.smart.msg.Decoder;
import com.snail.smart.msg.MsgParser;
import com.snail.smart.task.KeepliveTask;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author snail
 * @create 2017/04/26
 */
public class BulletScreenClient extends BaseClient {
    private static final Logger logger = LoggerFactory.getLogger(BulletScreenClient.class);

    private static BulletScreenClient instance;

    //第三方弹幕协议服务器地址
    private static final String hostName = "openbarrage.douyutv.com";

    //第三方弹幕协议服务器端口
    private static final int port = 8601;



    public static BulletScreenClient getInstance(){
        if(instance == null){
            instance = new BulletScreenClient();
        }

        return instance;
    }

    //初始化弹幕
    public void init(int roomId, int groupId){
        connectServer();
        loginRoom(roomId);
        joinGroup(roomId,groupId);
        isReady = true;

        //start keep live task
        KeepliveTask task = new KeepliveTask(this);
        task.start();
    }

    //连接弹幕服务器
    private void connectServer(){
        try{
            //获取弹幕访问host
            String host = Inet4Address.getByName(hostName).getHostAddress();
            //建立sock连接
            sock = new Socket(host,port);

            //设置输入输出
            bos = new BufferedOutputStream(sock.getOutputStream());
            bis = new BufferedInputStream(sock.getInputStream());
        }catch (Exception e){
            logger.error("connect to server error,msg={}",e);
        }

        logger.debug("connect to server success!");
    }

    //登录房间
    private void loginRoom(int roomId){
        byte[] loginRep = ClientMsg.getLoginReqMsg(roomId);

        try{
            sendMsg(loginRep);
            logger.debug("login room success,roomId={}",roomId);
        }catch (Exception e){
            logger.error("login room error, roomId={}, msg={}",roomId,e);
        }
    }

    private void joinGroup(int roomId, int groupId){
        byte[] groupReq = ClientMsg.getJoinGroupMsg(roomId,groupId);

        try{
            sendMsg(groupReq);

            logger.debug("join group success!");
        }catch (Exception e){
            logger.error("join group error, roomId={}, groupId={}, msg={}",roomId,groupId,e);
        }
    }

    public List<Decoder> getServerMsg(){
        List<Decoder> result = new ArrayList<Decoder>();

        try{
            String msg = readMsg();

            while (msg.lastIndexOf("type@=")>5){
                Decoder decoder = new Decoder(StringUtils.substring(msg,msg.lastIndexOf("type@=")));
                //printMsg(decoder.getResult());
                result.add(decoder);
                msg = StringUtils.substring(msg,0,msg.lastIndexOf("type@=")-12);
            }

            Decoder decoder = new Decoder(StringUtils.substring(msg,msg.lastIndexOf("type@=")));
            result.add(decoder);
        }catch (Exception e){
            logger.error("get server msg error,msg={}",e);
        }

        return result;
    }
}
