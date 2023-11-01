package com.pet.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.pet.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportListener extends TestBase implements ITestListener{
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		reports = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\report\\report.html",false);
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, "Test Execution started");
	}
	
    @Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" Failed due to "+result.getThrowable());
		test.log(LogStatus.FAIL, "Test Execution Failed");
		
		
		reports.endTest(test);
		reports.flush();
		
	}
    
    @Override
    public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" Passed");
		test.log(LogStatus.PASS, "Test Execution Successful");
		
		reports.endTest(test);
		reports.flush();
		
	}
    
    @Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" Skipped");
		test.log(LogStatus.SKIP, "Test Execution Skipped");
		
		
		reports.endTest(test);
		reports.flush();
		
	}
	
	
}