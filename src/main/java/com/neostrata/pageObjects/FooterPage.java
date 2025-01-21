package com.neostrata.pageObjects;

/**
 *	@author : Shaurya Jaiswal
 *	@Date : 15 Jan 2024
 **/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class FooterPage extends BaseClass{
	
	private WebElement getfooterlinks(String column, String value) {
		return driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--18178513109250__footer\"]/footer/div[1]/div[1]/div[2]/div["+column+"]/ul/li["+value+"]/a"));                                
	}
	
	private WebElement getSocialMedialinks(String value) {
	    return driver.findElements(By.xpath("//a[contains(@href, '" + value + "')]")).get(1);
	}
	
	private WebElement getNewfooterlinks(String value) {
		return driver.findElement(By.xpath ("//div/ul/li["+value+"]/small/a"));
	}
	
	@FindBy (xpath = "//button[@id='ot-sdk-btn']")
	private WebElement customizeCookieSettingsBtn;
	
	@FindBy (xpath = "(//div[@class='ot-tgl'])[1]")
	private WebElement performanceCookie;
	
	@FindBy(xpath = "//div[@class='ot-tgl']/input")
	private List<WebElement> toggleInputs;
	
	@FindBy (xpath = "//button[normalize-space()='Confirm My Choices']")
	private WebElement confirmBtn;
	
	public FooterPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Verifies that clicking a specific footer link redirects to the expected URL.
	 *
	 * @param column         The column identifier to locate the footer link.
	 * @param value          The value associated with the column to identify the specific link.
	 * @param expectedResult The expected URL after the link is clicked.
	 * @throws InterruptedException If the thread sleep is interrupted.
	 */
	public void checkLinks(String column, String value, String expectedResult) throws InterruptedException {
		getfooterlinks(column,value);
		Action.waitFor(2000);
		getfooterlinks(column,value).click();
		extentInfoLog("Clicked on the link : ", getfooterlinks(column,value).getText());
	}
	
	/**
	 * Verifies that clicking a social media link redirects to a URL containing the expected result.
	 *
	 * @param testcase       The identifier for the test case.
	 * @param value          The specific social media link to be tested.
	 * @param expectedResult The expected substring to be present in the URL after redirection.
	 * @throws InterruptedException If the thread sleep is interrupted.
	 */
	public void checkSocialMediaLinks(String testcase, String value, String expectedResult) throws InterruptedException {
			Action.scrollByVisibilityOfElement(driver, getSocialMedialinks(value));
			Action.click(driver, getSocialMedialinks(value));	
			Action.waitForUrlContains(expectedResult, 20);
			extentInfoLog("URL was verified to contain : ", expectedResult);
		}
	
	/**
	 * Verifies that clicking a new footer link redirects to a URL containing the expected result.
	 *
	 * @param testcase       The identifier for the test case.
	 * @param value          The specific footer link to be tested.
	 * @param expectedResult The expected substring to be present in the URL after redirection.
	 */
	public void checkNewFooterLinks(String testcase, String value, String expectedResult) {
		Action.scrollByVisibilityOfElement(driver, getNewfooterlinks(value));
		Action.explicitWait(getNewfooterlinks(value), 20);
		extentInfoLog("Clicking on the link : ",expectedResult );
		getNewfooterlinks(value).click();
		Action.waitForUrlContains(expectedResult, 3);
		extentInfoLog("URL was verified to contain : ", expectedResult);
	}
	
	/**
	 * Customizes cookie settings by selecting the specified number of checkboxes and confirming the selection.
	 * @param checkBox The number of checkboxes expected to be selected.
	 */
	public void customizeCookieSettingAccept(String checkBox) {
		Action.scrollByVisibilityOfElement(driver, customizeCookieSettingsBtn);
		Action.waitFor(3000);
		Action.click(driver, customizeCookieSettingsBtn);
		extentInfoLog("Clicked on : ", customizeCookieSettingsBtn.getText());
		Action.scrollByVisibilityOfElement(driver, performanceCookie);
		Action.waitFor(3000);
		int selectedCount = 0; 
		for (WebElement input : toggleInputs) {
            if (input.isSelected()) { 
                selectedCount++; 
            }
        }
		extentInfoLog("Number of active toggle buttons: ", + selectedCount);
		Assert.assertEquals(selectedCount, Integer.parseInt(checkBox),"All checkboxes were selected");
		extentInfoLog("Clicked on : ", confirmBtn.getText());
		Action.click(driver, confirmBtn);
	}
}