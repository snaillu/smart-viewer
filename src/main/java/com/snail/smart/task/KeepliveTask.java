package com.snail.smart.task;

import com.snail.smart.client.BaseClient;
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

    private BaseClient baseClient;

    public KeepliveTask(BaseClient baseClient){
        this.baseClient = baseClient;
    }

    @Override
    public void run() {

        while (baseClient.isReady()){
            baseClient.keepLive();
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
