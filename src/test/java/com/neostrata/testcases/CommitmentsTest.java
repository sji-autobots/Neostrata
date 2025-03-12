package com.neostrata.testcases;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 03 March 2025
 **/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.neostrata.actionDriver.Action;
import org.testng.SkipException;
import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.CommitmentsProvider;

public class CommitmentsTest extends BaseClass{

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1, dataProvider = "breadText", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifyBreadText(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(4000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyBreadText(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=2, dataProvider = "bannerText", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifyBannerText(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(4000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyBannerText(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=3, dataProvider = "enveText", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifySubHeading(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(1000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyEnveText(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=4, dataProvider = "subHeadOne", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifySubHeadTitleOne(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(1000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyTitleOne(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=5, dataProvider = "subHeadTwo", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifySubHeadTitleTwo(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(1000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyTitleTwo(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority=6, dataProvider = "subHeadThree", dataProviderClass = CommitmentsProvider.class)
	public void Learn_VerifySubHeadTitleThree(String testcase,String execution, String expText) throws InterruptedException {
		test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(1000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            commitment.verifyTitleThree(expText);
        }
        else {
            throw new SkipException("Test skipped : " + testcase);
        }
	}
	
	@Test(priority = 7, dataProvider = "pageLayout", dataProviderClass = CommitmentsProvider.class)
    public void PLP_verifypageLayout(String testcase, String execution, String breadcrumbcount) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            Action.waitFor(1000);
            home.closeLight();
            home.closePopup(); 
            commitment.navigatetocommitment();
            int breadcrumbCountInt = Integer.parseInt(breadcrumbcount);
            commitment.verifyPageLayout(38, breadcrumbCountInt);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
}
