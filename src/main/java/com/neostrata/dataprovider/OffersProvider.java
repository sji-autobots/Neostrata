package com.neostrata.dataprovider;

import java.io.IOException;

import com.neostrata.utility.DataProviders;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 12 March 2025
 * 
 **/

public class OffersProvider {
	
String dataPath = "src\\test\\resources\\TestData\\OffersData.xlsx";
	
	DataProviders provider = new DataProviders();
	
	@org.testng.annotations.DataProvider(name = "breadText")
    public Object[][] breadText() throws IOException, IOException {
        return provider.getData(dataPath, "breadText");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerText")
    public Object[][] bannerText() throws IOException, IOException {
        return provider.getData(dataPath, "bannerText");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerOneButton")
    public Object[][] bannerOneButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerOneButton");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerTwoButton")
    public Object[][] bannerTwoButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerTwoButton");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerThreeButton")
    public Object[][] bannerThreeButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerThreeButton");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerFourButton")
    public Object[][] bannerFourButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerFourButton");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerFiveButton")
    public Object[][] bannerFiveButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerFiveButton");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerSixButton")
    public Object[][] bannerSixButton() throws IOException, IOException {
        return provider.getData(dataPath, "bannerSixButton");
    }
}