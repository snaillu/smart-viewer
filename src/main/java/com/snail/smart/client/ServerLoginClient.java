package com.snail.smart.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.snail.smart.msg.ClientMsg;
import com.snail.smart.vo.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author snail
 * @create 2017/05/08
 */
public class ServerLoginClient extends BaseClient {
    private static final Logger logger = LoggerFactory.getLogger(ServerLoginClient.class);

    private static ServerLoginClient instance;

    //弹幕是否初始化完成
    private boolean isReady = false;

    //socket相关配置
    private Socket sock;


    public static ServerLoginClient getInstance(){
        if(instance == null){
            instance = new ServerLoginClient();
        }

        return instance;
    }

    //初始化弹幕
    public void init(int roomId){
        connectServer();
        validateLoginReq(roomId);
        qtlnq();
        //chatmessage();

        isReady = true;
    }

    //step one
    private void validateLoginReq(int roomId){
        byte[] validateLoginReq = ClientMsg.validateLoginReq(roomId);

        sendMsg(validateLoginReq);
        String loginMsg = readMsg();
        logger.info("validateLoginReq response msg={}",loginMsg);
    }

    //step two
    private void qtlnq(){
        byte[] qtlnqReq = ClientMsg.qtlnq();
        sendMsg(qtlnqReq);
    }

    //step three
    public void chatmessage(String text){
        byte[] chatMsgReq = ClientMsg.chatmessage(text);
        sendMsg(chatMsgReq);
        String sendMsg = readMsg();
        //logger.info("send chat msg result={}",sendMsg);
    }

    //连接弹幕服务器
    private void connectServer(){
        try{
            Server server = getServer();
            //建立sock连接
            sock = new Socket(server.getIp(),server.getPort());
            //设置输入输出
            bos = new BufferedOutputStream(sock.getOutputStream());
            bis = new BufferedInputStream(sock.getInputStream());
        }catch (Exception e){
            logger.error("connect to server error,msg={}",e);
        }

        logger.debug("connect to server success!");
    }

    private static Server getServer(){
        List<Server> servers = getServerList();
        Random rd = new Random();

        return servers.get(rd.nextInt(servers.size()));
    }

    private static List<Server> getServerList(){
        List<Server> result = new ArrayList<Server>();

        String servers = "[{\"ip\":\"119.90.49.90\",\"port\":\"8097\"},{\"ip\":\"119.90.49.90\",\"port\":\"8099\"},{\"ip\":\"119.90.49.103\",\"port\":\"8011\"},{\"ip\":\"119.90.49.101\",\"port\":\"8005\"},{\"ip\":\"119.90.49.102\",\"port\":\"8009\"},{\"ip\":\"119.90.49.107\",\"port\":\"8035\"},{\"ip\":\"119.90.49.109\",\"port\":\"8042\"},{\"ip\":\"119.90.49.87\",\"port\":\"8082\"},{\"ip\":\"119.90.49.109\",\"port\":\"8041\"},{\"ip\":\"119.90.49.110\",\"port\":\"8050\"},{\"ip\":\"119.90.49.86\",\"port\":\"8078\"},{\"ip\":\"119.90.49.87\",\"port\":\"8083\"},{\"ip\":\"119.90.49.89\",\"port\":\"8094\"},{\"ip\":\"119.90.49.104\",\"port\":\"8019\"},{\"ip\":\"119.90.49.109\",\"port\":\"8044\"},{\"ip\":\"119.90.49.95\",\"port\":\"8072\"},{\"ip\":\"119.90.49.94\",\"port\":\"8067\"},{\"ip\":\"119.90.49.92\",\"port\":\"8058\"},{\"ip\":\"119.90.49.90\",\"port\":\"8096\"},{\"ip\":\"119.90.49.88\",\"port\":\"8090\"},{\"ip\":\"119.90.49.102\",\"port\":\"8008\"},{\"ip\":\"119.90.49.93\",\"port\":\"8064\"},{\"ip\":\"119.90.49.92\",\"port\":\"8057\"},{\"ip\":\"119.90.49.86\",\"port\":\"8076\"},{\"ip\":\"119.90.49.105\",\"port\":\"8024\"},{\"ip\":\"119.90.49.106\",\"port\":\"8027\"},{\"ip\":\"119.90.49.105\",\"port\":\"8023\"},{\"ip\":\"119.90.49.104\",\"port\":\"8020\"},{\"ip\":\"119.90.49.87\",\"port\":\"8081\"},{\"ip\":\"119.90.49.108\",\"port\":\"8038\"}]";
        JSONArray array = JSONArray.parseArray(servers);
        Iterator it = array.iterator();

        while (it.hasNext()){
            JSONObject object = (JSONObject) it.next();
            Server server = new Server();
            server.setIp(object.getString("ip"));
            server.setPort(object.getInteger("port"));
            result.add(server);
        }

        return result;
    }

    public boolean isReady() {
        return isReady;
    }

    public static void main(String[] args){
        List<Server> result = getServerList();
        logger.info("result={}",result);
    }
}
