package com.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParameterDataproviderWithClassLevel {
	
	WebDriver driver;
	String driverPath="D:\\Selenium\\Drivers\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://google.com");;
		
	}
	
	@Test(dataProvider="SearchProvider",dataProviderClass=DataProviderClass.class)
	public void f(String author,String searchKey) throws InterruptedException {
		WebElement searchText=driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome Author:::"+author+"Your search key is:::"+searchKey);
		Thread.sleep(100);
		String testValue=searchText.getAttribute("value");
		System.out.println(testValue+":::::"+searchKey);
		searchText.clear();
		assertEquals(testValue, searchKey);
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
