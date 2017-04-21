package com.snail.smart.service.impl;

import com.snail.smart.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author snail
 * @create 2017/04/21
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    public void doTest() {
        logger.info("this is a test.");
    }
}
