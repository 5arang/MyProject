package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//*[@class='login']")
	WebElement signInbtn;

	@FindBy(xpath = "//*[@id='search_query_top']")
	WebElement searchbox;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchbtn;

	@FindBy(xpath = "//*[@class='logo img-responsive']")
	WebElement Mystorelogo;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnsignIn() {
		action.click(driver, signInbtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return action.isDisplayed(driver, Mystorelogo);
	}

	public String getTitle() {
		String pageTitle = action.getTitle(driver);
		return pageTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		action.type(searchbox, productName);
		action.click(driver, searchbtn);
		return new SearchResultPage();
	}

}
