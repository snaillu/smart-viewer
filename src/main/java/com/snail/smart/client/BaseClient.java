package com.snail.smart.client;

import com.snail.smart.msg.ClientMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

/**
 * @author snail
 * @create 2017/05/08
 */
public class BaseClient {
    private static final Logger logger = LoggerFactory.getLogger(BaseClient.class);

    //设置字节获取buffer的最大值
    private static final int MAX_BUFFER_LENGTH = 4096;

    //socket相关配置
    protected Socket sock;
    protected BufferedOutputStream bos;
    protected BufferedInputStream bis;

    //是否初始化完成
    protected boolean isReady = false;

    protected void sendMsg(byte[] req){
        try{
            //发送登录房间信息
            bos.write(req,0,req.length);
            bos.flush();

        }catch (Exception e){
            logger.error("login room error, msg={}",e);
        }
    }

    //read msg from server
    protected String readMsg(){
        String result = "";

        try{
            byte[] recvByte = new byte[MAX_BUFFER_LENGTH];
            int recvLength = bis.read(recvByte,0,recvByte.length);
            if(recvLength<1){
                return result;
            }
            byte[] realByte = new byte[recvLength];
            System.arraycopy(recvByte,0,realByte,0,recvLength);

            result = new String(realByte,12,realByte.length-12);
        }catch (Exception e){
            logger.error("read msg error,msg={}",e);
        }

        return result;
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

    public boolean isReady() {
        return isReady;
    }
}
