package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;

	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}

	@Test(groups="Regression")
	public void verifyTotalPrice() {
		ip = new IndexPage();
		srp = ip.searchProduct("t-shirt");
		atcp = srp.clickOnproduct();
		atcp.enterQuantity("2");
		atcp.selectSize("M");
		atcp.clickOnAddToCart();
		op = atcp.clickCheckout();
		Double unitPrice = op.getUnitPrice();
		Double totalPrice = op.getTotalPrice();
		Double totalExpectedPrice = (unitPrice * 2) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

}
