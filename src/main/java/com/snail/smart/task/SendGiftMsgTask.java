package com.snail.smart.task;

import com.snail.smart.client.BulletScreenClient;
import com.snail.smart.client.ServerLoginClient;
import com.snail.smart.enums.GiftTypeEnum;
import com.snail.smart.utils.Utils;
import com.snail.smart.vo.GiftMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author snail
 * @create 2017/05/09
 */
public class SendGiftMsgTask extends Thread  {
    private static final Logger logger = LoggerFactory.getLogger(SendGiftMsgTask.class);

    private static SendGiftMsgTask instance;

    //gift container
    private static Map<Integer,GiftMsg> gifts = new ConcurrentHashMap<Integer, GiftMsg>();

    private static final int GIFT_SLEEP_TIME = 10000;

    private SendGiftMsgTask(){}

    public static SendGiftMsgTask getInstance(){
        if(instance == null){
            instance = new SendGiftMsgTask();
        }

        return instance;
    }

    @Override
    public void run() {
        ServerLoginClient client = ServerLoginClient.getInstance();
        while (client.isReady()){
            Utils.sleep(GIFT_SLEEP_TIME);
            Iterator<Map.Entry<Integer,GiftMsg>> it = gifts.entrySet().iterator();
            while (it.hasNext()){
                int size = gifts.size();
                GiftMsg msg = it.next().getValue();
                it.remove();
                String giftMsg = String.format("感谢「%s」赠送的%d个%s",msg.getNn(),msg.getHits()>0?msg.getHits():1, GiftTypeEnum.getGiftName(msg.getGfid()));
                logger.info("发送礼物消息:{},before size={},after size={}",giftMsg,size,gifts.size());
                //client.chatmessage(giftMsg);

            }
        }

    }

    public void addGift(GiftMsg giftMsg){
        gifts.put(giftMsg.getUid(),giftMsg);
    }
}
