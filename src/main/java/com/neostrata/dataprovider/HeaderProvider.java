package com.neostrata.dataprovider;

import java.io.IOException;

import com.neostrata.utility.DataProviders;

public class HeaderProvider {

String dataPath = "src\\test\\resources\\TestData\\HeaderPageTestData.xlsx";
	
	DataProviders provider = new DataProviders();
	
	@org.testng.annotations.DataProvider(name = "shopskincare")
    public Object[][] shopskincare() throws IOException, IOException {
        return provider.getData(dataPath, "shopskincare");
    }
	
	@org.testng.annotations.DataProvider(name = "bestSeller")
    public Object[][] bestSeller() throws IOException, IOException {
        return provider.getData(dataPath, "bestSeller");
    }
	
	@org.testng.annotations.DataProvider(name = "discover")
    public Object[][] discover() throws IOException, IOException {
        return provider.getData(dataPath, "discover");
    }
	
	@org.testng.annotations.DataProvider(name = "discoverProducts")
    public Object[][] discoverProducts() throws IOException, IOException {
        return provider.getData(dataPath, "discoverProducts");
    }
}
