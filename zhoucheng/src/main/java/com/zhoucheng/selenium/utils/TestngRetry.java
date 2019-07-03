package com.zhoucheng.selenium.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-23 14:08
 */
public class TestngRetry implements IRetryAnalyzer {
    private static int maxRetryCount = 3;
    private int retryCount = 1;
    @Override
    public boolean retry(ITestResult result){
        System.out.println(result);
        if (retryCount <= maxRetryCount){
            String message = "Runnning retry for"
                    + result.getName()
                    + "' on class"
                    + this.getClass().getName()
                    + "Retrying "
                    + retryCount
                    + "times";
            Reporter.setCurrentTestResult(result);
            Reporter.log("RunCount = " + (retryCount + 1));
            retryCount ++;
            return true;
        }
        return false;
    }
}
