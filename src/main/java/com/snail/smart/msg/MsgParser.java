package com.snail.smart.msg;

import com.snail.smart.annotation.MsgType;
import com.snail.smart.utils.BeanUtils;
import com.snail.smart.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author snail
 * @create 2017/04/27
 */
public class MsgParser {
    private static final Logger logger = LoggerFactory.getLogger(MsgParser.class);

    public static <T> T parser(Map<String,Object> content){
        T t = BeanUtils.createMsg(content);
        if(t==null){
            logger.info("其他消息:{}",content);
        }else{
            Class cls = t.getClass();
            MsgType msgType = (MsgType) cls.getAnnotation(MsgType.class);
            logger.info("{}:{}",msgType.type(),content);
        }

        return t;
    }

    public static <T> String getMsgType(T t){
        if(t == null){
            return null;
        }

        String type = "";
        try{
            Class cls = t.getClass();
            Field field = cls.getDeclaredField("type");
            type = (String)field.get(t);
        }catch (Exception e){
            logger.error("get msg type error,msg={}",e);
        }

        return type;
    }

    public static <T> T getMsg(String type){
        Class cls = null;

        if("chatmsg".equals(type)){
            cls = ChatMsg.class;
        }else if("dgb".equals(type)){
            cls = GiftMsg.class;
        }else if("gpbc".equals(type)){
            cls = RedPacketMsg.class;
        }else if("loginres".equals(type)){
            cls = LoginMsg.class;
        }else if("uenter".equals(type)){
            cls = UserEnterMsg.class;
        }else if("spbc".equals(type)){
            cls = RoomGiftMsg.class;
        }

        return BeanUtils.newInstance(cls);
    }
}
