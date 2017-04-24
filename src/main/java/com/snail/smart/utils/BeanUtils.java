package com.snail.smart.utils;

import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.vo.RoomParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author snail
 * @create 2017/04/21
 */
public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

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
