package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotpath;
	public static String screenshotname;
	
	public static void captureScreenshot () throws IOException
	{
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		screenshotname="error.jpg";
		
		FileUtils.copyFile(srcfile, new File (System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname+""));
		
		
		
		
	}
	
	
	
	
	

}
