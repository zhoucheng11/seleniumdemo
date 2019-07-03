package com.zhoucheng.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-22 13:13
 */
public class SelectDriver {
    public WebDriver driverName(String browser){
        if(browser.equalsIgnoreCase("firefox")){
//            我放在system32目录下，不用这个
//            System.setProperty("webdriver.firefox.marionette","填写驱动地址");
            return new FirefoxDriver();
        }else {
//            System.setProperty("webdriver.chrome.driver","填写驱动地址");
            return new ChromeDriver();
        }
    }
}
