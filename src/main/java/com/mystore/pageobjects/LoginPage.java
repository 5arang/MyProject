package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//*[@id='email']")
	WebElement username;

	@FindBy(xpath = "//*[@name='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement signInbtn;

	@FindBy(xpath = "//*[@id='email_create']")
	WebElement emailForNewAccount;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createNewaccountBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uname, String pawd) {
		action.type(username, uname);
		action.type(password, pawd);
		action.click(driver, signInbtn);
		return new HomePage();
	}

	public AddressPage login1(String uname, String pawd) {
		action.type(username, uname);
		action.type(password, pawd);
		action.click(driver, signInbtn);
		return new AddressPage();
	}

	public AccountCreationPage createNewAccount(String newemail) {
		action.type(emailForNewAccount, newemail);
		action.click(driver, createNewaccountBtn);
		return new AccountCreationPage();
	}
}
