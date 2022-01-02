package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConformationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	LoginPage lp;
	AddressPage ap;
	ShippingPage sp;
	PaymentPage pp;
	OrderSummaryPage osp;
	OrderConformationPage ocp;

	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}
	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Regression")
	public void endToEndTest() {
		ip=new IndexPage();
		srp = ip.searchProduct("t-shirt");
		atcp = srp.clickOnproduct();
		atcp.enterQuantity("2");
		atcp.selectSize("M");
		atcp.clickOnAddToCart();
		op = atcp.clickCheckout();
		lp=op.clickOnCheckout();
		ap=lp.login1(prop.getProperty("username"), prop.getProperty("password"));
		sp=ap.clickOnCheckout();
		sp.checktheTerms();
		pp=sp.clickOnProceedToCheckout();
		osp=pp.clickOnPayment();
		ocp=osp.clickOnConformOrderBtn();
		String actualMsg=ocp.validateConformationMessage();
		String expecteMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expecteMsg);
	}

}
