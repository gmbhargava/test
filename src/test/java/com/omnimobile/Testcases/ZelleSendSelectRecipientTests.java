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
public class ZelleSendSelectRecipientTests extends Apploader {

	 String recipientName;
	String  recipientEmail;
	
	String recipientFirstName;
	String recipientPhoneNumber;
	 String  recipientLastName;
	 String spanishName;
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
	 
   //     OMAV-T1628 (1.0)-Money_Zelle_UI_Send_SelectRecipient_Navigation
	 
	 
	 
	 @Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
		public void verifyZelleSendNavigation() throws InterruptedException {
			
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.zelleSendButton()));
			zelleSendSelectRecipientTests.zelleSendButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.selectRecipientLabel()));
			zelleSendSelectRecipientTests.cancelTokensButton().click();
			Reporter.log(" Clicked on  Cancel button as expected ");
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			
			Assert.assertTrue(zelleSelectRecipient.zelleButton().isDisplayed(), " Dashboard page not displayed");
			Reporter.log("Dashboard screen displayed as expected ");
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.zelleSendButton()));
			zelleSplitMoney.zelleSplitButton().click();

	 }
	
	 
	 
	 
	 
	 
	
	 
	 //   OMAV-T1627 (1.0)-Money_Zelle_UI_Send_SelectRecipient_Header

	 
	 
	@Test  (groups= {"RegressionTest","smokeTest"},priority=0) 
	public void verifyHeader() 
	{
		zelleSendSelectRecipientTests.zelleSendButton().click();
		wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.selectRecipientLabel()));
		zelleSendSelectRecipientTests.selectRecipientLabel().isDisplayed();
		Assert.assertTrue(zelleSendSelectRecipientTests.zelleSendLable().isDisplayed(), "Send Money Header not displayed");
		Reporter.log("Select recipient header dispalyed as expected ");
		
	}
	
	//    OMAV-T1641 (1.0)-Money_Zelle_UI_Send_SelectRecipient_Select
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=1)  
	public void verifyRecipients() 
	{
	
		zelleSendSelectRecipientTests.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();
		Assert.assertTrue((recipients.size()>1), "recipient Details Not Displayed");
		Reporter
		.log("Recipient Details Displayed As Expected");
		

	}
	
	
	
	
	
	
	
	
	
	
//     OMAV-T1625 (1.0)-Money_Zelle_UI_Send_SelectRecipient_AvatarInitials
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
	public void verifyRecipientAvatar() 
	{
		zelleSendSelectRecipientTests.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsAvatars();
		Assert.assertTrue((recipients.size()>1), "recipient Avators Not Displayed");
		Reporter.log("Recipient Avators Displayed As Expected");
		

	}
	
	
	
	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 2)
	public void verifyRecipientAvatarPhoto() {
		zelleSendSelectRecipientTests.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsAvatars();
		Assert.assertTrue((recipients.size() > 1), "recipient Avators Not Displayed");
		Reporter.log("Recipient Avators Displayed As Expected");

	}
	
	
	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 7)
	public void verifyRecipientsPreconditionsMet() {

		zelleSendSelectRecipientTests.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();
		Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
		Reporter.log("Recipient Details Displayed As Expected");

	}
	
	
	
	
	
	
	
	

	@Test  (groups= {"RegressionTest","smokeTest"},priority=3) 
	public void verifyRecipientSearchByName() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientName);
		zelleSendSelectRecipientTests.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=4) 
	public void verifyRecipientSearchByFirstName() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		zelleSendSelectRecipientTests.enterCharsFromKeyboard(this.recipientFirstName);
		Reporter.log("FirstName entered in the  Filter");
		//zelleSelectRecipient.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=5) 
	public void verifyRecipientSearchByLastName() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		//zelleSendSelectRecipientScreen.enterCharsFromKeyboard(this.recipientLastName);
		zelleSendSelectRecipientTests.filterField().sendKeys(this.recipientLastName);
		Reporter.log("Last name entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
	
	
	

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 11)
	public void verifyRecipientSearchBySpanishCharacters() throws InterruptedException {
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		zelleSendSelectRecipientTests.filterField().sendKeys(this.spanishName);
		Reporter.log("Spanish Characters entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

		Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the Spanish characters in the Applied Filtered");

	}
	
	
	

	//  OMAV-T1630 (1.0)-Money_Zelle_UI_Send_SelectRecipient_SearchByEmail
	
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=6) 
	public void verifyRecipientSearchByEmail() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSendSelectRecipientTests.filterField().sendKeys(this.recipientEmail);
		Reporter.log("Email entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		

	}
     
	
	//      OMAV-T1638 (1.0)-Money_Zelle_UI_Send_SelectRecipient_SearchByPhone
	
	@Test  (groups= {"RegressionTest","smokeTest"},priority=7) 
	public void verifyRecipientSearchByPhone() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSendSelectRecipientTests.filterField().sendKeys(this.recipientPhoneNumber);
		Reporter.log("Phone number entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");
		

	}
	
	
       //      OMAV-T1635 (1.0)-Money_Zelle_UI_Send_SelectRecipient_SearchByEmail_SpecialCharacters
	

	@Test  (groups= {"RegressionTest","smokeTest"},priority=8) 
	public void verifyRecipientSpecialCharEmail() throws InterruptedException 
	{
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		//zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSendSelectRecipientTests.filterField().sendKeys(this.specialCharEmail);
		Reporter.log("Special characters Email"+specialCharEmail+" in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients=	zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size()>=1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");
		

	}

	
	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 11)
	public void verifyRecipientSearchByEmailNumber() throws InterruptedException {
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		zelleSendSelectRecipientTests.filterField().sendKeys("123");
		Reporter.log("Email entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the email number in the Applied Filtered");

	}
	
	
	
	
	
	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 9)
	public void verifyRecipientSearchByEmailCasing() throws InterruptedException {
		zelleSendSelectRecipientTests.filterField().clear();
		zelleSendSelectRecipientTests.filterField().click();
		zelleSendSelectRecipientTests.filterField().sendKeys(this.recipientEmail.toUpperCase());
		Reporter.log("Email entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();

		Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the email casing the Applied Filtered");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
 //@Test  (groups= {"RegressionTest","smokeTest"},priority=10)  
//	public void selectRecipient() 
//	{
	
//	List<MobileElement> recipients=	zelleSendSelectRecipientScreen.recipientsDetailsList();
				
//		Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
//		recipients.get(1).click();
//		wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientScreen.emailToken()));
//		zelleSendSelectRecipientScreen.emailTokens().get(0).click();
//		Reporter.log("Recipient selected As Expected");
	
//}
 // }
	
	
	



  //@Test (groups= {"RegressionTest"},priority=12) 
 //	public void verifyBackButton() throws InterruptedException
 //	{
//		zelleSendSelectRecipientScreen.backButton().click();
//		wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientScreen.zelleSendButton()));
//		Assert.assertTrue(zelleSendSelectRecipientScreen.viewTransctionsBtn().isDisplayed(), "Unable to navigate back from Recipient screen");
//		Reporter.log(" User navigated back from Recipient screen as expected ");
//	   System.out.println("User navigated back from Recipient screen as expected");
		

//	}
	
}
