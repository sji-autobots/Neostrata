package com.neostrata.pageObjects;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

/**
 *	@author : Rashi Tiwari
 *	@Date : 10 Jan 2025
 **/

public class HomePage extends BaseClass {

	@FindBy (css = "div.header__heading-logo-wrapper >img")	
	private WebElement logo;

	@FindBy (xpath = "//section[2]/div/div")	
	private WebElement firstBanner;
	
	@FindBy (xpath = "//section[2]/div[1]/div[1]/div[2]/div[2]/a")	
	private WebElement firstBannerShopNowBtn;

	@FindBy (xpath = "(//button[@aria-label='Close'])[last()]")	
	private WebElement closePopup;
	
	@FindBy (css = ".title.inline-richtext.h2.scroll-trigger.animate--slide-in")	
	private WebElement trendingHeading;
	
	@FindBy (css = "div.product__item.swiper-slide.swiper-slide")	
	private WebElement trendingProducts;
	
	@FindBy (xpath = "//span[contains(text(),'Add to bag')]")	
	private List<WebElement> trendingProductsButtonCheck;
	
	@FindBy (css = "div.section-video-module-wrapper")	
	private WebElement introductionBanner;
	
	@FindBy (xpath = "//div[@class='section-video-module-wrapper']/descendant::div/descendant::a")	
	private WebElement introductionBannerShopNow;
	
	@FindBy (css = "div.holiday-sets-heading-block h2")	
	private WebElement levelUpBanner;
	
	@FindBy (css = "div.holiday-set-block")	
	private WebElement levelUpBannerProduct;
	
	@FindBy (xpath = "//div[@class='set-list--flex']//a[contains(text(),'SHOP NOW')]")	
	private List<WebElement> levelUpBannerProductLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void printDataOnReport(Object actualResult, Object expectedResult) {
        extentInfoLog("Actual result : ", actualResult);
        extentInfoLog("Expected result : ", expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
        extentPassLog("Text matches correctly!","");
    }
	
	public void closePopup() {
		Action.waitFor(3);
		
		if(closePopup.isDisplayed()) {
			closePopup.click();
			closePopup.isDisplayed();
		}
		else {
			extentInfoLog("Popup displayed : ", closePopup.isDisplayed());
		}
	}
	
	public void closeLight() {
	    Action.waitFor(5);
	    Actions actions = new Actions(driver);
	    actions.sendKeys(Keys.ESCAPE).perform();
	    extentInfoLog("Popup displayed after ESC: ", actions);
	}

	public void checkLogo() {
		extentInfoLog("'Logo is displayed : ", logo.isDisplayed());
	}
	
	public void firstBannerVerification(String expUrl) { 
		boolean flag = firstBanner.isDisplayed();
		if(flag==true) {
			extentInfoLog("Clicking on 'Shop Now' button on first banner : ", "");
			firstBannerShopNowBtn.click();
			extentInfoLog("Clicked on 'Shop Now' button : ", "");
			Action.waitForUrlToContain(driver, expUrl, 3);
			extentInfoLog(" URL contains the specified fragment : ",expUrl );
		}
		else {
		extentFailLog("'Banner is displayed : ", firstBanner.isDisplayed());
	}
}
	public void shopTrending(String expText, String productCount) {
		String actualText = trendingHeading.getText();
		home.printDataOnReport(actualText, expText);
	    boolean flag = trendingProducts.isDisplayed();
	    System.out.println(flag);
	    int counter = 0;
	    boolean anyDisabled = false; 
	    for (WebElement button : trendingProductsButtonCheck) {
	        if (button.isEnabled()) {
	            counter++;
	        } else {
	            anyDisabled = true; 
	        }
	    }
	    extentInfoLog("Number of enabled 'Add to Bag' buttons found ", counter);
	    if (anyDisabled) {
	        extentFailLog("Some 'Add to Bag' buttons are disabled. Total: " + (trendingProductsButtonCheck.size() - counter), anyDisabled);
	    } else {
	        extentPassLog("All 'Add to Bag' buttons are enabled.", anyDisabled);
	    }
	}
	
	public void introducingBanner(String expUrl) {
		boolean flag= introductionBanner.isDisplayed();
		if(flag==true) {
			extentPassLog("'Intoducing' banner is displayed : ", flag);
			introductionBannerShopNow.click();
			Action.waitForUrlToContain(driver, expUrl, 3);
			extentInfoLog(" URL contains the specified fragment : ",expUrl);
		}
		else {
			extentFailLog("'Banner is displayed : ", firstBanner.isDisplayed());
		}
	}
	
	public void levelUp(String expText,String index, String expUrl) throws Exception {
		String actText = levelUpBanner.getText();
	    home.printDataOnReport(expText, actText);
	    extentInfoLog("Product banner displayed: ", levelUpBannerProduct.isDisplayed());
	    int indexInt= Integer.parseInt(index);
	    	WebElement element=levelUpBannerProductLink.get(indexInt);
	    	Action.waitFor(4000);
	    	Action.JSClick(driver, element);
	    	Action.waitForUrlToContain(driver, expUrl, 5);
	    }
}
