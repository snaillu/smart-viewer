package com.snail.smart.annotation;

import java.lang.annotation.*;

/**
 * @author snail
 * @create 2017/04/28
 */
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MsgType {
    public String type() default "消息";
}
