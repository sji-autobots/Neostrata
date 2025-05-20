package com.neostrata.dataprovider;

import java.io.IOException;
import com.neostrata.utility.DataProviders;

/**
 * @Author: Shaurya Jaiswal
 * @Date: 17 April 2025
 * 
 **/

public class ShippingProvider {
	
	String dataPath = "src\\test\\resources\\TestData\\Shipping.xlsx";
	
	DataProviders provider = new DataProviders();
	
	@org.testng.annotations.DataProvider(name = "shippingInfoPageBreadText")
    public Object[][] shippingInfoPageBreadText() throws IOException, IOException {
        return provider.getData(dataPath, "shippingInfoPageBreadText");
    }
	
	@org.testng.annotations.DataProvider(name = "shippingInitiatives")
    public Object[][] shippingInitiatives() throws IOException, IOException {
        return provider.getData(dataPath, "shippingInitiatives");
    }
	
	@org.testng.annotations.DataProvider(name = "shippingRates")
    public Object[][] shippingRates() throws IOException, IOException {
        return provider.getData(dataPath, "shippingRates");
    }
}