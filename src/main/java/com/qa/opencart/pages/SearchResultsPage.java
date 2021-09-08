package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver;
	ElementUtil elementUtil;

	private By searchItemResults = By.cssSelector("div.product-thumb");
	private By searchItems = By.cssSelector("div.product-thumb h4 a");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public int getSearchResults() {
		return elementUtil.getElements(searchItemResults).size();
	}

	public ProductInfoPage selectProdutFromResults(String productName) {
		List<WebElement> resultsItemList = elementUtil.getElements(searchItems);
		System.out.println("total number of items displayed for : " + productName +" is "+ resultsItemList.size());

		for (WebElement e : resultsItemList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}

}
