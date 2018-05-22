package com.omnimobile.Testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.omnimobile.commonUtilities.Apploader;

import PageFactory.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class AccountAccess extends Apploader {

	private static String Username="Sample username";
	private static String password="Sample password";

	 
	
	@Test  (groups= {"RegressionTest","smokeTest"}) 
	public void login() 
	{
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.loginButton().click();
		accountDashboardPage.logOutButton().click();
		
	}
	
	
	
	@Test (groups= {"RegressionTest"})
	public void clearUsername() throws InterruptedException
	{
		loginPage.userNameTextBox().sendKeys(Username);
		Thread.sleep(2000);
		loginPage.clearTexticon().click();
		if(loginPage.userNameTextField().getAttribute("value")==null)
           {
			   
	          System.out.println("Test passed: username text cleared");
            }
		else
		{
			
			Assert.fail("Test failed: userName text is not cleared");
		}
		
	}
	@Test (groups= {"RegressionTest","smokeTest"})
	public void rememberMe()
	{
		
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.rememberMeSwitch().click();
		loginPage.loginButton().click();
		accountDashboardPage.logOutButton().click();
		
		String value=loginPage.userNameTextField().getAttribute("value").replace("*", "");
		if(Username.contains(value))
		{
			System.out.println("Test passed. userName is cached");
		}
		else
		{
			Assert.fail("Test failed: userName is not remembered");
		}
		
		loginPage.clearTexticon().click();
		
		
	}
	
	@Test(groups= {"RegressionTest"})
	public void showPassword()
	{
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.showPasswordIcon().click();
		String displayedPassword=loginPage.passwordTextbox().getAttribute("value");
		if(displayedPassword.equals(password))
		{
			System.out.println("Test passed, user is able to see password");
		}
		else	
		{
			Assert.fail("User is not able to see password after clicking on Show password icon");
		}
	}
	
	/*@Test
	 * 
	public void viewTransactions()
	{
		MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeCell[2]");
		el1.sendKeys("sampleUsername");
		
		MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeCell[3]");
		el2.sendKeys("Sample Password");
		
		MobileElement ele1 = (MobileElement)driver.findElementByXPath("//XCUIElementTypeCell[2]/XCUIElementTypeTextField") ;
		
		
		System.out.println(ele1.getAttribute("value"));
	    
		MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeCell[5]//XCUIElementTypeButton");
		el3.click();
		MobileElement viewTransactions=(MobileElement)driver.findElementByXPath("//XCUIElementTypeButton[@name='View Transactions']");
		viewTransactions.click();
	}*/
}
