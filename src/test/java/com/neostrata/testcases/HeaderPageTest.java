package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.HeaderProvider;


public class HeaderPageTest extends BaseClass {
	@BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, dataProvider = "shopskincare", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyShopSkincare(String testcase, String execution, String category, String subMenu,String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closePopup();
            header.checkShopSkincareDropDownAction( testcase,  category,  subMenu,expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
    
    @Test(priority = 2, dataProvider = "bestSeller", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyBestSeller(String testcase, String execution, String subMenu,String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closePopup();
            header.bestSellerDropDownAction(testcase,subMenu,expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
    
    @Test(priority = 3, dataProvider = "discover", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyDiscoverDropdown(String testcase, String execution, String subMenu,String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closePopup();
            header.discoverDropDownOption(testcase,subMenu,expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
    
    @Test(priority = 4, dataProvider = "discoverProducts", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyDiscoverProducts(String testcase, String execution, String subMenu,String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            home.closePopup();
            header.discoverDropDownOption(testcase,subMenu,expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
    
}
