package com.mystore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConformationPage extends BaseClass {
	
	Action action=new Action();
	
	@FindBy(xpath="//*[contains(text(),'Your order on My Store is complete.')]")
	WebElement conformMessage;
	
	public OrderConformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConformationMessage() {
		String conformMsg= conformMessage.getText();
		return conformMsg;
	}
			 
	

}
