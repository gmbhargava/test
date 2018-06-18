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
	@Test  (groups= {"RegressionTest","smokeTest"}) 
	public void login() throws InterruptedException 
	{
		loginPage.userNameTextBox().clear();
		loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		driver.findElement(By.name("Dismiss")).click();
		loginPage.loginButton().click();
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		accountDashboardPage.logOutButton().click();
		Thread.sleep(3000);
		
	}*/
	/*
	
	@Test (groups= {"RegressionTest"})
	public void clearUsername() throws InterruptedException
	{
		
		loginPage.userNameTextBox().clear();
		loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.clearTexticon().click();
		driver.findElement(By.name("Dismiss")).click();
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
	public void rememberMe() throws InterruptedException
	{
		loginPage.userNameTextBox().click();
		
		loginPage.clearTexticon().click();
		
		loginPage.rememberMeSwitch().click();
		
		Thread.sleep(2000);
		//loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.showPasswordIcon().click();
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
				Assert.fail("Test Fail, user is not able to see error alert");
				
			}
		}
		
		catch (Exception e) 
			{
				e.printStackTrace();
			}
			Thread.sleep(5000);
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
	
	@Test(groups= {"RegressionTest"})
	public void showPassword()
	{
		
		loginPage.userNameTextBox().clear();
		loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		loginPage.showPasswordIcon().click();
		driver.findElement(By.name("Dismiss")).click();
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
	
	@Test(groups= {"RegressionTest"})
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
		
	}*/
	
	
	
}
