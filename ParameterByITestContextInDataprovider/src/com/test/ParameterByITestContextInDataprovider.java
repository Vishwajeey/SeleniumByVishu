package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

public class ParameterByITestContextInDataprovider {
	WebDriver driver;
	String driverPath = "D:\\Selenium\\Drivers\\chromedriver.exe";

	@BeforeTest(groups = { "A", "B" })
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "SearchProvider", groups = "A",priority=0)
	public void testMethodA(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome Author:::" + author + "  SearchKey:::" + searchKey);
		Thread.sleep(100);
		String keyValue = searchText.getAttribute("value");
		System.out.println("Key Value:::" + keyValue + "  SearchKey:::" + searchKey);
		searchText.clear();
		Assert.assertEquals(keyValue, searchKey);
	}

	@Test(dataProvider = "SearchProvider", groups = "B",priority=1)
	public void testMethodB(String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome Unknows User Your Search key is::::" + searchKey);
		Thread.sleep(100);
		String testValue = searchText.getAttribute("value");
		System.out.println("SearchKey:::" + searchKey + "  Test Value:::" + testValue);
		searchText.clear();
		Assert.assertEquals(testValue, searchKey);
	}

	@AfterTest
	public void afterTest() {
	}

	@DataProvider(name = "SearchProvider")
	public Object[][] dataProvider(ITestContext c) {
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			if (group.equalsIgnoreCase("A")) {
				groupArray = new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };
				break;
			} else if (group.equalsIgnoreCase("B")) {
				groupArray = new Object[][] { { "Canada" }, { "Russia" }, { "Japan" } };
			}
			break;
		}
		return groupArray;

	}
}
