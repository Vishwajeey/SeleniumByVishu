import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NofRowsColmns {
	public static void main(String[] args) {
		String driverPath="D:\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/table.html");
		//TO locate table
		WebElement table=driver.findElement(By.xpath("//html//body//table//tbody"));
		//To locate number of rows in table
		List<WebElement> numOfRows=table.findElements(By.tagName("tr"));
		
		//TO calculate number of rows in table
		int rows=numOfRows.size();
		for(int row=0;row<rows;row++) {
			//To locate the columns of that specific row
			List<WebElement> numOfColumn=numOfRows.get(row).findElements(By.tagName("td"));
			
			//To calculate no of columns(cell) in that specific row
			int columnCount=numOfColumn.size();
			System.out.println("Number of cells in row"+row+"column Count"+columnCount);
			//Loop will execute till the last cell of that specific row
			for(int column=0;column<columnCount;column++) {
				//To retrieve text from that specific text
				String cellText=numOfColumn.get(column).getText();
				System.out.println("Cell Value of row number:"+row+"and column number"+column+"Is"+cellText);
			}
			System.out.println("...........................................................");
			
		}
		
		
	
	}
}
