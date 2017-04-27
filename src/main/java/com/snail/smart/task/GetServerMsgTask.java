package com.snail.smart.task;

import com.snail.smart.client.BulletScreenClient;

/**
 * @author snail
 * @create 2017/04/27
 */
public class GetServerMsgTask extends Thread {

    @Override
    public void run() {
        BulletScreenClient client = BulletScreenClient.getInstance();
        while (client.getIsReady()){
            client.getServerMsg();
        }
    }
}
