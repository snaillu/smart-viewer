package com.snail.smart.test.utils;

import com.snail.smart.utils.PropertiesUtils;

/**
 * @author snail
 * @create 2017/05/11
 */
public class UtilsTest {
    public static void main(String[] args){
        String fileName = "account.properties";

        PropertiesUtils pu = new PropertiesUtils(fileName);

        System.out.println(pu.getValue("account0002"));
        pu.setValue("account0003","3");

        System.out.println(String.format("%04d",1));
    }
}
