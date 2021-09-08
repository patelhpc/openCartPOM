package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest{
	
	SoftAssert softAssert = new SoftAssert();
	
	
	@BeforeClass
	public void productsetupTest() {
		accpage = loginpage.dologin(prop.getProperty("username"),prop.getProperty("password")); 
			
	}
	
	@Test(priority = 1)
	public void productCountTest() {
		SearchResPage = accpage.dosearch("iMac");
		Assert.assertTrue(SearchResPage.getSearchResults() > 0);
		
	}
	
	@Test(priority = 2)
	public void productInfoTest() {
		SearchResPage = accpage.dosearch("iMac");
		productInfoPage = SearchResPage.selectProdutFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductHeaderText(),"iMac");
		
	}

	@Test(priority = 3)
	public void productImagesTest() {
		SearchResPage = accpage.dosearch("Macbook");
		productInfoPage = SearchResPage.selectProdutFromResults("MacBook Pro");
		Assert.assertTrue(productInfoPage.getProductImagesCount() == 4);	
	}
	
	@Test(priority = 4)
	public void getProductInfoTest() {
		SearchResPage = accpage.dosearch("Macbook");
		productInfoPage = SearchResPage.selectProdutFromResults("MacBook Pro");
		Map<String,String> actProductMetaData = productInfoPage.getProductInfo();
		actProductMetaData.forEach((k,v) ->  System.out.println(k + " : "+ v));
		
		softAssert.assertEquals(actProductMetaData.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductMetaData.get("Brand"), "Apple");
		softAssert.assertEquals(actProductMetaData.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(actProductMetaData.get("price"), "$2,000.00");

		softAssert.assertAll();
	}
	@Test(priority = 5)
	public void AddtoCartTest() {	
		SearchResPage = accpage.dosearch("Macbook");
		productInfoPage = SearchResPage.selectProdutFromResults("MacBook Pro");
		productInfoPage.selectQty("1");
		productInfoPage.AddToCart();
		System.out.println(productInfoPage.getSuccessMessage());
	}
	
}
