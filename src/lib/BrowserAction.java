package lib;

import org.openqa.selenium.WebDriver;

public class BrowserAction {
	
	
	public static String openApplication(WebDriver driver,String localurl)
	{
		
		try 
		{
			driver.manage().window().maximize();
			driver.get(localurl);
			return "pass";
		} catch (Exception e) {
			
			return e.getMessage();
		}
		
		
	}
	
	public static String closeApplication(WebDriver driver)
	{
		try 
		{
			driver.quit();
			return "pass";
		} catch (Exception e) {
			
			return e.getMessage();
		}
	}

}
