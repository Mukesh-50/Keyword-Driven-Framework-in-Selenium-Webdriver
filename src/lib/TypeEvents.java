package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TypeEvents 
{

	
	public static String typeAction(WebDriver driver,String locatorType,String locatorValue,String data)
	{
		
		try 
		{
			if(locatorType.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(locatorValue)).sendKeys(data);
			}
			else if(locatorType.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			}
			
			return "pass";
		} 
		catch (Exception e) {
			
			return e.getMessage();
		}
		
		
	}
	
	
}
