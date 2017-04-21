package com.snail.smart.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author snail
 * @create 2017/04/21
 */
public class HttpUtils {
    public static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static void get(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        try{
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            logger.info(EntityUtils.toString(entity));
        }catch (Exception e){
            logger.error("http get error,msg={}",e);
        }finally {
            try{
                response.close();
            }catch (Exception e){
                logger.error("close http response error,msg={}",e);
            }
        }
    }
}
