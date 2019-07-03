package com.zhoucheng.selenium.testCase;

import com.zhoucheng.selenium.base.DriverBase;

/**
 * @program: zhoucheng
 * @description:
 * @author: zhoucheng
 * @create: 2019-06-23 15:46
 */
public class CaseBase {
    public DriverBase InitDriver(String browser){
        return new DriverBase(browser);
    }
}
