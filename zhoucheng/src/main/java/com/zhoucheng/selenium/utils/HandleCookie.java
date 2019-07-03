package com.zhoucheng.selenium.utils;

import com.zhoucheng.selenium.base.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.Set;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-23 14:46
 */
public class HandleCookie {
    public DriverBase driver;
    public ProUtil pro;
    public HandleCookie(DriverBase driver){
        this.driver = driver;
        pro = new ProUtil("cookie.properties");
    }
    public void setCookie(){
        String value = pro.getPro("apsid");
        Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
        driver.setCookies(cookie);
    }
    /**
     * 获取cookie
     * */
    public void writeCookie(){
        Set<Cookie> cookies = driver.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("apsid")){
                pro.writePro(cookie.getName(), cookie.getValue());
            }
        }
    }
}
