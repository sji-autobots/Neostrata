package com.resuable.testCases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.resuable.base.BaseClass;
import com.resuable.dataProvider.DataProviders;
import com.resuable.pageObjects.HomePage;

/**
 *	@author : Vaibhav Nagvekar
 *	@Date : 06 Feb 2022
 **/

public class HomePageTest extends BaseClass {

	HomePage login;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
		home = new HomePage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1, dataProvider = "login", dataProviderClass = DataProviders.class, enabled=true)
	public void HEADER_verifySearchBoxTest(String testcase,String execution) {
		 test = test.createNode(testcase);
	        if (execution.equalsIgnoreCase(defaultFlag)) {
	            selectEnv(runOn);
	            home.checkLogo();
	}
	        else {
	            throw new SkipException("Test skipped : " + testcase);
	        }
}
}
