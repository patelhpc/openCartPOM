package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	AccountPage accountpage;
	// 1. By locators:

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbutton = By.xpath("//input[@type='submit']");
	private By forgottenPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By registerLink = By.linkText("Register");

	
	// 2. constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver) ;
		}

	// 3. page actions or methods all publics

	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5,Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}

	public boolean isforgotpwdlinkexist() {
		return elementUtil.doIsDisplayed(forgottenPwdLink);
	}

	public AccountPage dologin(String un, String pwd) {
//		driver.findElement(email).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginbutton).click();
		elementUtil.doSendKeys(email, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginbutton);
		
		return new AccountPage(driver);

	}

	public RegistrationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}


	}

