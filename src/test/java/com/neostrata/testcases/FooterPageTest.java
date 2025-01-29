package com.neostrata.testcases;

import com.neostrata.dataprovider.FooterProvider;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neostrata.base.BaseClass;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 15 Jan 2025
 **/

public class FooterPageTest extends BaseClass { 
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}
	
	@Test(priority = 1, dataProvider = "Links", dataProviderClass = FooterProvider.class)
	public void FOOTER_verifyLinks(String testcase, String execution,String column, String value, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closeLight();
            home.closePopup();
            footer.checkLinks(column, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 2, dataProvider = "SocailMedia", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifySocialMediaLinks(String testcase, String execution, String value, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closeLight();
            home.closePopup();
            footer.checkSocialMediaLinks(testcase, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 3, dataProvider = "newLinks", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifyNewLinks(String testcase, String execution, String value, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closeLight();
            home.closePopup();
            footer.checkNewFooterLinks(testcase, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
	
	@Test(priority = 4, dataProvider = "custCookie", dataProviderClass = FooterProvider.class)
	   public void FOOTER_verifyCustomizeCookieSettingsTest(String testcase, String execution, String checkBox) throws InterruptedException {
	       test = test.createNode(testcase);
	       if (execution.equalsIgnoreCase(defaultFlag)) {
	           selectEnv(runOn);
	           home.closeLight();
	           home.closePopup();
	           footer.customizeCookieSettingAccept(checkBox);
	       } else {
	           throw new SkipException("Test skipped : " + testcase);
	       }
	   }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}