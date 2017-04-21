package com.snail.smart.test.base;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author snail
 * @create 2017/04/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/appcontext-core.xml"})
public abstract class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
}
