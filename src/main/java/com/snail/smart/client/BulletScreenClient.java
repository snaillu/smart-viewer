package com.snail.smart.client;

import com.snail.smart.msg.ClientMsg;
import com.snail.smart.msg.Decoder;
import com.snail.smart.msg.MsgParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Map;

/**
 * @author snail
 * @create 2017/04/26
 */
public class BulletScreenClient {
    private static final Logger logger = LoggerFactory.getLogger(BulletScreenClient.class);

    private static BulletScreenClient instance;

    //第三方弹幕协议服务器地址
    private static final String hostName = "openbarrage.douyutv.com";

    //第三方弹幕协议服务器端口
    private static final int port = 8601;

    //设置字节获取buffer的最大值
    private static final int MAX_BUFFER_LENGTH = 4096;

    //弹幕是否初始化完成
    private boolean isReady = false;

    //socket相关配置
    private Socket sock;
    private BufferedOutputStream bos;
    private BufferedInputStream bis;

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
            //发送登录房间信息
            bos.write(loginRep,0,loginRep.length);
            bos.flush();

            byte[] receiveByte = new byte[MAX_BUFFER_LENGTH];
            bis.read(receiveByte,0,receiveByte.length);

            if(parseLoginRespond(receiveByte)){
                logger.debug("login room success!");
            }else {
                logger.error("login room failed!");
            }
        }catch (Exception e){
            logger.error("login room error, roomId={}, msg={}",roomId,e);
        }
    }

    private void joinGroup(int roomId, int groupId){
        byte[] groupReq = ClientMsg.getJoinGroupMsg(roomId,groupId);

        try{
            bos.write(groupReq,0,groupReq.length);
            bos.flush();

            logger.debug("join group success!");
        }catch (Exception e){
            logger.error("join group error, roomId={}, groupId={}, msg={}",roomId,groupId,e);
        }
    }

    public void keepLive(){
        byte[] keepLiveReq = ClientMsg.getKeepLiveMsg((int)(System.currentTimeMillis()/1000));

        try{
            bos.write(keepLiveReq,0,keepLiveReq.length);
            bos.flush();

            logger.debug("send keep live request success!");
        }catch (Exception e){
            logger.error("keep live error, msg={}",e);
        }
    }

    public void getServerMsg(){
        try{
            byte[] recvByte = new byte[MAX_BUFFER_LENGTH];
            int recvLength = bis.read(recvByte,0,recvByte.length);

            //获取实际的字节码
            byte[] realByte = new byte[recvLength];
            System.arraycopy(recvByte,0,realByte,0,recvLength);

            //get msg info and remove the header
            String msg = new String(realByte,12,realByte.length-12);

            while (msg.lastIndexOf("type@=")>5){
                Decoder decoder = new Decoder(StringUtils.substring(msg,msg.lastIndexOf("type@=")));
                printMsg(decoder.getResult());
                msg = StringUtils.substring(msg,0,msg.lastIndexOf("type@=")-12);
            }

            Decoder decoder = new Decoder(StringUtils.substring(msg,msg.lastIndexOf("type@=")));
            printMsg(decoder.getResult());
        }catch (Exception e){
            logger.error("get server msg error,msg={}",e);
        }
    }

    private void printMsg(Map<String,Object> params){
        MsgParser.parser(params);
    }

    public static boolean parseLoginRespond(byte[] respond){
        boolean rtn = false;

        //返回数据不正确（仅包含12位信息头，没有信息内容）
        if(respond.length <= 12){
            return rtn;
        }

        //解析返回信息包中的信息内容
        String dataStr = new String(respond, 12, respond.length - 12);

        //针对登录返回信息进行判断
        if(dataStr.contains("type@=loginres")){
            rtn = true;
        }

        //返回登录是否成功判断结果
        return rtn;
    }

    public boolean getIsReady(){
        return isReady;
    }
}
