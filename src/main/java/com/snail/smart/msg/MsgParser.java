package com.snail.smart.msg;

import com.snail.smart.vo.ChatMsg;
import com.snail.smart.vo.LoginMsg;
import com.snail.smart.vo.RedPacketMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author snail
 * @create 2017/04/27
 */
public class MsgParser {
    private static final Logger logger = LoggerFactory.getLogger(MsgParser.class);

    public static void parser(Map<String,Object> content){
        String type = (String) content.get("type");

        if("chatmsg".equals(type)){
            ChatMsg msg = new ChatMsg(content);
            logger.info("聊天消息:{}",msg);
        }else if("gpbc".equals(type)){
            RedPacketMsg msg = new RedPacketMsg(content);
            logger.info("红包消息:{}",msg);
        }else if("loginres".equals(type)){
            LoginMsg msg = new LoginMsg(content);
            logger.info("登录消息:{}",msg);
        }else {
            logger.info("其他消息:{}",content);
        }
    }
}
