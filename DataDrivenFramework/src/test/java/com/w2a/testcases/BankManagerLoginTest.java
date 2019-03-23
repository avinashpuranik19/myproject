package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
@Listeners(com.w2a.listeners.CustomListeners.class)

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		System.setProperty("org.uncommons.reportng.escape-output","false");
		log.debug("Inside Login Test");
//		
		//driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
//		
		TestBase.driver.findElement(By.xpath(OR.getProperty("bmlBt"))).click();
//		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomerBtn"))),"Login not successful");
	
////		log.debug("Login successfully executed");
//		
//		//Assert.fail("Login not successful");
		
				
		
	}
	
	

}
