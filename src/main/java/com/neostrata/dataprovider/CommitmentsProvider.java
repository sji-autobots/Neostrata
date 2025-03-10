package com.neostrata.dataprovider;

import java.io.IOException;

import com.neostrata.utility.DataProviders;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 03 March 2025
 * 
 **/

public class CommitmentsProvider {

	String dataPath = "src\\test\\resources\\TestData\\Commitments.xlsx";
	
	DataProviders provider = new DataProviders();
	
	@org.testng.annotations.DataProvider(name = "breadText")
    public Object[][] breadText() throws IOException, IOException {
        return provider.getData(dataPath, "breadText");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerText")
    public Object[][] bannerText() throws IOException, IOException {
        return provider.getData(dataPath, "bannerText");
    }
	
	@org.testng.annotations.DataProvider(name = "enveText")
    public Object[][] enveText() throws IOException, IOException {
        return provider.getData(dataPath, "enveText");
    }
	
	@org.testng.annotations.DataProvider(name = "bannerImage")
    public Object[][] bannerImage() throws IOException, IOException {
        return provider.getData(dataPath, "bannerImage");
    }
	
	@org.testng.annotations.DataProvider(name = "subHeadOne")
    public Object[][] subHeadOne() throws IOException, IOException {
        return provider.getData(dataPath, "subHeadOne");
    }
	
	@org.testng.annotations.DataProvider(name = "subHeadTwo")
    public Object[][] subHeadTwo() throws IOException, IOException {
        return provider.getData(dataPath, "subHeadTwo");
    }
	
	@org.testng.annotations.DataProvider(name = "subHeadThree")
    public Object[][] subHeadThree() throws IOException, IOException {
        return provider.getData(dataPath, "subHeadThree");
    }
	
	@org.testng.annotations.DataProvider(name = "pageLayout")
    public Object[][] pageLayout() throws IOException, IOException {
        return provider.getData(dataPath, "pageLayout");
    }
}
