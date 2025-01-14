package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.HomeProvider;
import com.neostrata.pageObjects.HomePage;
import com.neostrata.utility.DataProviders;

/**
 *	@author : Rashi Tiwari
 *	@Date : 14 Jan 2024
 **/

public class HomePageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1, dataProvider = "banner", dataProviderClass = HomeProvider.class)
	public void HEADER_verifyHomePageTest(String testcase,String execution) {
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
