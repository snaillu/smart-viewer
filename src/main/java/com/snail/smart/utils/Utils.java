package com.snail.smart.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/05/09
 */
public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static void sleep(long mils){
        try{
            Thread.sleep(mils);
        }catch (Exception e){
            logger.error("sleep error,msg={}",e);
        }
    }
}
