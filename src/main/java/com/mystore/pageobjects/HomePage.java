package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//*[contains(text(),'My wishlists')]")
	WebElement wishlist;

	@FindBy(xpath = "//*[contains(text(),'Order history and details')]")
	WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMyWishlist() {
		return action.isDisplayed(driver, wishlist);
	}

	public boolean validateOrderHistory() {
		return action.isDisplayed(driver, orderHistory);
	}

	public String getCurrentURL() {
		String homrPageurl = driver.getCurrentUrl();
		return homrPageurl;
	}
}
