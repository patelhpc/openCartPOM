package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class CheckoutPage {
	
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	private JavaScriptUtil jsutil;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsutil =new JavaScriptUtil(driver);
	}
	
	
	//private By checkOutBox = By.id("cart-total");
	private By checkOutButton = By.xpath("//span[contains(text(),'Checkout')]");
	
	private By CouponCode_Tab = By.xpath("//a[@class='accordion-toggle']");
	private By Enter_Coupon_code = By.id("input-coupon");
	private By couponCodeButton = By.id("button-coupon");
	
		
	private By shippingTaxes = By.xpath("(//h4[@class = 'panel-title'])[2]");
	
	private By Country = By.id("input-country");
	private By State = By.id("input-zone");
	private By postalCode = By.id("input-postcode");
	private By GetQuote = By.id("button-quote");
	
	private By EndCheckOutButton = By.cssSelector("a.btn-primary");
	private By End_error_msg = By.cssSelector("div.alert-danger");
	
	private By Shipping_pop_up = By.name("shipping_method");
	
	public void checkoutClick() {
		//elementUtil.doActionsContextClick(checkOutBox);
		elementUtil.doActionsClick(checkOutButton);
	}
	
	public void UseCouponCode(String code) {
		elementUtil.doClick(CouponCode_Tab);
		elementUtil.doActionsSendKeys(Enter_Coupon_code,code);
		//elementUtil.doClick(couponCodeButton);
	}

	
	
	public String shippingAndTaxes(String ENcountry,String ENstate,String ENpostalcode) {
		//jsutil.scrollPageDown("400");
		
		jsutil.scrollIntoViewBy(shippingTaxes);
		elementUtil.doClick(shippingTaxes);
		
		elementUtil.waitForElementPresent(Country,10);
		elementUtil.doSelectDropDownValue(Country, ENcountry);
		System.out.println("Value entered : "+ ENcountry) ;
		
		elementUtil.waitForElementPresent(State,10);		
		elementUtil.doSelectDropDownValue(State, ENstate);
		System.out.println("Value entered : "+ ENstate );
		
		elementUtil.doSendKeys(postalCode, ENpostalcode);
		System.out.println("Value entered : "+ ENpostalcode );
		//elementUtil.doClick(GetQuote);
		elementUtil.doClick(EndCheckOutButton);
		
		String Finalmessage = elementUtil.doGetText(End_error_msg);
		System.out.println(Finalmessage);
		return Finalmessage;
		
		}
	
	
	
}


