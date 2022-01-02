package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	Action action=new Action();
	
	@FindBy(xpath="//*[@id='product_price_1_1_622720']")
	WebElement unitPrice;
	
	@FindBy(xpath="//*[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/a[1]")
	WebElement proceedtoCheckout;
	
	
	public  OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=unitPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckout() {
		action.click(driver, proceedtoCheckout);
		return new LoginPage();
	}
	
	
	
}
