package com.omnimobile.commonUtilities;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import PageFactory.Login;
import PageFactory.ZelleRequestConfirmationScreen;
import PageFactory.ZelleSelectRecipient;
import PageFactory.Acountdashboard;
import PageFactory.EnterAmountScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import com.omnimobile.commonUtilities.commonUtil;

public class Apploader {
	
	 public static IOSDriver<MobileElement> driver;
	 public static String propertyFile="config.properties";
	 public static Login loginPage;
	 public static Acountdashboard accountDashboardPage;
	 public static ZelleSelectRecipient zelleSelectRecipient ;
	 public static EnterAmountScreen enterAmountScreen;
	 public static ZelleRequestConfirmationScreen zelleRequestConfirmationScreen ;
	 public static WebDriverWait wait;
	 
	
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
		    this.enterAmountScreen=new EnterAmountScreen(driver);
		    this.zelleRequestConfirmationScreen=new ZelleRequestConfirmationScreen (driver);
		    wait=new WebDriverWait(driver,30);		    
		    
		 }
	 }
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
  


	
	
	
	}
