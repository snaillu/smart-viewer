package com.snail.smart.test.service;

import com.snail.smart.service.UserService;
import com.snail.smart.test.base.BaseTest;
import com.snail.smart.vo.ServiceResponse;
import com.snail.smart.vo.User;
import com.snail.smart.vo.UserParam;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author snail
 * @create 2017/04/25
 */
public class UserServiceTest extends BaseTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void login(){
        UserParam param = new UserParam();
        param.setUsername("超级的大蜗牛");
        param.setPassword("19880812sq");

        ServiceResponse<User> result = userService.login(param);
        logger.info("result={}",result);
    }

    @Test
    public void batchLogin(){
        String userName = "超级蜗牛%04d",pwd = "19880812";
        for(int i=1;i<11;i++){
            UserParam param = new UserParam();
            param.setUsername(String.format(userName,i));
            param.setPassword(pwd);

            ServiceResponse<User> result = userService.login(param);
            System.out.println(String.format("account%04d=%s",i,result.getResult().getUid()));
        }
    }

}
