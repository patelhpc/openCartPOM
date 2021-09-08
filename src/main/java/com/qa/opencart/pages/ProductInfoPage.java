package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	public CheckoutPage checkoutpage;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails li img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
													
	private By Qty = By.id("input-quantity");
	private By AddtoCartButton = By.id("button-cart");
	private By successMessage  = By.xpath("(//div[@id='product-product']/div)[1]");
	//private By successMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public String getProductHeaderText() {
		return elementUtil.doGetText(productHeader);

	}
	
	public int getProductImagesCount() {
		return elementUtil.getElements(productImages).size();
	}
	
	public Map<String, String> getProductInfo () {
		Map<String,String> productInfoMap = new HashMap<String,String>();
		productInfoMap.put("name", getProductHeaderText());
		
		List<WebElement> metadataList = elementUtil.getElements(productMetaData);
		System.out.println("total product meta data: " + metadataList.size());
		
		for(WebElement e : metadataList) {
			String[] meta = e.getText().split(":");
			String metakey = meta[0].trim();
			String metavalue = meta[1].trim();
			productInfoMap.put(metakey, metavalue);
			
		}
		//Price Meta Data
		List<WebElement> priceMeta = elementUtil.getElements(productPriceMetaData);
		String Price = priceMeta.get(0).getText().trim();
		String ExPrice = priceMeta.get(1).getText().trim();
		
		productInfoMap.put("price", Price);
		productInfoMap.put("exPrice", ExPrice);
		
		return productInfoMap;
				
	}
	
	public void selectQty(String i) {
		elementUtil.doSendKeys(Qty,i);
	}
	
	public CheckoutPage AddToCart() {
		
		elementUtil.doClick(AddtoCartButton);
		return new CheckoutPage(driver);
	}
	
	public String getSuccessMessage() {
		return elementUtil.doGetText(successMessage);
	}
	
	
	
}
