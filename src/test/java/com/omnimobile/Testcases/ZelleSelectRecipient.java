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
public class ZelleSelectRecipient extends Apploader {

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
		
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=0) 
	public void verifyHeader() 
	{
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		Assert.assertTrue(zelleSelectRecipient.requestLable().isDisplayed(), "Request Money Header not displayed");
		Reporter.log("Select recipient header dispalyed as expected ");
		
	}
	
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=1)  
	public void verifyRecipients() 
	{
	
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
		Assert.assertTrue((recipients.size()>1), "recipient Details Not Displayed");
		Reporter.log("Recipient Details Displayed As Expected");
		

	}
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
	public void verifyRecipientAvatar() 
	{
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsAvatars();
		Assert.assertTrue((recipients.size()>1), "recipient Avators Not Displayed");
		Reporter.log("Recipient Avators Displayed As Expected");
		

	}
	

	@Test  (groups= {"RegressionTest","smokeTest"},priority=3) 
	public void verifyRecipientSearchByName() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		zelleSelectRecipient.enterCharsFromKeyboard("Ji");
		//zelleSelectRecipient.filterField().sendKeys("Ji");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}

	
//	@Test  (groups= {"RegressionTest","smokeTest"},priority=4)  
//	public void verifyRecipientPhoneNumbers() 
//	{
//		zelleSelectRecipient.filterField().sendKeys(recipientPhoneNumber);
//		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
//
//		Assert.assertTrue((recipients.size()>1), "recipients PhoneNumbers Not Displayed");
//		Reporter.log("Recipients PhoneNumbers Displayed As Expected");
//		
//		
//	
//	
//	}
//	
//	
//	@Test  (groups= {"RegressionTest","smokeTest"},priority=5) 
//	public void verifyRecipientEmails() 
//	{
//		zelleSelectRecipient.filterField().sendKeys(recipientEmail);
//		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
//		
//		Assert.assertTrue((recipients.size()>1), "recipients Emails  Not Displayed");
//		Reporter.log("Recipients Emails Displayed As Expected");
//	
//	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=6)  
	public void selectRecipient() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailToken()));
		zelleSelectRecipient.emailToken().click();
		Reporter.log("Recipient selected As Expected");
	}
	
	
	

//	
	
	
//	@Test  (groups= {"RegressionTest","smokeTest"},priority=8)  
//	public void verifyListOfRecipientsSearchByPhone() 
//	{
//		zelleSelectRecipient.filterField().sendKeys(recipientPhoneNumber);
//		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
//	
//		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
//		Reporter.log("Recipients Lists Displayed As Expected");
//	}
	

	@Test (groups= {"RegressionTest"},priority=9) 
	public void verifyBackButton() throws InterruptedException
	{
		zelleSelectRecipient.backButton().click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.viewTransctionsBtn()));
		Assert.assertTrue(zelleSelectRecipient.viewTransctionsBtn().isDisplayed(), "Unable to navigate back from Recipient screen");
		Reporter.log(" User navigated back from Recipient screen as expected ");
	   System.out.println("User navigated back from Recipient screen as expected");
		

	}
	
}
