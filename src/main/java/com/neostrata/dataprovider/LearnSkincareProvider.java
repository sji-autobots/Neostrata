package com.neostrata.dataprovider;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 24 Jan 2025
 * 
 **/

import java.io.IOException;

import com.neostrata.utility.DataProviders;

public class LearnSkincareProvider {
	
	String dataPath = "src\\test\\resources\\TestData\\LearnAboutSkincare.xlsx";
	
	DataProviders provider = new DataProviders();
	
	@org.testng.annotations.DataProvider(name = "breadText")
    public Object[][] breadText() throws IOException, IOException {
        return provider.getData(dataPath, "breadText");
    }
	
	@org.testng.annotations.DataProvider(name = "header")
    public Object[][] header() throws IOException, IOException {
        return provider.getData(dataPath, "header");
    }
	
	@org.testng.annotations.DataProvider(name = "viewBtn")
    public Object[][] viewBtn() throws IOException, IOException {
        return provider.getData(dataPath, "viewBtn");
    }
}
