package com.skm.mavenproject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility 
{
	public static String screenshot(WebDriver driver,String screenshotname)
	{
		try 
		{
			TakesScreenshot take=(TakesScreenshot)driver;
			File source=take.getScreenshotAs(OutputType.FILE);
			String destination="D:\\report\\"+screenshotname+".png";
			File dest=new File(destination);
			FileUtils.copyFile(source,dest);
			//System.out.println("screenshot taken with name:::::::"+screenshotname);
			return destination;
		} 
		catch (Exception e) 
		{
			//System.out.println("screenshot not taken"+e.getMessage());
			return e.getMessage();
		}
	}
}
