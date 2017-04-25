package com.snail.smart.service;

import com.snail.smart.vo.ServiceResponse;
import com.snail.smart.vo.User;
import com.snail.smart.vo.UserParam;

/**
 * @author snail
 * @create 2017/04/25
 */
public interface UserService {
    public ServiceResponse<User> login(UserParam param);
}
