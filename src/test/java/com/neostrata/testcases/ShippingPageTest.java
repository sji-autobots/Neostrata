package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.ShippingProvider;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 17 April 2025
 **/

public class ShippingPageTest extends BaseClass{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1, dataProvider = "shippingInfoPageBreadText", dataProviderClass = ShippingProvider.class)
	public void Shipping_verifyRedirect(String testcase, String execution, String expText) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup();
            shipping.navigateToShipping();
            shipping.verifyBreadText(expText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 2, dataProvider = "shippingInitiatives", dataProviderClass = ShippingProvider.class)
	public void Shipping_verifyInitiativesSection(String testcase, String execution, String expText) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup();
            shipping.navigateToShipping();
            shipping.verifyInitiativesText(expText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 3, dataProvider = "shippingRates", dataProviderClass = ShippingProvider.class)
	public void Shipping_verifyRatesSection(String testcase, String execution) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup();
            shipping.navigateToShipping();
            shipping.verifyRatesParagraph();
            shipping.verifyRatesPolicy();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
}