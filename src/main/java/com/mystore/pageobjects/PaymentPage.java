package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//*[@class='bankwire']")
	WebElement bankwireMethod;

	@FindBy(xpath = "//*[@class='cheque']")
	WebElement payBycheck;

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderSummaryPage clickOnPayment() {
		action.click(driver, bankwireMethod);
		return new OrderSummaryPage();
	}
}
