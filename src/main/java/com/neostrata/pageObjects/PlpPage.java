package com.neostrata.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class PlpPage extends BaseClass {

	@FindBy(css = "#SortBy")
	private WebElement sortByDropdown;
	
	@FindBy(xpath = "(//*[@id='component-shop-skincare-menu'])[1]")
	private WebElement refineDropdown;
	
	@FindBy(css = "#HeaderMenu-bestsellers")
	private WebElement bestsellerDropDown;
	
	@FindBy(css = "#HeaderMenu-bestsellers-discover-bestsellers")
	private WebElement bestsellerPageLink;
	
	public WebElement getFilterLabel(String labelText) {
		return driver.findElement(
				By.xpath("//div[@id='FacetsWrapperDesktop']//a[@class='facet-checkbox__text-label'][normalize-space()='"
						+ labelText + "']"));
	}
	
	@FindBy(xpath = "//span[@class='facets__summary-label'][normalize-space()='Ingredients']")
	private WebElement ingredientsBtn;
	
	private WebElement ingredientsFiltercheckboxForProduct(Object productName) {
		return driver.findElement(By.xpath("//*[@id=\"Facet-1-template--18178516746498__product-grid\"]/fieldset/ul/li["+productName+"]/label/span[1]/span"));
	}
	
	@FindBy(css = "#dynamic-section-banner-best-sellers-default > a")
    private WebElement banner;
	
	private By imageLocator = By.tagName("img");
	
	private By breadcrumbLocator = By.xpath("//*[@id=\"MainContent\"]/nav/ol/li[2]/a/span");
	
	public PlpPage() {
        PageFactory.initElements(driver, this);
    }
	
	/**
	 * Navigates to the Bestsellers page by clicking on the Bestsellers dropdown and then selecting the Bestsellers page link.
	 * @return void
	 */
	public void navigateToBestsellers() {
        Action.click(driver, bestsellerDropDown);
        Action.explicitWaitForElementTobeclickable(bestsellerPageLink, 5);
        bestsellerPageLink.click();
        extentInfoLog("Clicked on : ", "Bestsellers");
    }
	
	/**
	 * Selects a sorting option from the dropdown and verifies if the URL is updated accordingly.
	 *
	 * @param option The index of the sorting option to be selected from the dropdown.
	 * @param expectedResult The expected URL fragment to verify if the page URL updates correctly.
	 */
	public void selectSortByFilter(String option, String ExpRes) throws InterruptedException {
		Action.scrollByPixels(driver, 300);
		Action.explicitWaitForElementTobeclickable(sortByDropdown, 10);
		sortByDropdown.click();
		String optionSelected = sortByDropdown.getText();
		Thread.sleep(2000);
		int options = Integer.parseInt(option);
		Action.selectDropdownOptionWithKeyboard(sortByDropdown, options);
		extentInfoLog("Option selected from the sort dropdown : ", optionSelected);
		boolean isUrlCorrect = Action.waitForUrlContains(ExpRes, 3);
		if (isUrlCorrect) {
			extentPassLog("URL updated as per sort selected : ", ExpRes);
		} else {
			extentInfoLog("URL not updated as per sort selected : ", ExpRes);
		}
	}

	/**
	 * Selects a filter from the "Refine" dropdown and verifies if the URL is updated accordingly.
	 *
	 * @param option The name of the filter option to be selected from the refine dropdown.
	 * @param expectedResult The expected URL fragment to verify if the page URL updates correctly after the filter is applied.
	 * @throws InterruptedException If the thread is interrupted during the sleep period.
	 */
	public void selectCategoryFilter(String option, String expectedResult) throws InterruptedException {
		Action.scrollByPixels(driver, 300);
		Action.explicitWaitForElementTobeclickable(refineDropdown, 10);
		refineDropdown.click();
		Thread.sleep(2000);
		Action.explicitWaitForElementTobeclickable(getFilterLabel(option), 5);
		Action.click(driver, getFilterLabel(option));
		Thread.sleep(3000);
		extentInfoLog("Option selected from the refine filter : ", option);
		boolean isUrlCorrect = Action.waitForUrlContains(expectedResult, 3);
		if (isUrlCorrect) {
			extentPassLog("URL updated as per filter : ", expectedResult);
		} else {
			extentFailLog("URL not updated as per filter : ", expectedResult);
		}
	}

	/**
	 * Selects ingredients from a filter and verifies the resulting URL.
	 * @param option         The ingredient option to be selected for filtering.
	 * @param expectedResult The expected URL that should be generated after the ingredient is applied.
	 * @return void
	 */
	public void selectIngredients(String option, String expectedResult) {
	    ingredientsBtn.click();
	    Action.waitFor(4000);
	    Action.JSClick(ingredientsFiltercheckboxForProduct(option));
	    extentInfoLog("Ingredient checked : ", option);
	    Action.waitFor(2000);
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, expectedResult);
	    boolean isUrlCorrect = Action.waitForUrlContains(expectedResult, 3);
	    if (isUrlCorrect) {
	        extentPassLog("URL updated as per ingredient filter : ", expectedResult);
	    } else {
	        extentFailLog("URL not updated as per ingredient filter : ", expectedResult);
	    }
	}
	
	/**
	 * Verifies the layout of the page by checking the number of images and breadcrumbs present, 
	 * and ensuring the visibility of the banner element.
	 * @param expectedImageCount    The expected number of images to be present on the page.
	 * @param expectedBreadcrumbCount The expected number of breadcrumbs to be present on the page.
	 * @return void
	 * @timeComplexity O(n) where n is the maximum of expectedImageCount and expectedBreadcrumbCount due to image and breadcrumb counting.
	 */
	public void verifyPageLayout(int expectedImageCount, int expectedBreadcrumbCount) {
	    extentInfoLog("Verifying page layout for: " + driver.getTitle(), expectedBreadcrumbCount);
	    List<WebElement> images = driver.findElements(imageLocator);
	    printAndAssert(images.size(), expectedImageCount, "Images");
	    extentInfoLog("Images verified: " + images.size(), images);
	    boolean isBannerDisplayed = banner.isDisplayed();
	    if (isBannerDisplayed) {
	        extentInfoLog("Banner is present.", isBannerDisplayed);
	    } else {
	        extentInfoLog("Banner is not present.", isBannerDisplayed);
	        throw new AssertionError("Banner is missing!");
	    }
	    List<WebElement> breadcrumbs = driver.findElements(breadcrumbLocator);
	    printAndAssert(breadcrumbs.size(), expectedBreadcrumbCount, "Breadcrumbs");
	    extentInfoLog("Breadcrumbs verified: " + breadcrumbs.size(), breadcrumbs);
	}

	/**
	 * Compares the actual count of a specified element type against the expected count, 
	 * logging the result and throwing an AssertionError if they do not match.
	 * @param actual      The actual count of the specified element type.
	 * @param expected    The expected count of the specified element type.
	 * @param elementType A descriptive name for the type of element being asserted (e.g., "Images" or "Breadcrumbs").
	 * @return void
	 */
	private void printAndAssert(int actual, int expected, String elementType) {
	    if (actual != expected) {
	        String errorMessage = "Assertion failed for " + elementType + "! Expected: " + expected + ", but got: " + actual;
	        extentInfoLog("Assertion failed! got: " + actual + "but expected: ", expected);
	        throw new AssertionError(errorMessage);
	    } else {
	        extentInfoLog("Assertion passed! Count matches: ", expected);
	    }
	}
}