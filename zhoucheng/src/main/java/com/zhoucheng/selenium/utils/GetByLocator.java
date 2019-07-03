package com.zhoucheng.selenium.utils;


import org.openqa.selenium.By;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-23 13:32
 */
public class GetByLocator {
    public static By getLocator(String key){
        ProUtil proUtil = new ProUtil("src/main/resources/element.properties");
        String locator = proUtil.getPro(key);
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        if ("id".equalsIgnoreCase(locatorType)){
            return By.id(locatorValue);
        } else if ("name".equalsIgnoreCase(locatorType)){
            return By.name(locatorValue);
        } else if ("tagName".equalsIgnoreCase(locatorType)){
            return By.tagName(locatorValue);
        } else if ("linkText".equalsIgnoreCase(locatorType)){
            return By.linkText(locatorValue);
        } else if ("className".equalsIgnoreCase(locatorType)){
            return By.className(locatorValue);
        } else {
            return By.xpath(locatorValue);
        }
    }
}
