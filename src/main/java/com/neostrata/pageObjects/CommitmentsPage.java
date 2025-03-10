package com.neostrata.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 24 Jan 2025
 * 
 **/

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class CommitmentsPage extends BaseClass{
	
	@FindBy(css = "#HeaderMenu-discover")
    private WebElement discoverDropDownMenu;
	
	@FindBy(css = "#HeaderMenu-discover-featured-neostrata-commitments")
    private WebElement neoCommitments;
	
	@FindBy(css = "#MainContent > nav > ol > li:nth-child(2) > a > span")
    private WebElement neoTxt;
	
	@FindBy(css = "#Banner-template--18178515009794__image_banner_NXEzgX > div.banner__content.banner__content--middle-left.page-width.scroll-trigger.animate--slide-in > div > h1")
    private WebElement bannerTxt;
	
	@FindBy(css = "#shopify-section-template--18178515009794__rich_text_mGarAP > div > div > div > div > h2")
    private WebElement envTxt;
	
	@FindBy(css = "#ImageWithText--template--18178515009794__image_with_text_EEGLMd > div > h2")
    private WebElement titleOne;
	
	@FindBy(css = "#ImageWithText--template--18178515009794__image_with_text_YnpUix > div > h2")
    private WebElement titleTwo;
	
	@FindBy(css = "#ImageWithText--template--18178515009794__image_with_text_NThVbB > div > h2")
    private WebElement titleThree;
	
	@FindBy(css = "#ImageWithText--template--18178515009794__image_with_text_EEGLMd > div > h2")
    private WebElement banner;
	
	public CommitmentsPage() {
        PageFactory.initElements(driver, this);
    }
	
	/**
	 * Navigates to the commitments section by interacting with the dropdown menu and clicking on the commitments link.
	 * @return void
	 * @timeComplexity O(1) assuming the click and wait actions execute in constant time.
	 */
	public void navigatetocommitment() {
        Action.click(driver, discoverDropDownMenu);
        Action.explicitWaitForElementTobeclickable(neoCommitments, 5);
        neoCommitments.click();
        extentInfoLog("Clicked on : ", "Neostrata Commitments");
    }
	
	/**
	 * Verifies that the displayed breadcrumb text matches the expected text.
	 * @param expectedText The text that is expected to be displayed in the breadcrumb.
	 * @return true if the actual breadcrumb text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyBreadText(String expectedText) {
        String actualText = neoTxt.getText();
        extentInfoLog("BreadText was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the displayed banner text matches the expected text.
	 * @param expectedText The text that is expected to be displayed in the banner.
	 * @return true if the actual banner text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyBannerText(String expectedText) {
        String actualText = bannerTxt.getText();
        extentInfoLog("Banner Text was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the displayed subheading text matches the expected text.
	 * @param expectedText The text that is expected to be displayed in the subheading.
	 * @return true if the actual subheading text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyEnveText(String expectedText) {
        String actualText = envTxt.getText();
        extentInfoLog("Sub heading was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the displayed title text matches the expected text for title one.
	 * @param expectedText The text that is expected to be displayed as title one.
	 * @return true if the actual title text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyTitleOne(String expectedText) {
        String actualText = titleOne.getText();
        extentInfoLog("Title was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the displayed title text matches the expected text for title two.
	 * @param expectedText The text that is expected to be displayed as title two.
	 * @return true if the actual title text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyTitleTwo(String expectedText) {
        String actualText = titleTwo.getText();
        extentInfoLog("Title was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies that the displayed title text matches the expected text for title two.
	 * @param expectedText The text that is expected to be displayed as title two.
	 * @return true if the actual title text matches the expected text; false otherwise.
	 * @timeComplexity O(1) since it involves a simple string comparison.
	 */
	public boolean verifyTitleThree(String expectedText) {
        String actualText = titleThree.getText();
        extentInfoLog("Title was : ", "Present");
        return actualText.equals(expectedText);
    }
	
	/**
	 * Verifies the page layout by checking the counts of images and breadcrumbs, as well as the visibility of the banner.
	 * @param expectedImageCount     The expected number of images on the page.
	 * @param expectedBreadcrumbCount The expected number of breadcrumbs on the page.
	 * @return void
	 * @timeComplexity O(n) where n is the number of <img> and breadcrumb elements, as it requires iterating through the found elements.
	 */
	public void verifyPageLayout(int expectedImageCount, int expectedBreadcrumbCount) {
	    List<WebElement> images = driver.findElements(By.tagName("img"));
	    printAndAssert(images.size(), expectedImageCount);
	    extentInfoLog("Images verified : ", images.size());
	    boolean isBannerDisplayed = banner.isDisplayed();
	    if (isBannerDisplayed) {
	        System.out.println("Banner is present.");
	    }
	    else {
	    	System.out.println("Banner is not present.");
	    }
	    extentInfoLog("Banner is displayed : ", isBannerDisplayed);
	    List<WebElement> breadcrumbs = driver.findElements(By.xpath("//*[@id=\"MainContent\"]/nav/ol/li[2]/a/span")); // Replace with actual locator
	    printAndAssert(breadcrumbs.size(), expectedBreadcrumbCount);
	    extentInfoLog("Breadcrumbs verified : ", breadcrumbs.size());
	}
	
	/**
	 * Prints the actual and expected counts and asserts whether they match.
	 * @param actual   The actual count of elements found.
	 * @param expected The expected count to compare against.
	 * @return void
	 * @timeComplexity O(1) since it only involves a simple comparison and printing.
	 */
	private void printAndAssert(int actual, int expected) {
	    if (actual != expected) {
	        System.out.println("Assertion failed! Expected: " + expected + ", but got: " + actual);
	        throw new AssertionError();
	    } else {
	        System.out.println("Assertion passed! Count matches.");
	    }
	}
	
}
