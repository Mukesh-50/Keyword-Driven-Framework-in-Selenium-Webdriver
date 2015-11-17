package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickEvents 
{

	public static String clickAction(WebDriver driver,String locatorType,String locatorValue)
	{
		
		try 
		{
			if(locatorType.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(locatorValue)).click();
			}
			else if(locatorType.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorValue)).click();
			}
			
			return "pass";
		} 
		catch (Exception e) {
			
			return e.getMessage();
		}
		
		
	}
	
	
	
}
