package com.skm.mavenproject;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class JBK_Offline 
{
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod()
	  {
		
	  }
	@Test
	public void test_Extent()
	{
		
		report=new ExtentReports("./ExtentReport_Screenshots/Maven_Extent_Report.html");
		logger=report.startTest("test_Extent");
		driver=new FirefoxDriver();
		//logger.log(LogStatus.INFO,"Browser started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//logger.log(LogStatus.INFO,"Browser maximized");click
		driver.get("C:\\Users\\lenovo pc\\Desktop\\javabykiran\\Offline Website\\pages\\examples\\login.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
		//logger.log(LogStatus.INFO,"Application loaded");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("sk"));
		logger.log(LogStatus.PASS,"Title of the page is verified");
			
	}
	

  @AfterMethod
  public void test_Failure_function(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String capturefilepath=Utility.screenshot(driver, result.getName());
			String imagepath=logger.addScreenCapture(capturefilepath);
			logger.log(LogStatus.INFO,"Title verification",imagepath);
			logger.log(LogStatus.FAIL, "test case fail");
		}
		
		report.endTest(logger);
		report.flush();
		report.close();
		
		driver.get("D:\\ExtendReport\\ScreenshotsAll\\outputfile.html");
	}
}

  