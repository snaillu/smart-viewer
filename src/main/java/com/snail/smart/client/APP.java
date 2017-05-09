package com.snail.smart.client;

import com.snail.smart.task.GetServerMsgTask;
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
        int roomId = 468241, userId = 104954726;
        SmartClient client = new SmartClient(roomId,userId,false);

        GetServerMsgTask task = new GetServerMsgTask(client);
        task.start();

    }

    private static void sleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("sleep error,msg={}",e);
        }
    }
}
