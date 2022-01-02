package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//*[@name='processAddress']")
	WebElement proceedToCheckout;

	public AddressPage() {
		PageFactory.initElements(driver, this);
	}

	public ShippingPage clickOnCheckout() {
		action.click(driver, proceedToCheckout);
		return new ShippingPage();
	}

}
