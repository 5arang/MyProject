package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	
	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void productAvialibility() {
		ip=new IndexPage();
		srp=ip.searchProduct("t-shirt");
		boolean result=srp.isProductAvailable();
		Assert.assertTrue(result);
	}
	
	

}
