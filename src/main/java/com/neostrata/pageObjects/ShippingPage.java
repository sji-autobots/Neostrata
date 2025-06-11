package com.neostrata.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 17 April 2024
 **/

public class ShippingPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"shopify-section-sections--18178513109250__footer\"]/footer/div[1]/div[1]/div[2]/div[3]/ul/li[4]/a")
    private WebElement Shipping;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-sections--18178513109250__footer\"]/footer/div[1]/div[1]/div[2]/div[3]")
    private WebElement getShippingInformation;
	
	@FindBy(css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
    private WebElement shipTxt;
	
	@FindBy(css = "#ref1")
    private WebElement initTxt;
	
	@FindBy(css = "#shopify-section-template--18178515599618__main > div > div > div:nth-child(2) > div > div > div > div:nth-child(1) > div > div > div > p.text-justify")
    private WebElement ratesParaTxt;
	
	@FindBy(css = "#shopify-section-template--18178515599618__main > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > div > div > p:nth-child(10)")
    private WebElement ratesPolicyTxt;
	
	public ShippingPage() {
        PageFactory.initElements(driver, this);
    }
	
	/**
	 * Navigates to the Shipping Information section of the application.
	 * This method scrolls to the Shipping Information element and simulates a click on the Shipping button
	 * @return void
	 */
	public void navigateToShipping() {
        Action.scrollByVisibilityOfElement(driver, getShippingInformation);
        Action.click(driver, Shipping);
        extentInfoLog("Clicked on : ", "Shipping Information");
    }
	
	/**
	 * Verifies that the breadcrumb text matches the expected value.
	 * @param expectedText The expected breadcrumb text to compare against the actual text.
	 * @return boolean Returns true if the actual breadcrumb text matches the expected text; false otherwise.
	 */
	public boolean verifyBreadText(String expectedText) {
        String actualText = shipTxt.getText();
        extentInfoLog("BreadText was : ", "Present");
        Assert.assertEquals(actualText, expectedText);
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the initiatives section text matches the expected value.
	 * @param expectedText The expected initiatives text to compare against the actual text.
	 * @return boolean Returns true if the actual initiatives text matches the expected text; false otherwise.
	 */
	public boolean verifyInitiativesText(String expectedText) {
        String actualText = initTxt.getText();
        extentInfoLog("Initiatives section was : ", "Present");
        Assert.assertEquals(actualText, expectedText);
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the rates paragraph contains the expected substring and matches the full text.
	 * @return boolean Returns true if the actual rates paragraph text exactly equals "NEOSTRATA.com"; false otherwise.
	 */
	public boolean verifyRatesParagraph() {
        String actualText = ratesParaTxt.getText();
        extentInfoLog("Checking if 'apy' is present in the text: ", actualText);
        Assert.assertTrue(actualText.contains("NEOSTRATA.com"), "The text 'NEOSTRATA.com' was not found!");
        return actualText.equals("NEOSTRATA.com");
    }
	
	/**
	 * Verifies that the rates paragraph contains the expected substring and matches the full text.
	 * @return boolean Returns true if the actual rates paragraph text exactly equals "International Shipping Policy"; false otherwise.
	 */
	public boolean verifyRatesPolicy() {
        String actualText = ratesPolicyTxt.getText();
        extentInfoLog("Checking if 'International Shipping Policy' is present in the text: ", actualText);
        Assert.assertTrue(actualText.contains("International Shipping Policy"), "The text 'International Shipping Policy' was not found!");
        return actualText.equals("International Shipping Policy");
    }
}