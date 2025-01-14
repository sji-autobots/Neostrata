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

    @org.testng.annotations.DataProvider(name = "banner")
    public Object[][] banner() throws IOException, IOException {
        return provider.getData(dataPath, "banner");
    }

}
