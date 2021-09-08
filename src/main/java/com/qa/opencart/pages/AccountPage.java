package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By accountheaders = By.xpath("//div[@id='content']//h2");
	private By mainheader = By.cssSelector("div#logo a");
	// private By mainheader = By.xpath("//a[contains(text(),'Your Store')]");
	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	

	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getAccpageTitle() {
		return elementUtil.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);

	}

	public String getAccPageUrl() {
		return elementUtil.getPageUrl();

	}

	public String getAccPageHeader() {
		return elementUtil.doGetText(mainheader);
	}

	public List<String> getAccSectionsList() {
		List<String> accSecvalList = new ArrayList<String>();
		List<WebElement> accHeaders = elementUtil.waitForVisibilityOfElements(accountheaders, 5);

		for (WebElement e : accHeaders) {
			accSecvalList.add(e.getText());
		}
		Collections.sort(accSecvalList);
		return accSecvalList;
	}

	public boolean IsLogOutExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}
	
	public SearchResultsPage dosearch(String productName) {
		System.out.println("ProductName is : " + productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}

}
