/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author Sarang
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage ip;

	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void verifyLogo() {
		ip = new IndexPage();
		boolean result=ip.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTittle() {
		String actTittle=ip.getTitle();
		Assert.assertEquals(actTittle, "My Store");
	}

}
