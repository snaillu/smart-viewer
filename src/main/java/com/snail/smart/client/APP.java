package com.snail.smart.client;

import com.snail.smart.task.GetServerMsgTask;
import com.snail.smart.task.KeepliveTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/05/08
 */
public class APP {
    private static final Logger logger = LoggerFactory.getLogger(APP.class);

    public static void main(String[] args){
        //th000:11017   魅力：468241  infi:255865  ted:259057  傻哥：1408482
        int roomId = 1408482, groupId=-9999;

        ServerLoginClient loginClient = ServerLoginClient.getInstance();
        loginClient.init(roomId);
//        loginClient.chatmessage("蜗牛");
//        sleep(3000);


        BulletScreenClient client = BulletScreenClient.getInstance();
        client.init(roomId,groupId);

        KeepliveTask keeplive = new KeepliveTask();
        keeplive.start();

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
