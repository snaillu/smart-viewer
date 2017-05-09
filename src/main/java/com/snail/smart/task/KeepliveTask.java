package com.snail.smart.task;

import com.snail.smart.client.BulletScreenClient;
import com.snail.smart.client.ServerLoginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/04/27
 */
public class KeepliveTask extends Thread {
    private static Logger logger = LoggerFactory.getLogger(KeepliveTask.class);

    @Override
    public void run() {
        BulletScreenClient client = BulletScreenClient.getInstance();
        ServerLoginClient loginClient = ServerLoginClient.getInstance();

        while (client.getIsReady()){
            client.keepLive();
            loginClient.keepLive();
            goSleep(45000);
        }
    }

    private void goSleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("keep live sleep error,msg={}",e);
        }
    }
}
