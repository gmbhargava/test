package com.omnimobile.commonUtilities;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import PageFactory.Login;
import PageFactory.Acountdashboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import com.omnimobile.commonUtilities.commonUtil;

public class Apploader {
	
	 public static IOSDriver<MobileElement> driver;
	 public static String propertyFile="config.properties";
	 public static Login loginPage;
	 public static Acountdashboard accountDashboardPage;
	 
	
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
		    
		    
		 }
	 }
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
  


	
	
	
	}
