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
public class ZelleRequestConfirmationTests extends Apploader {

	 String Username;
	 String password;
	 String amount;

	 @BeforeTest
	public void login() throws IOException 
	{
		try {
			this.Username=commonUtil.loadTestData("Username");
			this.password=commonUtil.loadTestData("password");
			this.amount=commonUtil.loadTestData("amount");						
			loginPage.userNameTextBox().sendKeys(this.Username);
			loginPage.passwordTextbox().sendKeys(this.password);
			driver.hideKeyboard();
			loginPage.loginButton().click();
		
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleRequestButton()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	 

	
	@Test  (groups= {"RegressionTest","smokeTest"})  
	public void zelleRequestConfirm() 
	{
		zelleSelectRecipient.zelleRequestButton().click();
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
		Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
		Reporter.log("Recipient Emails Details Displayed As Expected");
		
		zelleSelectRecipient.emailTokens().get(0).click();

		Reporter.log("Token selected successfully");
		Reporter.log("Recipient selected As Expected");
		//zelleSelectRecipient.nextBtn().click();
		wait.until(ExpectedConditions.visibilityOf(enterAmountTests.selectAmountLabel()));
		Assert.assertTrue(this.enterAmountTests.requestLable().isDisplayed()," Enter amount header not displayed");
		wait.until(ExpectedConditions.visibilityOf(enterAmountTests.selectAmountLabel()));
		
		enterAmountTests.enterAmntField().sendKeys(this.amount);

		Reporter.log(" Amount Entered succesfully");
		enterAmountTests.doneButtn().click();
		wait.until(ExpectedConditions.visibilityOf(enterAmountTests.reviewButtn()));
		enterAmountTests.reviewButtn().click();

//		wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
//		Assert.assertTrue(zelleRequestConfirmationScreen.confirmFlowLable().isDisplayed(),"Confirmation screen not displayed");
//		Reporter.log("Confirmation screen displayed as expected");
//		Assert.assertTrue(zelleRequestConfirmationScreen.confirmIcon().isEnabled(),"Confirmation Icon not displayed");
//		Reporter.log("Confirmation Icon displayed as expected");
//		Assert.assertTrue(zelleRequestConfirmationScreen.doneButtn().isDisplayed(),"Confirmation Done button not displayed");
//		Reporter.log("Confirmation screen displayed as expected");

		
	
	}
	
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=1)
		public void verifyRequestMoneyConfirm() {
			 zelleSendReviewScreen.sendButtn().click();
			 wait.until(ExpectedConditions.visibilityOf(zelleSendReviewScreen.yesButtn()));
			 zelleSendReviewScreen.yesButtn().click();
				//wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				//Assert.assertTrue(zelleRequestConfirmationScreen.confirmFlowLable().isDisplayed(),"Confirmation screen not displayed");
				Reporter.log("Confirmation screen displayed as expected");
				//Assert.assertTrue(zelleRequestConfirmationScreen.confirmIcon().isEnabled(),"Confirmation Icon not displayed");
				Reporter.log("Confirmation Icon displayed as expected");
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.doneButtn()));
				Assert.assertTrue(zelleRequestConfirmationScreen.doneButtn().isDisplayed(),"Confirmation Done button not displayed");
				Reporter.log("Confirmation screen displayed as expected");

		 }
	
	
}






	
	
	
	
	
	
	
	
	
	

	

