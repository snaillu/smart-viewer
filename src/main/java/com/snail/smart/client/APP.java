package com.snail.smart.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/05/08
 */
public class APP {
    private static final Logger logger = LoggerFactory.getLogger(APP.class);

    public static void main(String[] args){
        int roomId = 255865;

        ServerLoginClient client = ServerLoginClient.getInstance();
        client.init(roomId);

        for(int i=0;i<5;i++){
            client.chatmessage();
            sleep(3000);
        }
        //sleep(60000);
    }

    private static void sleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("sleep error,msg={}",e);
        }
    }
}
