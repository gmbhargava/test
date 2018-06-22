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
public class ZelleSelectRecipient extends Apploader {

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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	@Test  (groups= {"RegressionTest","smokeTest"},priority=0) 
	public void verifyHeader() 
	{
		zelleSelectRecipient.zelleButton().click();
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
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=4) 
	public void verifyRecipientSearchByFirstName() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		zelleSelectRecipient.enterCharsFromKeyboard(this.recipientFirstName);
		Reporter.log("FirstName entered in the  Filter");
		//zelleSelectRecipient.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=5) 
	public void verifyRecipientSearchByLastName() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientLastName);
		Reporter.log("Last name entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}

	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=6) 
	public void verifyRecipientSearchByEmail() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientEmail);
		Reporter.log("Email entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}

	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=7) 
	public void verifyRecipientSearchByPhone() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientPhoneNumber);
		Reporter.log("Phone number entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");
		

	}

	@Test  (groups= {"RegressionTest","smokeTest"},priority=8) 
	public void verifyRecipientSpecialCharEmail() throws InterruptedException 
	{
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.specialCharEmail);
		Reporter.log("Special characters Email"+specialCharEmail+" in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");
		

	}

	

	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=10)  
	public void selectRecipient() 
	{
		List<MobileElement> recipients=	zelleSelectRecipient.recipientsDetailsList();
				
		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailToken()));
		zelleSelectRecipient.emailTokens().get(0).click();
		Reporter.log("Recipient selected As Expected");
	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=11)  
	public void verifySelectIcon() 
	{
		Assert.assertTrue((zelleSelectRecipient.slectIocn().isEnabled()), "recipients select icon Not Displayed");
		Reporter.log("recipients select displayed As Expected");
	}
	



	@Test (groups= {"RegressionTest"},priority=12) 
	public void verifyBackButton() throws InterruptedException
	{
		zelleSelectRecipient.backButton().click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.viewTransctionsBtn()));
		Assert.assertTrue(zelleSelectRecipient.viewTransctionsBtn().isDisplayed(), "Unable to navigate back from Recipient screen");
		Reporter.log(" User navigated back from Recipient screen as expected ");
	   System.out.println("User navigated back from Recipient screen as expected");
		

	}
	
}
