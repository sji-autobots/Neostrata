package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

/**
 *	@author : Rashi Tiwari
 *	@Date : 10 Feb 2025
 **/
public class HeaderPage extends BaseClass{

	@FindBy(xpath = "//span[normalize-space()='SHOP SKINCARE']")
	private WebElement shopSkincareDropDownMenu;

	@FindBy(xpath = "//span[normalize-space()='BESTSELLERS']")
	private WebElement bestSellerDropDownMenu;

	@FindBy(xpath = "//summary[@id='HeaderMenu-discover']//span[contains(text(),'DISCOVER')]")
	private WebElement discoverDropDownMenu;

	@FindBy(xpath = "//span[normalize-space()='DISCOVER']")
	private WebElement disoverDropDownMenu;

	@FindBy(xpath = "//span[normalize-space()='SKINCARE TIPS']")
	private WebElement shopSkincareTipsMenu;

	@FindBy(xpath = "//span[normalize-space()='OFFERS']")
	private WebElement offerMenu;

	private WebElement getSkincareSubMenus(String category, String subMenu) {
		return driver.findElement(
				By.xpath("//sticky-header[1]/header[1]/nav[1]/ul[1]/li[2]/header-menu[1]/details[1]/div[1]/ul[1]/li["+ category +"]/ul[1]/li[" + subMenu + "]/a"));
	}

	private WebElement getSkincareSubMenus(String subMenu) {
		return driver.findElement(By.xpath("//a[@id='HeaderMenu-skincare-tips-featured-" + subMenu + "']"));
	}

	private WebElement getBestSellerSubMenus(String subMenu) {
		return driver.findElement(By.xpath("//a[@id='" + subMenu + "']"));
	}

	private WebElement getDiscoverSubMenus(String subMenu) {
		return driver.findElement(By.xpath("//ul[@class='mega-menu__list page-width']//a[@title=["+ subMenu +"]"));
	}										

	// Constructor to initialize page elements using PageFactory
	public HeaderPage() {
		PageFactory.initElements(driver, this);
	}

	// Assertion Method
	public void assertion(String actualResult, String expectedResult) {
		Assert.assertEquals(actualResult, expectedResult);
	}

	/**
	 * Performs an action to check the skincare dropdown menu functionality 
	 * by selecting a category and a submenu, then verifying the URL 
	 * after the action is performed.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param category      The main category under which the submenu exists.
	 * @param subMenu      The specific submenu to be selected from the dropdown.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * */
	public void checkShopSkincareDropDownAction(String testcase, String category, String subMenu,String expectedResult) {
		Action.explicitWait(shopSkincareDropDownMenu, 15);
		Action.click(driver,shopSkincareDropDownMenu);
		Action.explicitWait(getSkincareSubMenus(category, subMenu), 15);
		Action.click(driver, getSkincareSubMenus(category, subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContainSubString(driver,expectedResult, 4);
		extentInfoLog("Test case : ", testcase);
		extentInfoLog("Actual URL : ", actualResult);
		extentInfoLog("Expected URL : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	/**
	 * Performs an action to check the bestseller dropdown menu functionality 
	 * by selecting a category and a submenu, then verifying the URL 
	 * after the action is performed.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param category      The main category under which the submenu exists.
	 * @param subMenu      The specific submenu to be selected from the dropdown.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * */
	public void bestSellerDropDownAction(String testcase, String subMenu,String expectedResult) {
		Action.explicitWait(bestSellerDropDownMenu, 15);
		Action.click(driver,bestSellerDropDownMenu);
		Action.explicitWait(getBestSellerSubMenus(subMenu), 15);
		Action.click(driver, getBestSellerSubMenus(subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
		extentInfoLog("Test case : ", testcase);
		extentInfoLog("Actual URL : ", actualResult);
		extentInfoLog("Expected URL : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	/**
	 * Performs an action to check the discover dropdown menu functionality 
	 * by selecting a category and a submenu, then verifying the URL 
	 * after the action is performed.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param category      The main category under which the submenu exists.
	 * @param subMenu      The specific submenu to be selected from the dropdown.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * */
	public void discoverDropDownOption(String testcase, String subMenu,String expectedResult) {
		Action.explicitWait(disoverDropDownMenu, 15);
		Action.click(driver,disoverDropDownMenu);
		Action.explicitWait(getBestSellerSubMenus(subMenu), 15);
		Action.click(driver, getBestSellerSubMenus(subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
		extentInfoLog("Test case : ", testcase);
		extentInfoLog("Actual URL : ", actualResult);
		extentInfoLog("Expected URL : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	/**
	 * Performs an action to check the discover dropdown menu functionality 
	 * by selecting a category and a submenu, then verifying the URL 
	 * after the action is performed.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param category      The main category under which the submenu exists.
	 * @param subMenu      The specific submenu to be selected from the dropdown.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * */
	public void discoverDropDownProducts(String testcase, String subMenu,String expectedResult) {
		Action.explicitWait(shopSkincareTipsMenu, 15);
		Action.click(driver,shopSkincareTipsMenu);
		Action.explicitWait(getDiscoverSubMenus(subMenu), 15);
		Action.click(driver, getDiscoverSubMenus(subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
		extentInfoLog("Test case : ", testcase);
		extentInfoLog("Actual URL : ", actualResult);
		extentInfoLog("Expected URL : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	/**
	 * Performs an action to check the skincare tips menu functionality 
	 * by selecting a category and a submenu, then verifying the URL 
	 * after the action is performed.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param category      The main category under which the submenu exists.
	 * @param subMenu      The specific submenu to be selected from the dropdown.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * */
	public void skincareTipsDropDownProducts(String testcase, String subMenu,String expectedResult) {
		Action.explicitWait(shopSkincareTipsMenu, 15);
		Action.click(driver,shopSkincareTipsMenu);
		Action.explicitWait(getSkincareSubMenus(subMenu), 15);
		Action.click(driver, getSkincareSubMenus(subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
		extentInfoLog("Test case : ", testcase);
		extentInfoLog("Actual URL : ", actualResult);
		extentInfoLog("Expected URL : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	/**
	 * Validates the offer menu action by clicking on the offer menu and 
	 * verifying that the resulting URL contains the expected result.
	 *
	 * @param testcase      The identifier for the test case being executed.
	 * @param expectedResult The expected substring to be present in the URL after the action.
	 * @return void
	 * @timeComplexity O(1) assuming helper methods execute in constant time.
	 * */
	public void offerValidation(String testcase,String expectedResult) {
		Action.explicitWait(offerMenu, 15);
		Action.click(driver, offerMenu);
		Action.waitForUrlToContain(driver, expectedResult, 4);
	}
}

