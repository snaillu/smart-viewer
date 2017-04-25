package com.snail.smart.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.service.UserService;
import com.snail.smart.utils.HttpUtils;
import com.snail.smart.vo.ServiceResponse;
import com.snail.smart.vo.User;
import com.snail.smart.vo.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author snail
 * @create 2017/04/25
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public ServiceResponse<User> login(UserParam param) {
        ServiceResponse result = new ServiceResponse();

        DouYuApiEnum api = DouYuApiEnum.LOGIN;
        logger.info("{}: param={}",api.getMsg(),param);
        String apiResult = HttpUtils.get(getApiUrl(api,param));
        logger.info("{}: result={}",api.getMsg(),apiResult);
        JSONObject json = JSON.parseObject(apiResult);
        int code = json.getInteger("error");
        if(code==0){
            JSONObject object = json.getJSONObject("data");
            User user = JSON.parseObject(object.toJSONString(),User.class);
            result.setResult(user);
        }else {
            result = ServiceResponse.failResponse();
        }

        return result;
    }
}
