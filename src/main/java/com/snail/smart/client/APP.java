package com.snail.smart.client;

import com.snail.smart.task.GetServerMsgTask;
import com.snail.smart.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snail
 * @create 2017/05/08
 */
public class APP {
    private static final Logger logger = LoggerFactory.getLogger(APP.class);

    public static void main(String[] args){
        //th000:11017   魅力：468241  infi:255865  ted:259057  傻哥：1408482
        int roomId = 1408482, userId = 104954726;
        SmartClient client = new SmartClient(roomId,userId,false);

        GetServerMsgTask task = new GetServerMsgTask(client);
        task.start();

//        PropertiesUtils config = new PropertiesUtils("account.properties");
//        List<SmartClient> clients = new ArrayList<SmartClient>();
//        for(int i=1;i<11;i++){
//            int uId = Integer.parseInt(config.getValue(String.format("account%04d",i)));
//            SmartClient userClient = new SmartClient(roomId,uId,false);
//            clients.add(userClient);
//        }

    }

    private static void sleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("sleep error,msg={}",e);
        }
    }
}
