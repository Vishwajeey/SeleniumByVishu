import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTables {
	
	public static void main(String[] args) {
		String driverPath="D:\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		//No. of columns
		List col=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("No of Cols are:"+col.size());
		
		//No. of rows
		List rows=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("Number of rows:"+rows.size());
		driver.close();
	}

}
