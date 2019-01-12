import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxxFromTable {

	public static void main(String[] args) throws ParseException {
		String driverPath="D:\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String max;
		double m=0,r=0;
		
		//No of Columns
		List col=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("Total no.of columns are :"+col.size());
		
		List rows=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("Total no. of rows are :"+rows.size());
		
		for(int i=1;i<rows.size();i++) {
			max=driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr["+ (i + 1)+ "]/td[4]")).getText();
			NumberFormat format=NumberFormat.getNumberInstance();
			Number num=format.parse(max);
			max=num.toString();
			m=Double.parseDouble(max);
			if(m>r) {
				r=m;
			}
		}
		System.out.println("Maximun current Price is:"+r);
		driver.close();
		
	}

}
