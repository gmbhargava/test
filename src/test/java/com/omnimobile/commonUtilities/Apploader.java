package com.omnimobile.commonUtilities;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import PageFactory.Login;
import PageFactory.SendEnterAmountScreen;
import PageFactory.ZelleRequestConfirmationScreen;
import PageFactory.ZelleSelectRecipient;
import PageFactory.ZelleSendConfirmationScreen;
import PageFactory.ZelleSendReviewScreen;
import PageFactory.ZelleSendSelectRecipientScreen;
import PageFactory.LoginHelp;
import PageFactory.TransactionHistoryList;
import PageFactory.navigationDashboard;
import PageFactory.Acountdashboard;
import PageFactory.EnterAmountScreen;
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
	 public static ZelleSelectRecipient zelleSelectRecipient ;
	 public static EnterAmountScreen enterAmountScreen;
	 public static ZelleRequestConfirmationScreen zelleRequestConfirmationScreen ;
	 public static ZelleSendSelectRecipientScreen zelleSendSelectRecipientScreen ;
	 public static SendEnterAmountScreen sendEnterAmountScreen;
	 public static ZelleSendReviewScreen zelleSendReviewScreen;
	 public static WebDriverWait wait;
	 
	 public static TransactionHistoryList transactionHistoryPage;
     public static Login loginhelp;
     public static LoginHelp Loginhelppage;
     public static navigationDashboard nav_DashboardPage;
     public static ZelleSendConfirmationScreen zelleSendConfirmationScreen;
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
		    zelleSelectRecipient=new ZelleSelectRecipient(driver);
		   enterAmountScreen=new EnterAmountScreen(driver);
		   zelleRequestConfirmationScreen=new ZelleRequestConfirmationScreen (driver);
		   zelleSendSelectRecipientScreen=new ZelleSendSelectRecipientScreen(driver);
		   sendEnterAmountScreen=new SendEnterAmountScreen(driver);
		   zelleSendReviewScreen=new ZelleSendReviewScreen(driver);
		   zelleSendConfirmationScreen=new ZelleSendConfirmationScreen(driver);
		    wait=new WebDriverWait(driver,30);		    
		    
             Loginhelppage =new LoginHelp(driver);
             nav_DashboardPage = new navigationDashboard(driver);
             transactionHistoryPage=new TransactionHistoryList(driver);
		    
			 
		
		 }
		 
	 }
	
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		//driver.quit();
		 
		 
	 }
	 
  


	
	
	
	}
