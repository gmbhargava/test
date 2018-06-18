package com.omnimobile.commonUtilities;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import PageFactory.Login;
import PageFactory.TransactionHistoryList;
import PageFactory.Acountdashboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import com.omnimobile.commonUtilities.commonUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Apploader {
	
	 public static IOSDriver<MobileElement> driver;
	 public static String propertyFile="config.properties";
	 public static Login loginPage;
	 public static Acountdashboard accountDashboardPage;
	 public static TransactionHistoryList transactionHistoryPage;
	 public static ExtentReports report=commonUtil.returnInstance();
	 public static ExtentTest test;
	
	 @BeforeSuite(alwaysRun=true)
	  public void setup() throws IOException
	 {
		 
		 if(driver==null)
		 {
		 
		
			 commonUtil.loadConfig(propertyFile);
			 commonUtil.setCapabilities();
		
			driver= commonUtil.getDriver();
		    loginPage=new Login(driver);
		    accountDashboardPage=new Acountdashboard(driver);
		    transactionHistoryPage=new TransactionHistoryList(driver);
		    
			 
		
		 }
		 
	 }
	
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		driver.quit();
		 
		 
	 }
	 
  


	
	
	
	}
