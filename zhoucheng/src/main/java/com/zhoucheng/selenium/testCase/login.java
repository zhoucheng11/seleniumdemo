package com.zhoucheng.selenium.testCase;

import com.zhoucheng.selenium.base.DriverBase;
import com.zhoucheng.selenium.business.HomePagePro;
import com.zhoucheng.selenium.business.LoginPro;
import com.zhoucheng.selenium.utils.HandleCookie;
import com.zhoucheng.selenium.utils.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login extends CaseBase {
	public DriverBase driver;
	public LoginPro loginpro;
	private HomePagePro homepagepro;
	public ProUtil pro;
	public HandleCookie handcookie;


	@BeforeClass
	public void loginTest() {
		pro = new ProUtil("src/main/resources/loginTest.properties");
		this.driver = InitDriver(pro.getPro("driver"));
		driver.driver.manage().window().maximize();
		driver.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		loginpro = new LoginPro(driver);
		homepagepro = new HomePagePro(driver);
	}

	@Test
	public void testLoginHome(){
		driver.get(pro.getPro("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homepagepro.clickLoginButton();
	}
	@Test(dependsOnMethods = {"testLoginHome"})
	public void testLogin() {
		String username = pro.getPro("username");
		String passwd = pro.getPro("passwd");
		loginpro.login(username, passwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(homepagepro.AssertLogin(pro.getPro("yq"))){
			System.out.println("登陆成功"+username);
			handcookie.writeCookie();
		}
	}

	@AfterClass
	public void clodse() {
		driver.close();
	}
}