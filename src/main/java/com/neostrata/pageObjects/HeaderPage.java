package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class HeaderPage extends BaseClass{

	@FindBy(xpath = "//span[normalize-space()='SHOP SKINCARE']")
	private WebElement shopSkincareDropDownMenu;
	
	@FindBy(xpath = "//span[normalize-space()='BESTSELLERS']")
	private WebElement bestSellerDropDownMenu;
	
	@FindBy(xpath = "//summary[@id='HeaderMenu-discover']//span[contains(text(),'DISCOVER')]")
	 private WebElement discoverDropDownMenu;

	@FindBy(xpath = "//span[normalize-space()='DISCOVER']")
	private WebElement disoverDropDownMenu;
	
	private WebElement getSkincareSubMenus(String category, String subMenu) {
        return driver.findElement(
                By.xpath("//sticky-header[1]/header[1]/nav[1]/ul[1]/li[2]/header-menu[1]/details[1]/div[1]/ul[1]/li["+ category +"]/ul[1]/li[" + subMenu + "]/a"));
    }
	
	private WebElement getBestSellerSubMenus(String subMenu) {
        return driver.findElement(By.xpath("//a[@id=["+ subMenu +"]"));
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

	public void checkShopSkincareDropDownAction(String testcase, String category, String subMenu,String expectedResult) {
		Action.explicitWait(shopSkincareDropDownMenu, 15);
		Action.click(driver,shopSkincareDropDownMenu);
		Action.explicitWait(getSkincareSubMenus(category, subMenu), 15);
		Action.click(driver, getSkincareSubMenus(category, subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
			extentInfoLog("Test case : ", testcase);
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
		}
	
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
	public void discoverDropDownProducts(String testcase, String subMenu,String expectedResult) {
		Action.explicitWait(disoverDropDownMenu, 15);
		Action.click(driver,disoverDropDownMenu);
		Action.explicitWait(getDiscoverSubMenus(subMenu), 15);
		Action.click(driver, getDiscoverSubMenus(subMenu));
		String actualResult = driver.getCurrentUrl();
		Action.waitForUrlToContain(driver, expectedResult, 4);
			extentInfoLog("Test case : ", testcase);
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
		}
	
	}

