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

	/**
	 * @author Nagarjuna Reddy
	 * 
	 *  ZelleRequestConfirmationTests.
	 */
	
	 String Username;
	 String password;
	 String amount;
	 String message;
	 
	 @BeforeTest
	public void login() throws IOException 
	{
		try {
			this.Username=commonUtil.loadTestData("Username");
			this.password=commonUtil.loadTestData("password");
			this.amount="33.17";	
			this.message="Test Message";
			
			loginPage.userNameTextBox().sendKeys(this.Username);
			loginPage.passwordTextbox().sendKeys(this.password);
			driver.hideKeyboard();
			//loginPage.loginButton().click();
		
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			
			zelleSelectRecipient.zelleButton().click();
			
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleRequestButton()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	 //OMAV-T1188 (1.0)  Money_Zelle_UI_Request_Confirmation_Header

	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=0,alwaysRun=true)  
	public void verifyRequest_Confirmation_Header() throws InterruptedException 
	{
		zelleSelectRecipient.zelleRequestButton().click();
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
		Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
		Reporter.log("Recipient Emails Details Displayed As Expected");
		zelleSelectRecipient.emailTokens().get(0).click();
		Reporter.log("Recipient selected As Expected");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(enterAmountTests.selectAmountLabel()));
		enterAmountTests.enterAmntField().sendKeys(this.amount);
		enterAmountTests.doneButtn().click();
		enterAmountTests.reviewButtn().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(zelleRequestReview.reviewFlowLabl()));
		zelleRequestReview.inputMessage().sendKeys(this.message);
		enterAmountTests.doneButtn().click();
		zelleRequestReview.sendButtn().click();
		zelleRequestReview.yesBtn().click();
		Reporter.log("  Amount is displayed as the amount entered in Enter Amount screen");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
		String confirmHeader=zelleRequestConfirmationScreen.confirmFlowLable().getAttribute("name");
		Thread.sleep(3000);
		Assert.assertTrue(confirmHeader.equalsIgnoreCase("CONFIRMATION"),"Confirmation screen not displayed");
		Reporter.log("Confirmation screen displayed as expected");
		String confirmTitle=zelleRequestConfirmationScreen.requestLable().getAttribute("value");
		Thread.sleep(3000);
		Assert.assertTrue(confirmTitle.equalsIgnoreCase("Request Money"),"Confirmation Title not displayed");
		Reporter.log("Confirmation title displayed as expected");
		
	
	}
	
	 //OMAV-T1614 (1.0) Money_Zelle_UI_Request_Confirmation_Account

	
		@Test  (groups= {"RegressionTest","smokeTest"},priority=1,alwaysRun=true)  
		public void verifyRequest_Confirmation_Account() throws InterruptedException 
		{
			
			wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
			String confirmAccnNum=zelleRequestConfirmationScreen.confirmationDetails().get(1).getAttribute("value");
			System.out.println(" Account details displayed as "+confirmAccnNum);
			Thread.sleep(3000);
			Assert.assertTrue((confirmAccnNum.contains("Checking.") || confirmAccnNum.contains("Savings."))," Account type not displayed in Confirmation screen");
			Reporter.log("Account type displayed in Confirmation screen");
			Assert.assertTrue((confirmAccnNum.contains("@"))," Email not displayed in Confirmation screen");
			Reporter.log("Email displayed in Confirmation screen");
		
		}
	
		 //OMAV-T1609 (1.0) Money_Zelle_UI_Request_Confirmation_Amount

		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=2,alwaysRun=true)  
		public void verifyRequest_Confirmation_Amount() throws InterruptedException 
		{
			
			wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
			String confirmAmnt=zelleRequestConfirmationScreen.confirmationAmount().getAttribute("value");
			System.out.println(" Amount details displayed as "+confirmAmnt);

			Assert.assertTrue(confirmAmnt.equals(this.amount)," Amount not displayed in Confirmation screen");
			Reporter.log("Amount displayed in Confirmation screen");
		
		}
		
		//OMAV-T1611 (1.0) Money_Zelle_UI_Request_Confirmation_ConfirmationNumber

		
			@Test  (groups= {"RegressionTest","smokeTest"},priority=3,alwaysRun=true)  
			public void verifyRequest_Confirmation_ConfirmationNumber() throws InterruptedException 
			{
				
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				String confirmnNum=zelleRequestConfirmationScreen.confirmationDetails().get(0).getAttribute("value");
				System.out.println(" AConfirmation number details displayed as "+confirmnNum);
				Assert.assertTrue((confirmnNum.length()>4)," Confirmation number not displayed in Confirmation screen");
				Reporter.log("Confirmation number displayed in Confirmation screen");
			
			}
			
			//OMAV-T1654 (1.0) Money_Zelle_UI_Request_Confirmation_Message

			
			@Test  (groups= {"RegressionTest","smokeTest"},priority=4)  
			public void verifyRequest_Confirmation_Message() throws InterruptedException 
			{
				
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				String confirmMsg=zelleRequestConfirmationScreen.confirmationDetails().get(2).getAttribute("value");
				System.out.println(" Message  details displayed as "+confirmMsg);
				Assert.assertTrue((confirmMsg.equalsIgnoreCase(this.message))," Message not displayed in Confirmation screen");
				Reporter.log("Message displayed in Confirmation screen");
			
			}
	
			
			//OMAV-T1605 (1.0) Money_Zelle_UI_Request_Confirmation_RecipientDetail
			//Test CasesOMAV-T1519 (1.0) Money_Zelle_UI_Request_Confirmation_RecipientDetail_Avatar

			
			@Test  (groups= {"RegressionTest","smokeTest"},priority=5)  
			public void verifyRequest_Confirmation_RecipientDetail() throws InterruptedException 
			{
				
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				Assert.assertTrue((zelleRequestConfirmationScreen.recipientName().isDisplayed())," Recipient name not displayed in Confirmation screen");
				Reporter.log("Recipient name displayed in Confirmation screen");
				
				Assert.assertTrue((zelleRequestConfirmationScreen.recipientToken().isDisplayed())," Recipient token not displayed in Confirmation screen");
				Reporter.log("Recipient token displayed in Confirmation screen");
				//Assert.assertTrue((zelleRequestConfirmationScreen.recipientAvatar().isDisplayed())," Recipient Avatar not displayed in Confirmation screen");
				//Assert.assertTrue((zelleRequestConfirmationScreen.confirmIcon().isDisplayed())," Confirmation Icon not displayed in Confirmation screen");

				//Reporter.log("Confirmation Icon displayed in Confirmation screen");
			
			}
			
//OMAV-T1655 (1.0) Money_Zelle_UI_Request_Confirmation_RequestExpiresMessage

			
			@Test  (groups= {"RegressionTest","smokeTest"},priority=6)  
			public void verifyRequest_Confirmation_RequestExpiresMessage() throws InterruptedException 
			{
				
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				String expiryMsg=zelleRequestConfirmationScreen.expiryMessage().getAttribute("value");
				System.out.println(" Expiry Message  details displayed as "+expiryMsg);
				
				
				Assert.assertTrue((expiryMsg.equalsIgnoreCase("Your request(s) expire(s) in 30 days"))," Expiry Message not displayed in Confirmation screen");
				Reporter.log("Expiry Message displayed in Confirmation screen");
			
			}
			
			//OMAV-T1189 (1.0) Money_Zelle_UI_Request_Confirmation_Done

			
			@Test  (groups= {"RegressionTest","smokeTest"},priority=7)  
			public void verifyRequest_Confirmation_Done() throws InterruptedException 
			{
				
				wait.until(ExpectedConditions.visibilityOf(zelleRequestConfirmationScreen.confirmFlowLable()));
				zelleRequestConfirmationScreen.doneButtn().click();
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(zelleRequestReview.greetingLable()));
				Assert.assertTrue(zelleRequestReview.greetingLable().isDisplayed() , "Unable to navigate back from Confirmation  screen");
				Reporter.log(" User navigated back from confirmation screen as expected ");
			
			}
			
	
}