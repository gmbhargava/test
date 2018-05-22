package com.omnimobile.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener{

	@Override
	public void onFinish(ITestContext test) {
		// TODO Auto-generated method stub
		System.out.println("Test Case finished"+test.getName());
	}

	@Override
	public void onStart(ITestContext test) {
		// TODO Auto-generated method stub
		System.out.println("Test Case started"+test.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed"+ testResult.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Case started"+arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Case passed"+arg0);
		
	}

}
