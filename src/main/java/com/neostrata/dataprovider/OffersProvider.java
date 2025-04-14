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
	
	@org.testng.annotations.DataProvider(name = "headText")
    public Object[][] headText() throws IOException, IOException {
        return provider.getData(dataPath, "headText");
    }
	
	@org.testng.annotations.DataProvider(name = "cardContent")
    public Object[][] cardContent() throws IOException, IOException {
        return provider.getData(dataPath, "cardContent");
    }
	
	@org.testng.annotations.DataProvider(name = "offerTerms")
    public Object[][] offerTerms() throws IOException, IOException {
        return provider.getData(dataPath, "offerTerms");
    }
}