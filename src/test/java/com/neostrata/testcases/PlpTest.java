package com.neostrata.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.neostrata.base.BaseClass;
import com.neostrata.dataprovider.PlpProvider;

public class PlpTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "sort", dataProviderClass = PlpProvider.class)
	public void PLP_verifySortFilter(String testcase, String execution,String subMenu, String expectedResult, String option, String ExpRes) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closeLight();
			home.closePopup();
			header.bestSellerDropDownAction(testcase,subMenu,expectedResult);
			plp.selectSortByFilter(option, ExpRes);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 2, dataProvider = "category", dataProviderClass = PlpProvider.class)
	public void PLP_verifyCategoryFilter(String testcase, String execution,String subMenu, String expectedResult, String option, String ExpRes) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closeLight();
			home.closePopup();
			header.bestSellerDropDownAction(testcase,subMenu,expectedResult);
			plp.selectCategoryFilter( option,  ExpRes);
			
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 3, dataProvider = "ingredients", dataProviderClass = PlpProvider.class)
	public void PLP_verifyCategoryFilter(String testcase, String execution, String option, String expectedResult) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closeLight();
			home.closePopup();
			plp.navigateToBestsellers();
			plp.selectIngredients(option, expectedResult);		
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 4, dataProvider = "pageLayout", dataProviderClass = PlpProvider.class)
	public void PLP_verifyPageLayout(String testcase, String execution, String breadcrumbcount) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closeLight();
			home.closePopup();
			plp.navigateToBestsellers();
			int breadcrumbCountInt = Integer.parseInt(breadcrumbcount);
            plp.verifyPageLayout(65, breadcrumbCountInt);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
}        