package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ManualErrorList;

public class AccountsPageTest extends BaseTest {
	WebDriver driver;
	AccountPage accpage;
	
	
	@BeforeClass
	public void AccountSetUp() {
		accpage = loginpage.dologin(prop.getProperty("username"),prop.getProperty("password"));
	//	accpage = new AccountPage(driver);
		
	}
	@Test
	public void AccountPageTitleTest() {
		String title = accpage.getAccpageTitle();
		System.out.println("Account page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE,ManualErrorList.ACC_PAGE_TITLE_ERROR); // last 3rd part is comment if assertion got fail then message will be there.
	}

	@Test
	public void AccountPageHeaderTest() {
		String Header = accpage.getAccPageHeader();
		System.out.println("Account pager Header is : " + Header);
		Assert.assertEquals(Header, Constants.ACCOUNTS_PAGE_HEADER,ManualErrorList.ACC_PAGE_HEADER_ERROR);
	}
	
	@Test
	public void AccountPageUrlTest() {
		Assert.assertTrue(accpage.getAccPageUrl().contains("account/account"));
		
	}
	
	@Test
	public void AccountSectionsListTest() {
		
		List<String> accSecList = accpage.getAccSectionsList();
		accSecList.stream().forEach(e -> System.out.println(e));
		 Collections.sort(Constants.EXP_ACC_SEC_LIST);
		Assert.assertEquals(accSecList,Constants.EXP_ACC_SEC_LIST);
		
	}
	
	@Test
	public void LogoutLink() {
		Assert.assertTrue(accpage.IsLogOutExist());
	}
	
	
	
}
