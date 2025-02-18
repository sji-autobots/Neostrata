package com.neostrata.pageObjects;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 24 Jan 2025
 * 
 **/

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
	
	/**
	 * Navigates to the "Learn About Skincare" page by clicking on the corresponding link in the dropdown menu. It clicks the dropdown menu
	 * to reveal options and then clicks on the "Our Story" page link. It also logs the action performed.
	 * @return void
	 * @timeComplexity O(1) assuming helper methods execute in constant time.
	 **/
	public void navigateToLearnSkin() {
        Action.click(driver, discoverDropDownMenu);
        Action.explicitWaitForElementTobeclickable(ourStoryPageLink, 5);
        ourStoryPageLink.click();
        extentInfoLog("Clicked on : ", "Learn About Skincare");
    }
	
	/**
	 * Verifies if the actual banner text matches the expected text.
	 * This method retrieves the text displayed on a banner and compares it with the provided expected text.
	 * It returns true if the texts match, otherwise false.
	 * @param expectedText The text expected to be displayed on the banner.
	 **@return boolean Returns true if the actual text matches the expected text; otherwise, false.
	 **/
	public boolean verifyBannerText(String expectedText) {
        String actualText = LearnTxt.getText();
        return actualText.equals(expectedText);
    }
	
	/**
	 * Checks the redirection upon clicking a specific card and verifies it against expected results.
	 *
	 * This method simulates user interaction by waiting for a specific card to be clickable, 
	 * clicking on the card, and then checking if the current URL contains the expected result. 
	 * It also handles assertions based on whether the test is being run on BrowserStack.
	 * 
	 * @param testcase       The identifier for the test case being executed.
	 * @param category       The category of cards to be checked.
	 * @param expectedResult The expected substring to be present in the URL after clicking the card.
	 * @throws InterruptedException If the thread sleep is interrupted.
	 * @return void
	 */
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
	
	/**
	 * This method waits for the product view element to become clickable and then simulates 
	 * a click action on it. It ensures that the click only occurs when the element is ready 
	 * for interaction.
	 * @return void
	 */
	public void clickOnProduct() {
		Action.explicitWaitForElementTobeclickable(ViewProduct, 10);
		ViewProduct.click();
	}
	
	/**
	 * This method retrieves the text displayed in the header and compares it with the provided 
	 * expected result. It also logs both the actual and expected text for reporting purposes.
	 * @param expectedResult The text expected to be displayed on the header button.
	 * @return void
	 */
	public void checkBtnLink(String expectedResult) {
		String actualResult = checkHeader.getText();
		//Printing data on report
		extentInfoLog("Actual Text : ", actualResult);
		extentInfoLog("Expected Text : ", expectedResult);
		//Assertion
		Assert.assertEquals(actualResult, expectedResult);
	}
}