package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithTestNG1 {
	String driverPath = "D:\\Selenium\\Drivers\\chromedriver.exe";
	WebDriver driver;

	@Test
	@Parameters({ "author", "searchKey" })
	public void f(@Optional("abc") String author, String searchKey) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://google.com");

		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome :" + author + " SerachKey:" + searchKey);
		System.out.println("Thread will sleep now");
		Thread.sleep(3000);
		System.out.println("Value in Google Search Box ="+searchText.getAttribute("value") +":::Value given by input ::"+searchKey);
		Assert.assertEquals(searchText.getAttribute("value"), searchKey);
		
		driver.close();
	
	}
}
