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
 * @author : Rashi Tiwari
 * @Date : 21 Jan 2024
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

	@Test(priority = 1, dataProvider = "logo", dataProviderClass = HomeProvider.class)
	public void HOME_verifyLogoTest(String testcase, String execution) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.checkLogo();
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "firstbanner", dataProviderClass = HomeProvider.class)
	public void HOME_verifyFirstBanner(String testcase, String execution, String expUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.firstBannerVerification(expUrl);
			;
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "trending", dataProviderClass = HomeProvider.class)
	public void HOME_verifyTrendingSection(String testcase, String execution, String expText, String productCount) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.shopTrending(expText, productCount);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "introduction", dataProviderClass = HomeProvider.class)
	public void HOME_verifyIntroductionSection(String testcase, String execution, String expUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.introducingBanner(expUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "levelUp", dataProviderClass = HomeProvider.class)
	public void HOME_verifyLevelUpSection(String testcase, String execution, String expText, String index,
			String expUrl) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.levelUp(expText, index, expUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 6, dataProvider = "winter", dataProviderClass = HomeProvider.class)
	public void HOME_verifyLevelUpSection(String testcase, String execution, String expUrl) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.saveForWinterBanner(expUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 7, dataProvider = "awardWinner", dataProviderClass = HomeProvider.class)
	public void HOME_verifyAwardWinner(String testcase, String execution, String expText, String index, String expUrl)
			throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.awardWinner(expText, index, expUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 8, dataProvider = "specialOffer", dataProviderClass = HomeProvider.class)
	public void HOME_verifySpecialOffer(String testcase, String execution, String expText) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.specialOffer(expText);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 9, dataProvider = "glow", dataProviderClass = HomeProvider.class)
	public void HOME_verifyGlow(String testcase, String execution, String expText) throws Exception {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePopup();
			home.glow(expText);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
}