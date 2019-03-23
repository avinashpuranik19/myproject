package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

public class TestBase {
	
	/* Initialize following components ==> 
	 * WebDriver
	 * Properties
	 * Logs - log4j.jar , log4j.properties, Logger class
	 * DB
	 * Excel
	 * Mail
	 *ReportNG and ExtentReports
	 *Jenkins
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait =null;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUp()
	{
		if (driver==null)
		{
			
			// ************************   Properties file initialization ******************************** //
				try {
					fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					config.load(fis);
					log.debug("Config file loaded !!!!!!!!!!");
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
				try {
					fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				try {
					OR.load(fis);
					log.debug("OR file loaded !!!!!!!!!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				// **********************************     Browser initialization ****************************** 
				

				if (config.getProperty("browser").equals("firefox"))
				{
					driver = new FirefoxDriver();
					log.debug("Firefox browser is launched");
					
				}
				
				else if (config.getProperty("browser").equals("chrome"))
				{

					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
					driver = new ChromeDriver();
					log.debug("Chrome browser is launched");
					
				}
				
				
				// ********************************    URL initializaiton **************************************** //
				
				driver.get(config.getProperty("testsiteurl"));
				log.debug("Navigated to  "+config.getProperty("testsiteurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
				wait = new WebDriverWait(driver,10);
				
				
		}
		
		
	}
	
	
	public  void click (String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking On: " + locator);
		
		
	}
	
	
	public void entervalue (String locator, String value)
	{
		
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing value " + locator);
		
		
		
	}
	
	public boolean isElementPresent(By by)
	{
		
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
			
		}
		
		
	}
	
	//@AfterSuite
	public void tearDown()
	{
		
		if (driver!=null)
		{
			
			driver.quit();
		}
		
		log.debug("test execution completed");
		
//		
		rep.endTest(test);
		rep.flush();
		rep.close();
//		
	}
	
	
	
	
	
	

}
