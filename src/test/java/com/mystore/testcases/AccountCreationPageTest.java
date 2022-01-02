package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage acp;
	
	
	
	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}

		


	

	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups="Sanity")
	public void verifycreateAccountPageTest() {
		ip=new IndexPage();
		lp=ip.clickOnsignIn();
		acp=lp.createNewAccount("patilsarang177@gmail.com");
		boolean result=acp.validateAccountCreatePage();
		Assert.assertTrue(result);
	}

}
