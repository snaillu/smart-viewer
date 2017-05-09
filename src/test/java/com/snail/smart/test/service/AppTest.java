package com.snail.smart.test.service;


import com.snail.smart.msg.ClientMsg;
import com.snail.smart.utils.StringUtils;

/**
 * @author snail
 * @create 2017/04/27
 */
public class AppTest {
    public static void main(String[] args){
        String str = "蜗牛";
        byte[] bytes = str.getBytes();



        print(bytes);

        System.out.println();
        System.out.println("**********************");
        String[] byteStr = {"11101000","10011100","10010111","11100111","10001001","10011011"};

        byte[] bytes1 = new byte[6];
        for(int i=0;i<byteStr.length;i++){
            bytes1[i] = BitToByte(byteStr[i]);
        }

        print(bytes1);

        System.out.println(new String(bytes1));

        byte[] bytes2 = StringUtils.getByte("蜗牛");
        System.out.println();
        System.out.println("**********************");
        print(bytes2);

    }

    private static void print(byte[] bytes){
        for(byte b:bytes){
            System.out.print(b+"  ");
        }
    }

    public static byte BitToByte(String byteStr) {
        int re, len;
        if (null == byteStr) {
            return 0;
        }
        len = byteStr.length();
        if (len != 4 && len != 8) {
            return 0;
        }
        if (len == 8) {// 8 bit处理
            if (byteStr.charAt(0) == '0') {// 正数
                re = Integer.parseInt(byteStr, 2);
            } else {// 负数
                re = Integer.parseInt(byteStr, 2) - 256;
            }
        } else {//4 bit处理
            re = Integer.parseInt(byteStr, 2);
        }
        return (byte) re;
    }
}
