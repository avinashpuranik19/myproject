package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class testapp {

	@Test
	
	public void testapp ()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")).click();
		
		driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/div[1]/button[1]")).click();
		
		driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Avinash");
		
		
		
		
		
		
		
	}
	
	
}
