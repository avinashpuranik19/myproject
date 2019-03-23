package com.w2a.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	//@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	
	// first program 23 march
	
	@Test(dataProvider="getData")
	
	
	public void addCustomer(String firstname, String lastname, String postcode,String alerttext) throws InterruptedException
	{
		
//		click("addCustomerBtn");
//		
//		entervalue("firstname",firstname);
//		entervalue("lastname",lastname);
		
		//TestBase.driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		
		TestBase.driver.findElement(By.xpath(OR.getProperty("addCustomerBtn"))).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
		
		driver.findElement(By.xpath(OR.getProperty("clickAddButton"))).click();
		
		
		
//		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alerttext));
		
		Thread.sleep(3000);
		
		alert.accept();
		
		Thread.sleep(3000);
		
				
		
	}
	
	
	@DataProvider
	public Object [] [] getData()
	{
		//String sheetName=m.getName();
		String sheetName="AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		
		Object [] [] data = new Object [rows-1] [cols];
		
		for (int rowNum=2;rowNum<=rows;rowNum++)
		{
			
			for (int colNum=0;colNum<cols;colNum++)
			{
				
				data [rowNum-2][colNum]=excel.getCellData("AddCustomerTest", colNum, rowNum);
				
			}
			
			
		}
		
		return data;
		
	}
	
	
	
	
	

}
