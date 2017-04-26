package com.snail.smart.msg;

import com.snail.smart.utils.StringUtils;

/**
 * @author snail
 * @create 2017/04/26
 */
public class Encoder {
    private StringBuffer buffer = new StringBuffer();

    public Encoder(String type){
        addParam("type",type);
    }

    public byte[] getResult(){
        return StringUtils.getByte(buffer.append('\0').toString());
    }

    public void addParam(String key, Object value){
        buffer.append(StringUtils.escape(key));
        buffer.append("@=");
        if(value instanceof String){
            buffer.append(StringUtils.escape((String)value));
        }else if(value instanceof Integer){
            buffer.append(value);
        }

        buffer.append("/");
    }
}
