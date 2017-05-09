package com.snail.smart.task;

import com.snail.smart.client.BulletScreenClient;
import com.snail.smart.client.ServerLoginClient;
import com.snail.smart.client.SmartClient;
import com.snail.smart.msg.Decoder;
import com.snail.smart.msg.MsgParser;
import com.snail.smart.vo.GiftMsg;
import com.snail.smart.vo.UserEnterMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author snail
 * @create 2017/04/27
 */
public class GetServerMsgTask extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(GetServerMsgTask.class);

    private SmartClient client;

    public GetServerMsgTask(SmartClient client){
        this.client = client;
    }

    @Override
    public void run() {
        while (client.isReady()){
            List<Decoder> msgList = client.getBulletMsg();
            parseMsg(msgList);
        }
    }

    private <T> void  parseMsg(List<Decoder> msgList){
        if(CollectionUtils.isEmpty(msgList)){
            return;
        }

        for(Decoder decoder:msgList){
            T t = MsgParser.parser(decoder.getResult());
            String type = (String) decoder.getResult().get("type");
            getMsg(t,type);
        }
    }

    private <T> String getMsg(T t,String type){
        String msg = null;
        if("dgb".equals(type)){
            GiftMsg giftMsg = (GiftMsg)t;
            if(client.isSendMsg()){
                SendGiftMsgTask.addGift(giftMsg);
            }
            //msg = String.format("感谢%s赠送的%d个%s",giftMsg.getNn(),giftMsg.getHits(), GiftTypeEnum.getGiftName(giftMsg.getGfid()));
        }else if("uenter".equals(type)){
            UserEnterMsg userEnterMsg = (UserEnterMsg)t;
            msg = String.format("欢迎「%s」来到直播间",userEnterMsg.getNn());
        }

        return msg;
    }
}
