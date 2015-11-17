package Config;

import lib.BrowserAction;
import lib.ClickEvents;
import lib.TypeEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ExcelDataProvider;

public class TestConfig 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	
	@Test
	public void startTest()
	{
		
		ExcelDataProvider excel=new ExcelDataProvider();
		report=new ExtentReports("C:\\Workspace_VideoTutorialToolsqa\\KDF\\HTMLReport\\login.html");
	    logger=report.startTest("logindemoqa");
		
		int rowcount=excel.rowCount("Loginform");
		
		for(int i=1;i<=rowcount;i++)
		{
			
			String description=excel.getData("Loginform", i, 0);
			String object_type=excel.getData("Loginform", i, 1);
			String actions=excel.getData("Loginform", i, 2);
			String locator_type=excel.getData("Loginform", i, 3);
			String locator_value=excel.getData("Loginform", i, 4);
			String testdata=excel.getData("Loginform", i, 5);
			
			if(object_type.equalsIgnoreCase("browser"))
			{
				if(testdata.equalsIgnoreCase("firefox"))
				{
					if(actions.equalsIgnoreCase("startBrowser"))
					{
						driver=new FirefoxDriver();
						
					}
					if(actions.equalsIgnoreCase("closeBrowser"))
					{
						driver.quit();
					}
				}
				
				if(testdata.equalsIgnoreCase("Chrome"))
				{
					if(actions.equalsIgnoreCase("startBrowser"))
					{
						
						driver=new ChromeDriver();
					}
					if(actions.equalsIgnoreCase("closeBrowser"))
					{
						driver.quit();
					}
				}
				
				logger.log(LogStatus.INFO,description);
			}
			
			if(object_type.equalsIgnoreCase("OpenApp"))
			{
				if(actions.equalsIgnoreCase("navigate"))
				{
					BrowserAction.openApplication(driver, testdata);
					logger.log(LogStatus.INFO,description);
					
				}
			}
			
			if(object_type.equalsIgnoreCase("typeText"))
			{
				String status=TypeEvents.typeAction(driver, locator_type, locator_value, testdata);
				if(status.equalsIgnoreCase("pass"))
				{
				logger.log(LogStatus.INFO,description);
				}
				else
				{
				logger.log(LogStatus.FAIL, description);
				}
			}
			
			if(object_type.equalsIgnoreCase("click"))
			{
				ClickEvents.clickAction(driver, locator_type, locator_value);
				logger.log(LogStatus.INFO,description);

			}
			
				
		}
		
		report.endTest(logger);
		report.flush();
		
		
	}
	

	
	
}
