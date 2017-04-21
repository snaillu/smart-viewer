package com.snail.smart.test.service;

import com.snail.smart.service.TestService;
import com.snail.smart.test.base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author snail
 * @create 2017/04/21
 */
public class ClientTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ClientTest.class);

    @Autowired
    private TestService testService;

    @Test
    public void test(){
        testService.doTest();
    }
}
