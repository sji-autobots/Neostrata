package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 13 March 2025
 * 
 **/

import com.neostrata.base.BaseClass;

public class OffersPage extends BaseClass{
	
	@FindBy(css = "#HeaderMenu-offers")
    private WebElement Offer;
	
	@FindBy(css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
    private WebElement offerTxt;
	
	private WebElement getBanner(String category) {
        return driver.findElement(
                By.xpath("//*[@id=\"Banner-template--18178514092290__image_banner_"+category+"\"]/div[3]/div/h2"));
    }
	
	@FindBy(css = "#dynamic-section-banner-home-page-banner-scheduled-kadb-1306 > div.dynamic-banner__content > div.--cta-block > a")
    private WebElement bannerOneButton;
	
	@FindBy(css = "#Banner-template--18178514092290__image_banner_YHPhVK > div.banner__content.banner__content--middle-right.page-width.scroll-trigger.animate--slide-in > div > div.banner__buttons > a")
    private WebElement bannerTwoButton;
	
	@FindBy(css = "#Banner-template--18178514092290__image_banner_KmEahY > div.banner__content.banner__content--middle-left.page-width.scroll-trigger.animate--slide-in > div > div.banner__buttons > a")
    private WebElement bannerThreeButton;
	
	@FindBy(css = "#Banner-template--18178514092290__image_banner_bJNW6W > div.banner__content.banner__content--middle-right.page-width.scroll-trigger.animate--slide-in > div > div.banner__buttons > a")
    private WebElement bannerFourButton;
	
	@FindBy(css = "#Banner-template--18178514092290__image_banner_rVgYiQ > div.banner__content.banner__content--middle-left.page-width.scroll-trigger.animate--slide-in > div > div.banner__buttons > a")
    private WebElement bannerFiveButton;
	
	@FindBy(css = "#Banner-template--18178514092290__image_banner_cyPMWH > div.banner__content.banner__content--middle-left.page-width.scroll-trigger.animate--slide-in > div > div.banner__buttons > a")
    private WebElement bannerSixButton;
	
	@FindBy(css = "#shopify-section-template--18178514092290__rich_text_rTC9xi > div > div > div > div > div > p:nth-child(1)")
    private WebElement termsText;
	
	public OffersPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void navigateToOffers() {
        Action.click(driver, Offer);
        extentInfoLog("Clicked on : ", "Offers");
    }
	
	public boolean verifyBreadText(String expectedText) {
        String actualText = offerTxt.getText();
        Assert.assertEquals(actualText, expectedText);
        extentInfoLog("BreadText was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	public void verifyBannerText(String category, String expectedText) {
		Action.explicitWait(getBanner(category), 15);
		Action.click(driver, getBanner(category));
		String actualResult = getBanner(category).getText();
		Assert.assertEquals(actualResult, expectedText);
    }
	
	public void verifyBannerOneButton(String expectedResult) {
		Action.explicitWait(bannerOneButton, 15);
		Action.click(driver, bannerOneButton);
		Action.waitForUrlToContain(driver, expectedResult, 15);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void verifyBannerTwoButton(String expectedResult) {
		Action.moveToElement(driver, bannerTwoButton);
		Action.click(driver, bannerTwoButton);
		Action.waitForUrlToContain(driver, expectedResult, 15);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void verifyBannerThreeButton(String expectedResult) {
		Action.moveToElement(driver, bannerThreeButton);
		Action.click(driver, bannerThreeButton);
		Action.waitForUrlToContain(driver, expectedResult, 15);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void verifyBannerFourButton(String expectedResult) {
		Action.moveToElement(driver, bannerFourButton);
		Action.click(driver, bannerFourButton);
		Action.waitForUrlToContain(driver, expectedResult, 15);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void verifyBannerFiveButton() {
	    Action.moveToElement(driver, bannerFiveButton);
	    Action.click(driver, bannerFiveButton);
	    Action.waitForUrlToContain(driver, "shopify", 15);
	    String actualResult = driver.getCurrentUrl();
	    Assert.assertTrue(actualResult.contains("shopify"), "URL does not contain 'shopy'");
	}
	
	public void verifyBannerSixButton(String expectedResult) {
		Action.moveToElement(driver, bannerSixButton);
		Action.click(driver, bannerSixButton);
		Action.waitForUrlToContain(driver, expectedResult, 15);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void verifyTermsText() {
		Action.moveToElement(driver, termsText);
		String actualResult = termsText.getText();
		Assert.assertTrue(actualResult.contains("Exclusively"), "URL does not contain 'shopy'");
	}
}