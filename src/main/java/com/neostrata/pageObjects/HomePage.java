package com.neostrata.pageObjects;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.neostrata.actionDriver.Action;
import com.neostrata.base.BaseClass;

/**
 * @author : Rashi Tiwari
 * @Date : 21 Jan 2025
 **/

public class HomePage extends BaseClass {

	@FindBy(css = "div.header__heading-logo-wrapper >img")
	private WebElement logo;

	@FindBy(xpath = "//section[2]/div/div")
	private WebElement firstBanner;

	@FindBy(xpath = "//section[2]/div[1]/div[1]/div[2]/div[2]/a")
	private WebElement firstBannerShopNowBtn;

	@FindBy(xpath = "(//button[@aria-label='Close'])[last()]")
	private WebElement closePopup;

	@FindBy(css = ".title.inline-richtext.h2.scroll-trigger.animate--slide-in")
	private WebElement trendingHeading;

	@FindBy(css = "div.product__item.swiper-slide.swiper-slide")
	private WebElement trendingProducts;

	@FindBy(xpath = "//span[contains(text(),'Add to bag')]")
	private List<WebElement> trendingProductsButtonCheck;

	@FindBy(css = "div.section-video-module-wrapper")
	private WebElement introductionBanner;

	@FindBy(xpath = "//div[@class='section-video-module-wrapper']/descendant::div/descendant::a")
	private WebElement introductionBannerShopNow;

	@FindBy(css = "div.holiday-sets-heading-block h2")
	private WebElement levelUpBanner;

	@FindBy(css = "div.holiday-set-block")
	private WebElement levelUpBannerProduct;

	@FindBy(xpath = "//div[@class='set-list--flex']//a[contains(text(),'SHOP NOW')]")
	private List<WebElement> levelUpBannerProductLink;

	@FindBy(css = "section.shopify-section.section")
	private WebElement saveForWinterBanner;

	@FindBy(xpath = "//div[@class='banner__buttons']/a")
	private WebElement saveForWinterLearnMoreButton;

	@FindBy(xpath = "//div[@class='holiday-tiles__header']//h2")
	private WebElement awardWinner;

	@FindBy(xpath = "//div[@class='holiday-tiles__blocks']//h3[@class='card__heading h4']//a")
	private List<WebElement> awardWinnerButton;

	@FindBy(xpath = "//div[@class='holiday-offers-header']/child::h2")
	private WebElement offer;

	@FindBy(css = ".holiday-offers__blocks")
	private WebElement offerBlock;

	@FindBy(xpath = "//h2[@class='bv-social-commerce-section--title']")
	private WebElement loveToSeeyouGlow;

	@FindBy(xpath = "(//div[@data-crl8-container-id=\"homepage\"])[1]")
	private WebElement images;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Logs the actual and expected results, asserts their equality, and logs a
	 * success message if they match.
	 *
	 * @param actualResult   The actual result obtained during the test.
	 * @param expectedResult The expected result to compare against.
	 */
	public void printDataOnReport(Object actualResult, Object expectedResult) {
		extentInfoLog("Actual result : ", actualResult);
		extentInfoLog("Expected result : ", expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
		extentPassLog("Text matches correctly!", "");
	}

	/**
	 * Waits for a popup to appear and closes it if displayed. Logs the popup's
	 * display status.
	 */
	public void closePopup() {
		Action.waitFor(3);
		if (closePopup.isDisplayed()) {
			closePopup.click();
			closePopup.isDisplayed();
		} else {
			extentInfoLog("Popup displayed : ", closePopup.isDisplayed());
		}
	}

	/**
	 * Logs whether the logo is displayed on the page.
	 */
	public void checkLogo() {
		extentInfoLog("'Logo is displayed : ", logo.isDisplayed());
	}

	/**
	 * Verifies the visibility of the first banner, clicks the 'Shop Now' button if
	 * visible, and checks the URL.
	 *
	 * @param expUrl The expected URL fragment to verify after clicking the button.
	 */
	public void firstBannerVerification(String expUrl) {
		boolean flag = firstBanner.isDisplayed();
		if (flag == true) {
			extentInfoLog("Clicking on 'Shop Now' button on first banner : ", "");
			firstBannerShopNowBtn.click();
			extentInfoLog("Clicked on 'Shop Now' button : ", "");
			Action.waitForUrlToContain(driver, expUrl, 3);
			extentInfoLog(" URL contains the specified fragment : ", expUrl);
		} else {
			extentFailLog("'Banner is displayed : ", firstBanner.isDisplayed());
		}
	}

	/**
	 * Verifies the trending section heading and checks the 'Add to Bag' buttons for
	 * products.
	 *
	 * @param expText      The expected text for the trending section heading.
	 * @param productCount The expected number of products in the trending section.
	 */
	public void shopTrending(String expText, String productCount) {
		String actualText = trendingHeading.getText();
		home.printDataOnReport(actualText, expText);
		boolean flag = trendingProducts.isDisplayed();
		System.out.println(flag);
		int counter = 0;
		boolean anyDisabled = false;
		for (WebElement button : trendingProductsButtonCheck) {
			if (button.isEnabled()) {
				counter++;
			} else {
				anyDisabled = true;
			}
		}
		extentInfoLog("Number of enabled 'Add to Bag' buttons found ", counter);
		if (anyDisabled) {
			extentFailLog(
					"Some 'Add to Bag' buttons are disabled. Total: " + (trendingProductsButtonCheck.size() - counter),
					anyDisabled);
		} else {
			extentPassLog("All 'Add to Bag' buttons are enabled.", anyDisabled);
		}
	}

	/**
	 * Verifies the visibility of the 'Introducing' banner, clicks the 'Shop Now'
	 * button if visible, and checks the URL.
	 *
	 * @param expUrl The expected URL fragment to verify after clicking the button.
	 */
	public void introducingBanner(String expUrl) {
		boolean flag = introductionBanner.isDisplayed();
		if (flag == true) {
			extentPassLog("'Intoducing' banner is displayed : ", flag);
			introductionBannerShopNow.click();
			Action.waitForUrlToContain(driver, expUrl, 3);
			extentInfoLog(" URL contains the specified fragment : ", expUrl);
		} else {
			extentFailLog("'Banner is displayed : ", firstBanner.isDisplayed());
		}
	}

	/**
	 * Verifies the 'Level Up' banner text, checks the product banner, clicks a
	 * specified product link, and verifies the URL.
	 *
	 * @param expText The expected text of the 'Level Up' banner.
	 * @param index   The index of the product link to click.
	 * @param expUrl  The expected URL fragment after clicking the product link.
	 * @throws Exception if an error occurs during execution.
	 */
	public void levelUp(String expText, String index, String expUrl) throws Exception {
		String actText = levelUpBanner.getText();
		home.printDataOnReport(expText, actText);
		extentInfoLog("Product banner displayed: ", levelUpBannerProduct.isDisplayed());
		int indexInt = Integer.parseInt(index);
		WebElement element = levelUpBannerProductLink.get(indexInt);
		Action.JSClick(driver, element);
		Action.waitForUrlToContain(driver, expUrl, 5);
	}

	/**
	 * Verifies the visibility of the 'Save For Winter' banner, clicks the 'Learn
	 * More' button if visible, and checks the URL.
	 *
	 * @param expUrl The expected URL fragment to verify after clicking the button.
	 */
	public void saveForWinterBanner(String expUrl) {
		boolean flag = saveForWinterBanner.isDisplayed();
		if (flag == true) {
			extentPassLog("'Save For Winter' banner is displayed : ", flag);
			extentInfoLog("Clicking on 'Learn More' button : ", "");
			saveForWinterLearnMoreButton.click();
			Action.waitForUrlToContain(driver, expUrl, 5);
		} else {
			extentInfoLog(" Banner is not displayed : ", "");
		}
	}

	/**
	 * Verifies the 'Award Winner' text, clicks a specified winner button, and
	 * checks the URL.
	 *
	 * @param expText The expected text of the 'Award Winner' banner.
	 * @param index   The index of the winner button to click.
	 * @param expUrl  The expected URL fragment after clicking the winner button.
	 * @throws Exception if an error occurs during execution.
	 */
	public void awardWinner(String expText, String index, String expUrl) throws Exception {
		String actText = awardWinner.getText();
		home.printDataOnReport(actText, expText);
		int indexInt = Integer.parseInt(index);
		WebElement element = awardWinnerButton.get(indexInt);
		Action.JSClick(driver, element);
		Action.waitForUrlToContain(driver, expUrl, 2);
	}

	/**
	 * Verifies the 'Special Offer' text and checks the visibility of the 'Special
	 * Offer' banner.
	 *
	 * @param expText The expected text of the 'Special Offer' banner.
	 */
	public void specialOffer(String expText) {
		String actText = offer.getText();
		home.printDataOnReport(expText, actText);
		boolean flag = offerBlock.isDisplayed();
		if (flag == true) {
			extentPassLog("'Special Offer' banner is displayed : ", flag);
		} else {
			extentInfoLog(" Banner is not displayed : ", "");
		}
	}

	/**
	 * Verifies the 'Glow' text and checks if the images are displayed.
	 *
	 * @param expText The expected text of the 'Glow' section.
	 */
	public void glow(String expText) {
		String actText = loveToSeeyouGlow.getText();
		home.printDataOnReport(expText, actText);
		boolean flag = images.isDisplayed();
		if (flag == true) {
			extentPassLog("'Images' are displayed : ", flag);
		} else {
			extentInfoLog("Images not displayed : ", "");
		}
	}
}
