package com.omnimobile.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;
import com.relevantcodes.extentreports.LogStatus;

public class listener extends Apploader implements ITestListener{

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
		test.log(LogStatus.FAIL, testResult.getMethod().getMethodName()+"FAIL");
		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(commonUtil.getScreenshot(testResult.getName())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, arg0.getMethod().getMethodName()+"PASS");
		report.endTest(test);
		report.flush();
		
	}

}
