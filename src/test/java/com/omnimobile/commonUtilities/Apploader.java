package com.omnimobile.commonUtilities;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageFactory.Acountdashboard;
import PageFactory.Login;
import PageFactory.LoginHelp;
import PageFactory.SendEnterAmountScreen;
import PageFactory.TransactionHistoryList;
import PageFactory.ZelleRequesSelectRecipient;
import PageFactory.ZelleRequestConfirmationScreen;
import PageFactory.ZelleRequestEnterAmountScreen;
import PageFactory.ZelleRequestReview;
import PageFactory.ZelleSendConfirmationScreen;
import PageFactory.ZelleSendReviewScreen;
import PageFactory.ZelleSendSelectRecipient;
import PageFactory.ZelleSplitMoneyEnterAmount;
import PageFactory.ZelleSplitMoneyRecipient;
import PageFactory.ZelleSplitReview;
import PageFactory.navigationDashboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Apploader {
	
	 public static IOSDriver<MobileElement> driver;
	 public static String propertyFile="config.properties";
	 public static Login loginPage;
	 public static Acountdashboard accountDashboardPage;
	 public static ZelleRequesSelectRecipient zelleSelectRecipient ;
	 public static ZelleRequestEnterAmountScreen enterAmountTests;
	 public static ZelleRequestConfirmationScreen zelleRequestConfirmationScreen ;
	 public static ZelleSendSelectRecipient zelleSendSelectRecipientTests ;
	 public static SendEnterAmountScreen sendEnterAmountScreen;
	 public static ZelleSendReviewScreen zelleSendReviewScreen;
	 public static ZelleSplitMoneyRecipient zelleSplitMoney;
	 public static ZelleSplitMoneyEnterAmount zelleSplitMoneyEnterAmount;
	 public static ZelleRequestReview zelleRequestReview ;
	 public static ZelleSplitReview zelleSplitReview;
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
		    zelleSelectRecipient=new ZelleRequesSelectRecipient(driver);
		   enterAmountTests=new ZelleRequestEnterAmountScreen(driver);
		   zelleRequestConfirmationScreen=new ZelleRequestConfirmationScreen (driver);
		   zelleRequestReview=new ZelleRequestReview (driver); 
		   zelleSendSelectRecipientTests=new ZelleSendSelectRecipient(driver);
		   sendEnterAmountScreen=new SendEnterAmountScreen(driver);
		   zelleSendReviewScreen=new ZelleSendReviewScreen(driver);
		   zelleSendConfirmationScreen=new ZelleSendConfirmationScreen(driver);
		   zelleSplitMoney=new ZelleSplitMoneyRecipient(driver);
		   zelleSplitReview=new ZelleSplitReview(driver);
		    wait=new WebDriverWait(driver,30);		    
		    
             Loginhelppage =new LoginHelp(driver);
             nav_DashboardPage = new navigationDashboard(driver);
             transactionHistoryPage=new TransactionHistoryList(driver);
		    
             zelleSplitMoneyEnterAmount=new ZelleSplitMoneyEnterAmount(driver);
			 
		
		 }
		 
	 }
	
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		//driver.quit();
		 
		 
	 }
	 
  


	
	
	
	}
