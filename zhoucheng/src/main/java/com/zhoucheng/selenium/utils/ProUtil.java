package com.zhoucheng.selenium.utils;

import java.io.*;
import java.util.Properties;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-23 13:34
 */
public class ProUtil {
    private Properties properties;
    private String filePath;
//    构造方法
    public ProUtil(String filePath){
        this.filePath = filePath;
        this.properties = readProperties();
    }
//      读取配置文件
    private Properties readProperties() {
        Properties properties = new Properties();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            try {
                properties.load(bufferedInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties;
    }
//    根据key读取关键字内容
    public String getPro(String key){
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        } else {
            System.out.println("你获取的key值不对");
            return null;
        }
    }
//    写入内容
    public void writePro(String key,String value){
        Properties properties = new Properties();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            properties.setProperty(key,value);
            try {
                properties.store(fileOutputStream,key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
