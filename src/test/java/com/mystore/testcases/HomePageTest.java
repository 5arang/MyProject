/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Sarang
 *
 */
public class HomePageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	
	@BeforeMethod(groups= {"Sanity","Regression","Smoke"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups= {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void wishlistTest() {
		ip=new IndexPage();
		lp=ip.clickOnsignIn();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=hp.validateMyWishlist();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="Smoke")
	public void orderHistoryandDetailTest() {
		ip=new IndexPage();
		lp=ip.clickOnsignIn();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=hp.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
	
	

}
