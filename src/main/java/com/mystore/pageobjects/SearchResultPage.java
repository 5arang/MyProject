package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnproduct() {
		action.click(driver, productResult);
		return new AddToCartPage();
	}

}
