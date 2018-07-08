package com.omnimobile.Testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import PageFactory.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class ZelleSendReviewTests extends Apploader {

	 public static String Username;
	 public static String password;
	 public static String amount;
	 public static String reviewBtn;

	 @BeforeTest
		public void login() throws IOException 
		{
			try {
				Username=commonUtil.loadTestData("Username");
				password=commonUtil.loadTestData("password");	
				amount=commonUtil.loadTestData("amount");
				loginPage.userNameTextBox().sendKeys(Username);
				loginPage.passwordTextbox().sendKeys(password);
				driver.hideKeyboard();
				loginPage.loginButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
				Thread.sleep(9000);
				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.zelleSendButton()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
			
		}
	 
	 
	 
	 @Test(groups = { "RegressionTest"},priority=0,alwaysRun=true)
		public void verifyReviewScreen() throws InterruptedException {
		 	
		 	zelleSendSelectRecipientTests.zelleSendButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.selectRecipientLabel()));
			List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			Assert.assertTrue((zelleSendSelectRecipientTests.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
			zelleSelectRecipient.emailTokens().get(0).click();

			Reporter.log("Token selected successfully");
			Reporter.log("Recipient selected As Expected");
			wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
			Assert.assertTrue(this.sendEnterAmountScreen.sendMoneyLable().isDisplayed()," Enter amount header not displayed");
		
			Reporter.log(" Amount header displayed as expected");
			
			sendEnterAmountScreen.enterAmntField().clear();
			sendEnterAmountScreen.enterAmntField().sendKeys(this.amount);
			sendEnterAmountScreen.doneButtn().click();
			Reporter.log(" Amount Entered succesfully");
			wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.reviewButtn()));
			Assert.assertTrue(this.sendEnterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			Reporter.log(" Rview button enabled for maximum amount as expected");
			
			this.sendEnterAmountScreen.reviewButtn().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSendReviewScreen.reviewFlowLabl()));
			Assert.assertTrue(this.zelleSendReviewScreen.sendLabl().isDisplayed()," Review screen not displayed");
			//this.zelleSendReviewScreen.messageInput().sendKeys("Test Message");
			//sendEnterAmountScreen.doneButtn().click();
			Reporter.log(" Review screen displayed as expected");
		}
	
	 
	 
	 
	 
	 
  @Test(groups = { "RegressionTest"},priority=6)
public void verifyBackButton() {

	
	sendEnterAmountScreen.backButton().click();
	wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
	Assert.assertTrue(sendEnterAmountScreen.selectAmountLabel().isDisplayed()," Select recipients screen not displayed");

	Reporter.log(" Select recipients screen displayed");
	
	
	
	
}

	 
    
	
}












	



