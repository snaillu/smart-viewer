package com.snail.smart.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

/**
 * @author snail
 * @create 2017/05/11
 */
public class PropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    private String fileName;
    private Properties properties = new Properties();

    public PropertiesUtils(String fileName){
        try{
            this.fileName = fileName;
            properties.load(new FileInputStream(getFilePath()));
        }catch (Exception e){
            logger.error("load file error,fileName={}, msg={}",fileName,e);
        }
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }

    public void setValue(String key, String value){
        try{
            properties.setProperty(key,value);
            Writer writer = new FileWriter(getFilePath(),true);
            properties.store(writer,"setValue");
            writer.close();
        }catch (Exception e){
            logger.error("set value error,msg={}",e);
        }
    }

    private String getFilePath(){
        return PropertiesUtils.class.getClassLoader().getResource(fileName).getFile();
    }

    private String getFilePath(String name){
        return PropertiesUtils.class.getClassLoader().getResource(name).getFile();
    }
}
