package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ParameterByMethodInDataprovider {
	WebDriver driver;
	String driverPath = "D:\\Selenium\\Drivers\\chromedriver.exe";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}

	@Test(dataProvider = "SearchProvider", priority = 0)
	public void testMethodA(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		// Search Text In SearchBox
		searchText.sendKeys(searchKey);
		System.out.println("Welcome->" + author + "Your Search Key is->" + searchKey);
		Thread.sleep(100);
		String testValue = searchText.getAttribute("value");
		System.out.println("TestValue:::" + testValue + "  SearchKey:::" + searchKey);
		searchText.clear();
		// Verify if google text box showing me correct value
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}

	@Test(dataProvider = "SearchProvider", priority = 1)
	public void testMethodB(String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		// Search text in search box
		searchText.sendKeys(searchKey);
		// Print only search string
		System.out.println("Welcome ->Unknown user Your search key is->" + searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + "::::" + searchKey);
		searchText.clear();
		// Verify if google text box is showing correct value
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	/*
	 * Here Data Provider Returning Value On the basis of Test method
	 * 
	 * @param m
	 * 
	 * @return
	 */
	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataProvider(Method m) {
		if (m.getName().equalsIgnoreCase("testMethodA")) {
			return new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };
		} else {
			return new Object[][] { { "Canada" }, { "Russia" }, { "Japan" } };
		}
	}
}
