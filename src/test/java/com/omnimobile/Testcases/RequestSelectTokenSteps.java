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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class RequestSelectTokenSteps extends Apploader {

	 String recipientName;
	String  recipientEmail;
	
	String recipientFirstName;
	String recipientPhoneNumber;
	 String  recipientLastName;
	 String specialCharEmail;
	 String Username;
	 String password;

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
			loginPage.userNameTextBox().sendKeys(this.Username);
			loginPage.passwordTextbox().sendKeys(this.password);
			driver.hideKeyboard();
			loginPage.loginButton().click();
		
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleRequestButton()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	 
	
	
	
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=0)  
	public void selectOneRecipient() throws InterruptedException 
	
	{
		zelleSelectRecipient.zelleRequestButton().click();
		Thread.sleep(500);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailTokens().get(0)));
		Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
		Reporter.log("Recipient Emails Details Displayed As Expected");
		
		Assert.assertTrue((zelleSelectRecipient.phoneNumberTokens().size()>=1), "recipient phone numbers details Not Displayed");
		Reporter.log("Recipient phone numbers Details Displayed As Expected");
		
		zelleSelectRecipient.cancelTokensButton().click();
		Reporter.log("Clicked on Cancel Button");
	}
	
	
	

	@Test  (groups= {"RegressionTest","smokeTest"},priority=1)  
	public void verifyTokensOrderDetails() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailTokens().get(0)));
		Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
		Reporter.log("Recipient Emails Details Displayed As Expected");
		
		Assert.assertTrue((zelleSelectRecipient.phoneNumberTokens().size()>=1), "recipient phone numbers details Not Displayed");
		Reporter.log("Recipient phone numbers Details Displayed As Expected");
		
		Assert.assertTrue((zelleSelectRecipient.notEnrolledPhoneNums().size()>=1), "recipient not enrolled phone numbers details Not Displayed");
		Reporter.log("Recipient not enrolled phone numbers Details Displayed As Expected");
		
		
		zelleSelectRecipient.cancelTokensButton().click();
		Reporter.log("Clicked on Cancel Button");
	}
	

	@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
	public void verifyUnEnrolledTokenDetails() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailTokens().get(0)));
		
		Assert.assertTrue((zelleSelectRecipient.notEnrolledPhoneNums().size()>=1), "recipient not enrolled phone numbers details Not Displayed");
		Reporter.log("Recipient un enrolled phone numbers Details Displayed As Expected");
		
		
		zelleSelectRecipient.cancelTokensButton().click();
		Reporter.log("Clicked on Cancel Button");
	}
	
	
	
	
	
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
	public void verifyCancelToken() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailTokens().get(0)));
				
		zelleSelectRecipient.cancelTokensButton().click();
		Reporter.log("Clicked on Cancel Button");
	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=3)  
	public void verifySelectToken() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailTokens().get(0)));
		Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
		Reporter.log("Recipient Emails Details Displayed As Expected");
		
		zelleSelectRecipient.emailTokens().get(0).click();

		Reporter.log("Token selected successfully");
		
		
		
	}
	
}


