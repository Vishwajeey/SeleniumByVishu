import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowandCell {
	public static void main(String[] args) {
		String driverPath="D:\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement baseTable=driver.findElement(By.tagName("table"));
		
		//To find third row of table
		WebElement tableRow=baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		String tableRowText=tableRow.getText();
		System.out.println("TableRowText"+tableRowText);
		
		//To find third rows second column data of table
		WebElement cellIneed=tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		String valueIneed=cellIneed.getText();
		System.out.println("Cell valueIneed:"+valueIneed);
		driver.close();
		
	}
	
}
