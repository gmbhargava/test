package com.omnimobile.Testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import PageFactory.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class AccountAccess extends Apploader {

	private static String Username="userapp01";
	private static String password="spring18";
	
	/*
	 ********************************************************
	 * Testcase covers Unrecognized user standard login flow
	 ********************************************************
	 */
	@Test  (groups= {"RegressionTest","smokeTest"}, priority = 1) 
	public void UnRU_Standardlogin() throws InterruptedException 
	{
			loginPage.userNameTextBox().click();
			loginPage.userNameTextBox().sendKeys(Username);
			loginPage.passwordTextbox().sendKeys(password);	
			if((Username.length() >=7 || Username.length() <=22) && (password.length() >=8 || password.length() <=24))
			{
				if(loginPage.loginButton().isEnabled() == true)
				{
					loginPage.loginButton().click();
			
				}
			}
			
		try 
		{
		
			loginPage.PageLevelError().getText();
			String PageError = (loginPage.PageLevelError().getText());
			if((PageError == "The username or password you entered is incorrect. Do you need help logging in?") && PageError.equals(loginPage.PageLevelError().getText()))
			{
				System.out.println("User is able to see Page Level Error, Wrong login credentials");
				
			}
			else
			{
				System.out.println("User is not able to see error alert");
				
			}
		} 
		
		catch (Exception e) 
		{
		
		Thread.sleep(4000);
		accountDashboardPage.logOutButton().click();
	
		e.printStackTrace();
		
		}
		
		
	}
	
	
	/*
	 ********************************************************
	 * Testcase covers clearusername functionality
	 ********************************************************
	 */
	
	@Test (groups= {"RegressionTest"}, priority = 2)
	public void clearUsername() throws InterruptedException
	{
		if(loginPage.userNameTextField().getAttribute("value")!=null)
		{
			loginPage.userNameTextBox().click();
			loginPage.clearTexticon().click();
			if(loginPage.userNameTextField().getAttribute("value")==null)
	           {
				   
		          System.out.println("Test passed: username text cleared");
	            }
			else
			{
				System.out.println("Test failed: userName text is not cleared");
			}
			
		}
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.clearTexticon().click();
		driver.findElement(By.name("Dismiss")).click();
		loginPage.userNameTextBox().click();
		if(loginPage.userNameTextField().getAttribute("value")==null)
           {
			   
	          System.out.println("Test passed: username text cleared");
            }
		else
		{
			
			System.out.println("Test failed: userName text is not cleared");
		}
		
		
	}
	
	/*
	 ********************************************************
	 * Testcase covers rememberMe functionality
	 ********************************************************
	 */
	
	@Test (groups= {"RegressionTest","smokeTest"}, priority = 3)
	public void rememberMe() throws InterruptedException
	{

		loginPage.userNameTextBox().click();
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		//loginPage.showPasswordIcon().click();
		loginPage.rememberMeSwitch().click();
		driver.findElement(By.name("Dismiss")).click();
		loginPage.loginButton().click();	
		
				
	try {
			loginPage.PageLevelError().getText();
			String PageError = (loginPage.PageLevelError().getText());
			if((PageError == "The username or password you entered is incorrect. Do you need help logging in?") && PageError.equals(loginPage.PageLevelError().getText()))
			{
				System.out.println("Login credentials are invalid");
				
			}
			else
			{
				System.out.println("Test Fail, user is not able to see error alert");
				
			}
		}
		
		catch (Exception e) 
			{
				accountDashboardPage.logOutButton().click();
				e.printStackTrace();
			}
	
		loginPage.userNameTextBox().click();
		
		
		String cachedUsername = loginPage.userNameTextField().getText().toString();
		
		System.out.println(cachedUsername);
		
		if(cachedUsername.substring(0, 5).equalsIgnoreCase(Username.substring(0, 5)))
		{
				if(cachedUsername.substring(5, 10).equalsIgnoreCase("*****"))
			{
				System.out.println("The username is encrypted");
			}
		
		}
		else
			System.out.println("The username is not encrypted");
		
		
	}
	
	
	/*
	 ********************************************************
	 * Testcase covers showPassword functionality
	 ********************************************************
	 */
	
	
	@Test(groups= {"RegressionTest"}, priority =4)
	public void showPassword() throws InterruptedException
	{
		
		if(loginPage.userNameTextField().getAttribute("value")==null)
			{
				loginPage.userNameTextBox().sendKeys(Username);
			}
		
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.showPasswordIcon().click();
		//driver.findElement(By.name("Dismiss")).click();
		Thread.sleep(3000);
		String displayedPassword=loginPage.passwordTextbox().getText();
		if(displayedPassword == password)
		{
			System.out.println("Test passed, user is able to see password");
		}
		else	
		{
			System.out.println("User is not able to see password after clicking on Show password icon");
		}
	}
	
	
	/*
	 ********************************************************
	 * Testcase covers PageLevelError functionality
	 ********************************************************
	 */
	
	
	@Test(groups= {"RegressionTest"}, priority = 5)
	public void pagelevelError() throws InterruptedException
	{
		
		loginPage.userNameTextBox().clear();
		loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys("wrong username");
		loginPage.passwordTextbox().sendKeys("wrong password");
		driver.findElement(By.name("Dismiss")).click();
		loginPage.loginButton().click();
		loginPage.PageLevelError().getText();
		String PageError = (loginPage.PageLevelError().getText());
		if((PageError == "The username or password you entered is incorrect. Do you need help logging in?") && PageError.equals(loginPage.PageLevelError().getText()))
		{
			System.out.println("Test passed, user is able to see Page Level Error");
			
		}
		else
		{
			Assert.fail("Test Fail, user is not able to see error alert");
			
		}
		
	}
	
	
	
}
