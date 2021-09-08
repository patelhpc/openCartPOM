package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.CheckoutPage;

public class CheckOutTest extends BaseTest {
	
	public CheckoutPage checkoutpage;
	
	@BeforeClass
	public void chekoutpagesetup() {
		accpage = loginpage.dologin(prop.getProperty("username"),prop.getProperty("password")); 
		SearchResPage = accpage.dosearch("MacBook");
		productInfoPage = SearchResPage.selectProdutFromResults("MacBook Pro");
		checkoutpage = productInfoPage.AddToCart();
	}
	
	@Test
	public void CheckOutClickTest() {
		checkoutpage.checkoutClick();
	}
	
	@Test 
	public void CouponCodeCheckTest() {
		checkoutpage.UseCouponCode("50Off");
	}
	@Test
	public void shippingAndTaxesTest() {
		checkoutpage.shippingAndTaxes("Canada","Ontario","L6Y5G6");
		// some manual actions still required.
	}
	

}
