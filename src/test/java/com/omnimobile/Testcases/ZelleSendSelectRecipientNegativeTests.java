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
import PageFactory.ZelleSendSelectRecipient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class ZelleSendSelectRecipientNegativeTests extends Apploader {
	
	/**
	 * @author Nagarjuna Reddy
	 * @story
	 *  ZelleSendSelectRecipientNegativeTests.
	 */
	
	
	

	 String recipientName;
	 String  recipientEmail;
	 String recipientFirstName;
	 String recipientPhoneNumber;
	 String  recipientLastName;
	 String spanishName;
	 String specialCharEmail;
	 String Username;
	 String password;
	 String unEnrolledNumber;

	 @BeforeTest
		public void login() throws IOException 
		{
			try {
				this.Username=commonUtil.loadTestData("Username");
				this.password=commonUtil.loadTestData("password");
				this.recipientName=commonUtil.loadTestData("recipientName");
				this.recipientPhoneNumber =commonUtil.loadTestData("phoneNumberToken");
				this.recipientEmail=commonUtil.loadTestData("emailToken");
				this.recipientFirstName=commonUtil.loadTestData("recipientFirstName");
				this.recipientLastName=commonUtil.loadTestData("recipientLastName");
				this.specialCharEmail=commonUtil.loadTestData("specialCharEmail");
				unEnrolledNumber=commonUtil.loadTestData("unEnrolledNumber");
				spanishName=commonUtil.loadTestData("spanishName");
				loginPage.userNameTextBox().sendKeys(this.Username);
				loginPage.passwordTextbox().sendKeys(this.password);
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
		
	 
   
				
//		 	 
			
				@Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
				public void verifyRecipientSearchByEmailNoMatch() throws InterruptedException {
					zelleSendSelectRecipientTests.filterField().clear();
					zelleSendSelectRecipientTests.filterField().click();
					zelleSendSelectRecipientTests.filterField().sendKeys("invalid_$#DD@inalidmail.com");
					Reporter.log("Email entered in the  Filter");
					Thread.sleep(4000);
					List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

					Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
					Reporter.log(" No Recipients Details  Displayed As per the invalid email the Applied Filtered");

				}
				
//			 	 
				
				@Test(groups = { "RegressionTest", "smokeTest" }, priority = 1)
				public void verifyRecipientSearchByNameNoMatch() throws InterruptedException {
					zelleSendSelectRecipientTests.filterField().clear();
					zelleSendSelectRecipientTests.filterField().click();
					zelleSendSelectRecipientTests.filterField().sendKeys("InavlidName");
					Reporter.log("Name entered in the  Filter");
					Thread.sleep(4000);
					List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

					Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
					Reporter.log(" No Recipients Details  Displayed As per the invalid name the Applied Filtered");

				}
				
			
		// 	  
			
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 2)
			public void verifyRecipientSearchByPhoneNoMatch() throws InterruptedException {
				zelleSendSelectRecipientTests.filterField().clear();
				zelleSendSelectRecipientTests.filterField().click();
				zelleSendSelectRecipientTests.filterField().sendKeys("0000999999");
				Reporter.log("Email entered in the  Filter");
				Thread.sleep(4000);
				List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

				Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
				Reporter.log(" No Recipients Details  Displayed As per the invalid phone number the Applied Filtered");

			}
			
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 3)
			public void verifyRecipientSearchByUnEnrolledNumber() throws InterruptedException {
				zelleSendSelectRecipientTests.filterField().clear();
				zelleSendSelectRecipientTests.filterField().click();
				zelleSendSelectRecipientTests.filterField().sendKeys(unEnrolledNumber);
				Reporter.log("unEnrolledNumber entered in the  Filter");
				Thread.sleep(4000);
				List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

				Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
				Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the unEnrolled number in the Applied Filtered");

			}
			
			
			//   
	       
			
			
			

				
		
	}
   
	 
	 
	 
	 
	
	 
	 