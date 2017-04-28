package com.snail.smart.test.service;

import com.snail.smart.client.BulletScreenClient;
import com.snail.smart.task.GetServerMsgTask;
import com.snail.smart.task.KeepliveTask;

/**
 * @author snail
 * @create 2017/04/27
 */
public class AppTest {
    public static void main(String[] args){
        int roomId = 1408482, groupId=-9999;
        BulletScreenClient client = BulletScreenClient.getInstance();
        client.init(roomId,groupId);

        KeepliveTask keeplive = new KeepliveTask();
        keeplive.start();

        GetServerMsgTask getMsg = new GetServerMsgTask();
        getMsg.start();
    }
}
