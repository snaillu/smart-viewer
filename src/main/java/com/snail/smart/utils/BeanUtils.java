package com.snail.smart.utils;

import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.msg.MsgParser;
import com.snail.smart.vo.RoomParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author snail
 * @create 2017/04/21
 */
public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    public static <T> T createMsg(Map<String,Object> content){
        if(CollectionUtils.isEmpty(content)){
            return null;
        }

        String type = (String) content.get("type");
        T t = MsgParser.getMsg(type);
        if(t==null){
            //logger.warn("unknown msg type,type={}",type);
            return t;
        }

        try{
            Field[] fields = t.getClass().getDeclaredFields();

            for(Field field:fields){
                field.setAccessible(true);
                String val = (String) content.get(field.getName());
                if(StringUtils.isEmpty(val)){
                    continue;
                }

                if(field.getType() == Integer.class || field.getType() == int.class){
                    field.set(t,Integer.parseInt(val));
                }else {
                    field.set(t,val);
                }
            }
        }catch (Exception e){
            logger.error("create msg error,msg={}",e);
        }

        return t;
    }

    //create a object by class
    public static <T> T newInstance(Class cls){
        T t = null;

        try{
            if(cls==null){
                return t;
            }

            t = (T)cls.newInstance();
        }catch (Exception e){
            logger.error("newInstance error,msg={}",e);
        }

        return t;
    }
    //bean to param
    public static <T> String toParam(T t){
        StringBuffer buffer = new StringBuffer();

        try{
            Class cls = t.getClass();
            Field[] fields = cls.getFields();

            int index = 0;
            for(Field field:fields){
                field.setAccessible(true);
                if(index!=0){
                    buffer.append("&");
                }
                index++;
                Object val = field.get(t);
                logger.info("val="+val);
                buffer.append(field.getName()).append("=").append(val);
            }
        }catch (Exception e){
            logger.error("convert bean to param error,msg={}",e);
        }

        return buffer.toString();
    }

    public static void main(String[] args){
        RoomParam param = new RoomParam();
        param.setClient_sys("android");
        param.setLimit(10);
        param.setOffset(0);


        String url = DouYuApiEnum.ALL_LIVE.getApi()+"?"+toParam(param);
        String result = HttpUtils.get(url);
        logger.info("result = "+result);
    }
}
