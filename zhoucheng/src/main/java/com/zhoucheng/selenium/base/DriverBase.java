package com.zhoucheng.selenium.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-22 13:07
 */
public class DriverBase {
    public WebDriver driver;
    public DriverBase(String browser){
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }
//    获取driver
    public WebDriver getDriver(){
        return driver;
    }
//    关闭driver
    public void stop(){
        System.out.println("stop driver");
        driver.close();
    }
//    封装find element方法
    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }
//    封装定位一组elements的方法
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }
//    自动截图
    public void takeScreenShot(){
        SimpleDateFormat safor = new SimpleDateFormat("yyyy_mm_dd_HH_mm_ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateToStr = safor.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateToStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(),path);
    }
//    传入参数截图
    public void takeScreenShot(TakesScreenshot driverName,String path){
        String currentPath = System.getProperty("user.dir");//get current work
        File screenshotAs = driverName.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs,new File(currentPath + "\\" + path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }
//    封装get
    public void get(String url){
        driver.get(url);
    }
//    封装返回函数
    public void back(){
        driver.navigate().back();
    }
//    封装点击click
    public void click(WebElement element){
        element.click();
    }
//    获取当前url
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
//    获取标题
    public String getTitle(){
        return driver.getTitle();
    }
//    关闭浏览器
    public void close(){
        driver.close();
    }
//    获取当前窗口列表
    public List<String> getWindowHandles(){
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> handles = new ArrayList<>(windowHandles);
        return handles;
    }
//    获取当前窗口
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
//    切换windows窗口
    public void switchWindows(String name){
        driver.switchTo().window(name);
    }
//    切换alert窗口
    public void switchAlert(){
        driver.switchTo().alert();
    }
//    模态框切换
    public void switchToMode(){
        driver.switchTo().activeElement();
    }
//    移动到元素
    public void action(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
//    获取cookies
    public Set<Cookie> getCookies(){
        return driver.manage().getCookies();
    }
//    删除cookies
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }
//    添加cookies
    public void setCookies(Cookie cookie){
        driver.manage().addCookie(cookie);
    }
}
