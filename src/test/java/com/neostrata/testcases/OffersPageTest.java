package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.neostrata.base.BaseClass;
import org.testng.annotations.Test;
import com.neostrata.dataprovider.OffersProvider;
import com.neostrata.actionDriver.Action;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 12 March 2025
 **/

public class OffersPageTest extends BaseClass{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1, dataProvider = "breadText", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBreadText(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBreadText(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=2, dataProvider = "headText", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyOfferText(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyOfferText(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=3, dataProvider = "cardContent", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyOfferCards(String testcase,String execution, String uniqueId, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyOfferCards(uniqueId, expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=4, dataProvider = "offerTerms", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyOfferTerms(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyOfferTerms(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
}