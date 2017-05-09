package com.snail.smart.client;

import com.snail.smart.task.GetServerMsgTask;
import com.snail.smart.task.KeepliveTask;
import com.snail.smart.task.SendGiftMsgTask;
import com.snail.smart.task.ServerKeepliveTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;

/**
 * @author snail
 * @create 2017/05/08
 */
public class APP {
    private static final Logger logger = LoggerFactory.getLogger(APP.class);

    public static void main(String[] args){
        //th000:11017   魅力：468241  infi:255865  ted:259057  傻哥：1408482
        int roomId = 1408482, groupId=-9999, userId = 104954726;

        ServerLoginClient loginClient = ServerLoginClient.getInstance();
        loginClient.init(roomId,userId);


        BulletScreenClient client = BulletScreenClient.getInstance();
        client.init(roomId,groupId);

        GetServerMsgTask getMsg = new GetServerMsgTask(loginClient);
        getMsg.start();

    }

    private static void sleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("sleep error,msg={}",e);
        }
    }
}
