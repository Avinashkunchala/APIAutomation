package com.APIAutomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.APIAutomation.TestBase.TestBase;

public class TestNGListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName() + "  execution is started");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getName() + "  successfully executed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName() +"  is failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getName()+"  is skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
  
}

