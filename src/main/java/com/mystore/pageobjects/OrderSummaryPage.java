package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath="//*[@class='button btn btn-default button-medium']")
	WebElement conformOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConformationPage clickOnConformOrderBtn() {
		action.click(driver, conformOrderBtn);
		return new OrderConformationPage();
	}
}
