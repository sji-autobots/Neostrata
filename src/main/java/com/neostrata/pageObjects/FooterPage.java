package com.neostrata.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class FooterPage extends BaseClass{
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
	
	//xpath for footer links
	private WebElement getfooterlinks(String column, String value) {
		return driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--18178513109250__footer\"]/footer/div[1]/div[1]/div[2]/div["+column+"]/ul/li["+value+"]/a"));                                
	}
	
	//xpath for social media links
	private WebElement getSocialMedialinks(String value) {
	    return driver.findElements(By.xpath("//a[contains(@href, '" + value + "')]")).get(1);
	}
	
	//xpath for nav links
	private WebElement getNewfooterlinks(String value) {
		return driver.findElement(By.xpath ("//div/ul/li["+value+"]/small/a"));
	}
	
	//xapth for cookie button
	@FindBy (xpath = "//button[@id='ot-sdk-btn']")
	private WebElement customizeCookieSettingsBtn;
	
	//xpath for preferences switches in cookie box
	@FindBy (xpath = "(//div[@class='ot-tgl'])[1]")
	private WebElement performanceCookie;
	
	//xpath for input elements inside toggle buttons
	@FindBy(xpath = "//div[@class='ot-tgl']/input")
	private List<WebElement> toggleInputs;
	
	//xpath for confirm button in cookie box
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
		String actualResult;
		Action.explicitWait(getfooterlinks(column,value), 15);
		Thread.sleep(3000);
		getfooterlinks(column,value).click();
		extentInfoLog("Clicked on the link : ", getfooterlinks(column,value).getText());
		actualResult = driver.getCurrentUrl();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		}
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
		//	Action.scrollByPixels(driver, 2000);
			Action.scrollByVisibilityOfElement(driver, getSocialMedialinks(value));
			Action.click(driver, getSocialMedialinks(value));	
			Thread.sleep(4000);
			Action.waitForUrlContains(expectedResult, 3);
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
		Action.explicitWait(getNewfooterlinks(value), 10);
		Action.waitFor(3000);
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
		boolean actualResult = confirmBtn.isDisplayed();
		extentInfoLog("Clicked on : ", confirmBtn.getText());
		Action.click(driver, confirmBtn);
		if (runOnBrowserstack.contains("Yes")) {
			this.assertFalseBS(actualResult, "'Confirm button' Button displayed", "'Confirm button' Button not displayed");
		} else {
			extentInfoLog("Is 'Confirm button' button displayed after clicking on 'Confirm button' button : ", actualResult);
		}
	}
}