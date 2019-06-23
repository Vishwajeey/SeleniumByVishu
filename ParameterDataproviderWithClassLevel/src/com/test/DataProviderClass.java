package com.test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="SearchProvider")
	public static Object[][] getDataFromDataProvider(){
		return new Object[][] {
			{"Guru99","India"},
			{"Krishna","UK"},
			{"Bhupesh","USA"}
		};
	}
}
