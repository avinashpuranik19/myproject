package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

//	public void onTestFailure(ITestResult arg0) {
//		
//		
//TestBase.test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+"FAIL");
//		
//		rep.endTest(test);
//		
//		rep.flush();
//		
//	
//	
//		
//	}

	
	public void onTestFailure(ITestResult arg0) {
		
	// For ReportNG
		System.setProperty("org.commons.reportng.escape-output", "false");
		
		Reporter.log("Capturing screenshot");
		
		
		
	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {

		TestBase.test = rep.startTest(arg0.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Test is pass");
		
		TestBase.test.log(LogStatus.PASS, arg0.getName().toUpperCase()+"   PASS");
		
		rep.endTest(test);
		
		rep.flush();
		
				
		
	}

	
}
