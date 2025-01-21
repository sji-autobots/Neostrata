package com.neostrata.dataprovider;

import java.io.IOException;
import com.neostrata.utility.DataProviders;

/**
 *	@author : Rashi Tiwari
 *	@Date : 14 Jan 2024
 **/

public class HomeProvider {

    String dataPath = "src\\test\\resources\\TestData\\HomePageTestData.xlsx";

    DataProviders provider = new DataProviders();

    @org.testng.annotations.DataProvider(name = "logo")
    public Object[][] logo() throws IOException, IOException {
        return provider.getData(dataPath, "logo");
    }

    @org.testng.annotations.DataProvider(name = "firstbanner")
    public Object[][] firstbanner() throws IOException, IOException {
        return provider.getData(dataPath, "firstbanner");
    }
    
    @org.testng.annotations.DataProvider(name = "trending")
    public Object[][] trending() throws IOException, IOException {
        return provider.getData(dataPath, "trending");
    }
    
    @org.testng.annotations.DataProvider(name = "introduction")
    public Object[][] introduction() throws IOException, IOException {
        return provider.getData(dataPath, "introduction");
    }
    
    @org.testng.annotations.DataProvider(name = "levelUp")
    public Object[][] levelUp() throws IOException, IOException {
        return provider.getData(dataPath, "levelUp");
    }
}

