package com.snail.smart.task;

import com.snail.smart.client.ServerLoginClient;
import com.snail.smart.client.SmartClient;
import com.snail.smart.enums.GiftTypeEnum;
import com.snail.smart.utils.Utils;
import com.snail.smart.vo.GiftMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

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

    private static SmartClient smartClient;

    //gift container
    private static Map<Integer,GiftMsg> gifts = new ConcurrentHashMap<Integer, GiftMsg>();

    private static final int GIFT_SLEEP_TIME = 10000;
    private static final int SEND_MSG_HITS = 50;

    private SendGiftMsgTask(SmartClient smartClient){
        this.smartClient = smartClient;
    }

    public static SendGiftMsgTask getInstance(SmartClient smartClient){
        if(instance == null){
            instance = new SendGiftMsgTask(smartClient);
        }

        return instance;
    }

    @Override
    public void run() {
        while (smartClient.isReady()){
            Utils.sleep(GIFT_SLEEP_TIME);
            if(CollectionUtils.isEmpty(gifts)){
                continue;
            }

            Iterator<Map.Entry<Integer,GiftMsg>> it = gifts.entrySet().iterator();
            while (it.hasNext()){
                int size = gifts.size();
                GiftMsg msg = it.next().getValue();
                it.remove();
                if(msg.getHits()>SEND_MSG_HITS){
                    String giftMsg = String.format("感谢「%s」赠送的%d个%s",msg.getNn(),msg.getHits()>0?msg.getHits():1, GiftTypeEnum.getGiftName(msg.getGfid()));
                    logger.info("**************发送礼物消息:{},before size={},after size={}",giftMsg,size,gifts.size());
                    smartClient.sendChatMsg(giftMsg);
                }
            }
        }

    }

    public static void addGift(GiftMsg giftMsg){
        gifts.put(giftMsg.getUid(),giftMsg);
    }
}
