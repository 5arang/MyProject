package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;

	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}
	
	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups={"Sanity","Regression"})
	public void addToCart() {
		ip = new IndexPage();
		srp = ip.searchProduct("t-shirt");
		atcp = srp.clickOnproduct();
		atcp.enterQuantity("2");
		atcp.selectSize("M");
		atcp.clickOnAddToCart();
		boolean result = atcp.validateaddToCart();
		Assert.assertTrue(result);
	}
}
