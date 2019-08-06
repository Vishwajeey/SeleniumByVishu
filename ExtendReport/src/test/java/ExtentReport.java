import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter report=new ExtentHtmlReporter("D:\\Selenium\\ExtendReport\\src\\test\\resources\\Test.html");
		ExtentReports lExtentReport=new ExtentReports();
		
		lExtentReport.attachReporter(report);
		
		ExtentTest logger=lExtentReport.createTest("Login");
		logger.log(Status.INFO, "Login into amzon");
		logger.log(Status.PASS, "Login into google");
		
		lExtentReport.flush();
		
		ExtentTest logger2=lExtentReport.createTest("Login2");
		logger2.log(Status.FAIL, "Login into amzon");
	//	logger2.addScreenCaptureFromPath("D:\\Selenium\\ExtendReport\\src\\test\\resourcesSC.png");
		logger2.fail("Failed by some reson", MediaEntityBuilder.createScreenCaptureFromPath("D:\\\\Selenium\\\\ExtendReport\\\\src\\\\test\\\\resources\\\\Test.html").build());
		lExtentReport.flush();
		
	}
	
}
