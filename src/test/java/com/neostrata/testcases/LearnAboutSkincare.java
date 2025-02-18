package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.LearnSkincareProvider;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 28 Jan 2025
 **/


public class LearnAboutSkincare extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1, dataProvider = "BreadText", dataProviderClass = LearnSkincareProvider.class)
	public void Learn_VerifyBanner(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(5);
            home.closeLight();
            home.closePopup();
            learn.navigateToLearnSkin();
            learn.verifyBannerText(expText);   
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority = 2, dataProvider = "Header", dataProviderClass = LearnSkincareProvider.class)
    public void Learn_VerifyCards(String testcase, String execution, String category, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(5000);
            home.closeLight();
            home.closePopup();
            learn.navigateToLearnSkin();
            learn.checkCards(testcase, category, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 3, dataProvider = "ViewBtn", dataProviderClass = LearnSkincareProvider.class)
    public void Learn_VerifyBtn(String testcase, String execution, String expText) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(5000);
            home.closeLight();
            home.closePopup();
            learn.navigateToLearnSkin();
            learn.clickOnProduct();
            learn.checkBtnLink(expText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
}