package com.neostrata.dataprovider;

import java.io.IOException;

import com.neostrata.utility.DataProviders;

public class PlpProvider {
	String dataPath = "src\\test\\resources\\TestData\\PlpTestData.xlsx";

    DataProviders provider = new DataProviders();

    @org.testng.annotations.DataProvider(name = "sort")
    public Object[][] sort() throws IOException, IOException {
        return provider.getData(dataPath, "sort");
    }
    
    @org.testng.annotations.DataProvider(name = "category")
    public Object[][] category() throws IOException, IOException {
        return provider.getData(dataPath, "category");
    }
    
    @org.testng.annotations.DataProvider(name = "ingredients")
    public Object[][] ingredients() throws IOException, IOException {
        return provider.getData(dataPath, "ingredients");
    }
    
    @org.testng.annotations.DataProvider(name = "pageLayout")
    public Object[][] pageLayout() throws IOException, IOException {
        return provider.getData(dataPath, "pageLayout");
    }
}
