package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//*[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//*[@id='group_1']")
	WebElement size;

	@FindBy(xpath = "//*[@name='Submit']")
	WebElement addToCartbtn;

	@FindBy(xpath = "//*[@id='layer_cart']//h2[1]/i")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	WebElement procedeToCheckout;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) {
		action.type(quantity, quantity1);
	}

	public void selectSize(String size1) {
		action.selectByVisibleText(size1, size);
	}

	public void clickOnAddToCart() {
		action.click(driver, addToCartbtn);
	}

	public boolean validateaddToCart() {
		return action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickCheckout() {
		action.JSClick(driver, procedeToCheckout);
		return new OrderPage();
	}
}
