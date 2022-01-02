package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	Action action=new Action();
	
	@FindBy(xpath="//*[@id='cgv']")
	WebElement term;
	
	@FindBy(xpath="//*[@name='processCarrier']")
	WebElement proceedTocheckout;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checktheTerms() {
		action.click(driver, term);
	}
	
	public PaymentPage clickOnProceedToCheckout() {
		action.click(driver, proceedTocheckout);
		return new PaymentPage();
	}

}
