package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByDataprovider {
	WebDriver driver;
	String driverPath = "D:\\Selenium\\Drivers\\chromedriver.exe";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://google.com");

	}

	@DataProvider(name = "SerachProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };
	}

	@Test(dataProvider = "SerachProvider")
	public void testMEthod(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		// search value in Google search box
		searchText.sendKeys(searchKey);
		System.out.println("Welcome ->" + author + "Your search key is:" + searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + ":::::" + searchKey);

		searchText.clear();
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

	}

	@AfterTest
	public void close() {
		driver.close();  
	}

}
