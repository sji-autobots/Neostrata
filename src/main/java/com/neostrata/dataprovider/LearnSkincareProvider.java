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
	
	@org.testng.annotations.DataProvider(name = "BreadText")
    public Object[][] BreadText() throws IOException, IOException {
        return provider.getData(dataPath, "BreadText");
    }
	
	@org.testng.annotations.DataProvider(name = "Header")
    public Object[][] Header() throws IOException, IOException {
        return provider.getData(dataPath, "Header");
    }
	
	@org.testng.annotations.DataProvider(name = "ViewBtn")
    public Object[][] ViewBtn() throws IOException, IOException {
        return provider.getData(dataPath, "ViewBtn");
    }
}
