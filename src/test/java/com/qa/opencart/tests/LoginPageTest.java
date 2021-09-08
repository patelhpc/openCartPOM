package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitletest() {
		String loginpagetitle = loginpage.getLoginPageTitle();
		System.out.println("loginpage Title : ");
		Assert.assertEquals(loginpagetitle, "Account Login");
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String loginpageUrl = loginpage.getLoginPageUrl();
		System.out.println("LoginPageUrl : " + loginpageUrl);
		Assert.assertTrue(loginpageUrl.contains("account/login"));
	}

	@Test(priority = 3)
	public void ForgotPwdLink() {
		Assert.assertTrue(loginpage.isforgotpwdlinkexist());

	}

	@Test(priority = 4)
	public void logintest() {
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));

//		loginpage.dologin("seleniumtesting@tmail.com","selenium@1234");

	}

}
