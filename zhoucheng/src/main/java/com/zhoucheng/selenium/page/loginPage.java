package com.zhoucheng.selenium.page;

import com.zhoucheng.selenium.base.DriverBase;
import com.zhoucheng.selenium.utils.GetByLocator;
import org.openqa.selenium.WebElement;


public class loginPage extends BasePage{
	public loginPage(DriverBase driver){
		super(driver);
	}
	/**
	 * 获取用户名输入框
	 * */
	public WebElement getUserElement(){
		return element(GetByLocator.getLocator("username"));
	}
	
	/**
	 * 获取密码输入框Element
	 * */
	public WebElement getPasswordElement(){
		return element(GetByLocator.getLocator("userpass"));
	}
	/**
	 * 获取登陆按钮element
	 * */
	public WebElement getLoginButtonElement(){
		return element(GetByLocator.getLocator("loginbutton"));
	}
	/**
	 * 获取自动登陆element
	 * */
	public WebElement getAutoSigninElement(){
		return element(GetByLocator.getLocator("autoSignin"));
	}
}
