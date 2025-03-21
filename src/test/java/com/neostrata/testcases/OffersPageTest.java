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
	
	@Test(priority=2, dataProvider = "bannerText", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerText(String testcase, String execution, String category ,String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerText(category, expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=3, dataProvider = "bannerOneButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerOneBtn(String testcase,String execution, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerOneButton(expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=4, dataProvider = "bannerTwoButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerTwoBtn(String testcase,String execution, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerTwoButton(expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=5, dataProvider = "bannerThreeButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerThreeBtn(String testcase,String execution, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerThreeButton(expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=6, dataProvider = "bannerFourButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerFourBtn(String testcase,String execution, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerFourButton(expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=7, dataProvider = "bannerFiveButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerFiveBtn(String testcase,String execution) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerFiveButton();
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=8, dataProvider = "bannerSixButton", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyBannerSixBtn(String testcase,String execution, String expUrl) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyBannerSixButton(expUrl);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=9, dataProvider = "termsText", dataProviderClass = OffersProvider.class)
	public void Learn_VerifyTermsText(String testcase,String execution) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(3000);
            home.closeLight();
            home.closePopup(); 
            offer.navigateToOffers();
            offer.verifyTermsText();
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
}