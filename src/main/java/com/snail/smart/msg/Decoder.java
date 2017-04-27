package com.snail.smart.msg;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author snail
 * @create 2017/04/26
 */
public class Decoder {
    private Map<String,Object> content = new HashMap<String, Object>();

    public Decoder(String msg){
        parseMsg(msg);
    }

    public Map<String,Object> getResult(){
        return content;
    }

    private void parseMsg(String msg){
        //remove last '/'
        msg = StringUtils.substringBeforeLast(msg,"/");

        //split param
        String[] params = msg.split("/");

        for(String param:params){
            String key = StringUtils.substringBefore(param,"@=");
            String value = StringUtils.substringAfter(param,"@=");
            content.put(key, com.snail.smart.utils.StringUtils.unescape(value));
        }

    }
}
