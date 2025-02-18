package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class LearnPage extends BaseClass {
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
	
	@FindBy(css = "#HeaderMenu-discover")
    private WebElement discoverDropDownMenu;
	
	@FindBy(css = "#HeaderMenu-discover-featured-learn-about-skincare")
    private WebElement ourStoryPageLink;
	
	@FindBy(css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
    private WebElement LearnTxt;
	
	private WebElement getCards(String category) {
        return driver.findElement(
                By.xpath("//*[@id=\"shopify-section-template--18178515501314__main\"]/div[2]/div[2]/div["+category+"]/div/div/div[2]/div/h3/a"));
    }
	
	@FindBy (xpath = "//*[@id=\"shopify-section-template--18178515501314__rich_text_p7Nmqw\"]/div/div/div/div/div/a")	
	private WebElement ViewProduct;
	
	@FindBy (css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
	private WebElement checkHeader;
	
	public LearnPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void navigateToLearnSkin() {
        Action.click(driver, discoverDropDownMenu);
        Action.explicitWaitForElementTobeclickable(ourStoryPageLink, 5);
        ourStoryPageLink.click();
        extentInfoLog("Clicked on : ", "Learn About Skincare");
    }
	
	public boolean verifyBannerText(String expectedText) {
        String actualText = LearnTxt.getText();
        return actualText.equals(expectedText);
    }
	
	public void checkCards(String testcase, String category, String expectedResult) throws InterruptedException {
		Thread.sleep(2000);
		Action.explicitWait(getCards(category), 15);
		Action.click(driver, getCards(category));
		Action.waitForUrlToContain(driver, expectedResult, 5000);
		String actualResult = driver.getCurrentUrl();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
			} 
		else {
				extentInfoLog("Test case : ", testcase);
				extentInfoLog("Actual URL : ", actualResult);
				extentInfoLog("Expected URL : ", expectedResult);
			}
	}
	
	public void clickOnProduct() {
		Action.explicitWaitForElementTobeclickable(ViewProduct, 10);
		ViewProduct.click();
	}
	
	public void checkBtnLink(String expectedResult) {
		String actualResult = checkHeader.getText();
		//Printing data on report
		extentInfoLog("Actual Text : ", actualResult);
		extentInfoLog("Expected Text : ", expectedResult);
		//Assertion
		Assert.assertEquals(actualResult, expectedResult);
	}

}