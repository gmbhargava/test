package com.omnimobile.Testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.omnimobile.commonUtilities.Apploader;

import PageFactory.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class ZelleRequestConfirmationSteps extends Apploader {

	private static String recipientName="Kranthi";
	private CharSequence recipientPhoneNumber="";
	private CharSequence recipientEmail;
	private CharSequence recipientList;
	
	private static String Username="asdfghj";
	private static String password="12345666";

	 
	
	@BeforeTest
	public void login() 
	{
		try {
		loginPage.userNameTextBox().sendKeys(Username);
		loginPage.passwordTextbox().sendKeys(password);
		driver.hideKeyboard();
		loginPage.loginButton().click();
//		if(loginPage.goButton().isDisplayed()) {
//			loginPage.goButton().click();
		//driver.hideKeyboard();
//		}
//		loginPage.loginButton().click();
//		
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 

	
	@Test  (groups= {"RegressionTest","smokeTest"})  
	public void zelleRequestConfirm() 
	{
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailToken()));
		zelleSelectRecipient.emailToken().click();
		Reporter.log("Recipient selected As Expected");
		zelleSelectRecipient.nextBtn().click();
		wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
		
		enterAmountScreen.enterAmntField().sendKeys("1234");
		enterAmountScreen.doneButtn().click();
		wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.reviewButtn()));
		
		enterAmountScreen.reviewButtn().click();
//		TouchActions action = new TouchActions(driver);
//		action.doubleTap(enterAmountScreen.reviewButtn());
//		action.perform();

		System.out.println("reviewbtnClicked");
		Reporter.log(" Amount Entered succesfully");
		wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmIcon()));
		Assert.assertTrue(zelleRequestConfirmationScreen.confirmFlowLable().isDisplayed(),"Confirmation screen not displayed");
		Reporter.log("Confirmation screen displayed as expected");
		Assert.assertTrue(zelleRequestConfirmationScreen.confirmIcon().isDisplayed(),"Confirmation Icon not displayed");
		Reporter.log("Confirmation Icon displayed as expected");
		Assert.assertTrue(zelleRequestConfirmationScreen.doneButtn().isDisplayed(),"Confirmation Done button not displayed");
		Reporter.log("Confirmation screen displayed as expected");

		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
