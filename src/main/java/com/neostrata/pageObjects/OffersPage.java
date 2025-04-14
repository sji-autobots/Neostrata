package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 13 March 2025
 * 
 **/

public class OffersPage extends BaseClass{
	
	@FindBy(css = "#HeaderMenu-offers")
    private WebElement Offer;
	
	@FindBy(css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
    private WebElement offerTxt;
	
	@FindBy(css = "#shopify-section-template--18178514092290__rich_text_krDfnf > div > div > div > div > h2")
    private WebElement offerHeadTxt;
	
	
	@FindBy(css = "#shopify-section-template--18178514092290__rich_text_rTC9xi > div > div > div > div > div > p:nth-child(1)")
    private WebElement termsText;
	
	private WebElement getCards(String uniqueId) {
		return driver.findElement(By.xpath("//*[@id=\"Slide-template--18178514092290__multicolumn_LVzCiK-"+uniqueId+"\"]/div/div[2]/a"));                                
	}
	
	@FindBy(css = "#shopify-section-template--18178514092290__rich_text_XN3jmR > div > div > div > div > h2")
    private WebElement offerTermsTxt;
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
	
	public OffersPage() {
        PageFactory.initElements(driver, this);
    }
	
	/**
	 * Navigates to the Offers section by clicking the designated button.
	 * @return void
	 */
	public void navigateToOffers() {
        Action.click(driver, Offer);
        extentInfoLog("Clicked on : ", "Offers");
    }
	
	/**
	 * Verifies that the breadcrumb text matches the expected value.
	 * @param expectedText The text expected to be present in the breadcrumb.
	 * @return boolean Returns true if the actual breadcrumb text matches the expected text; 
	 */
	public boolean verifyBreadText(String expectedText) {
        String actualText = offerTxt.getText();
        Assert.assertEquals(actualText, expectedText);
        extentInfoLog("BreadText was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the heading text for offers matches the expected value.
	 * @param expectedText The text expected to be present in the offers heading.
	 * @return boolean Returns true if the actual heading text matches the expected text; 
	 */
	public boolean verifyOfferText(String expectedText) {
        String actualText = offerHeadTxt.getText();
        Assert.assertEquals(actualText, expectedText);
        extentInfoLog("Heading was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that clicking on an offer card redirects to the expected URL.
	 * @param uniqueId      The unique identifier for the offer card to be verified.
	 * @param expectedResult The expected URL to which the offer card should redirect.
	 * @return void
	 */
	public void verifyOfferCards(String uniqueId, String expectedResult) {
        Action.scrollByVisibilityOfElement(driver, getCards(uniqueId));
        Action.waitFor(2000);
        Action.click(driver, getCards(uniqueId));
        String actualResult = driver.getCurrentUrl();

        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            Assert.assertEquals(actualResult, expectedResult);
        }
    }
	
	/**
	 * Verifies that the offer terms text matches the expected text.
	 * @param expectedText The expected text that should be present in the offer terms.
	 * @return boolean Returns true if the actual offer terms text matches the expected text; otherwise, false.
	 */
	public boolean verifyOfferTerms(String expectedText) {
        String actualText = offerTermsTxt.getText();
        Assert.assertEquals(actualText, expectedText);
        extentInfoLog("Heading was : ", "Present");
        return actualText.equals(expectedText);
    }
}