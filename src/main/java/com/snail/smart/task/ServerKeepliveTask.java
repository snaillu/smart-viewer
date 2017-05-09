package com.snail.smart.task;

import com.snail.smart.client.ServerLoginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/04/27
 */
public class ServerKeepliveTask extends Thread {
    private static Logger logger = LoggerFactory.getLogger(ServerKeepliveTask.class);

    @Override
    public void run() {
        ServerLoginClient client = ServerLoginClient.getInstance();
        while (client.isReady()){
            client.keepLive();
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
