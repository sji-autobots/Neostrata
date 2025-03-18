package com.neostrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

public class PlpPage extends BaseClass {

	@FindBy(css = "#SortBy")
	private WebElement sortByDropdown;
	
	@FindBy(xpath = "(//*[@id='component-shop-skincare-menu'])[1]")
	private WebElement refineDropdown;
	
	public WebElement getFilterLabel(String labelText) {
		return driver.findElement(
				By.xpath("//div[@id='FacetsWrapperDesktop']//a[@class='facet-checkbox__text-label'][normalize-space()='"
						+ labelText + "']"));
	}
	
	public PlpPage() {
        PageFactory.initElements(driver, this);
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

	
}
