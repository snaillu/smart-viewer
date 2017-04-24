package com.snail.smart.service.impl;

import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.utils.BeanUtils;

/**
 * @author snail
 * @create 2017/04/21
 */
public class BaseService {
    protected <T> String getApiUrl(DouYuApiEnum api, T t){
        StringBuffer buffer = new StringBuffer();

        buffer.append(api.getApi()).append("?").append(BeanUtils.toParam(t));
        return buffer.toString();
    }
}
