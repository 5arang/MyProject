/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Sarang
 *
 */
public class LoginPageTest extends BaseClass {
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
	
	@Test(dataProvider="credentials", dataProviderClass=DataProvider.class, groups= {"Smoke","Sanity"})
	public void loginTest(String unae,String pwd) {
		Log.startTestCase("loginTest");
		ip=new IndexPage();
		Log.info("User is going to click on singnin.");
		lp=ip.clickOnsignIn();
		Log.info("enter user name and password.");
//		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=lp.login(unae, pwd);
		String actualURL=hp.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("verifying if user is able to login.");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("login successful.");
		
	}

}
