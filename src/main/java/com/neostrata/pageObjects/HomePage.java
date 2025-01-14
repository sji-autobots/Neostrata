package com.neostrata.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neostrata.base.BaseClass;

/**
 *	@author : Rashi Tiwari
 *	@Date : 10 Jan 2025
 **/

public class HomePage extends BaseClass {

	@FindBy (css = "div.header__heading-logo-wrapper >img")	
	private WebElement logo;

	@FindBy (css = "div.dynamic-banner__media>img:first-child")	
	private WebElement firstBanner;


	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void checkLogo() {
		extentInfoLog("'Logo is displayed : ", logo.isDisplayed());
	}
	
	public void firstBanner() {
		extentInfoLog("'Logo is displayed : ", firstBanner.isDisplayed());
	}

}
