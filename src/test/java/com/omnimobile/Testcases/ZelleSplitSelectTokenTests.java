package com.omnimobile.Testcases;

//public class ZelleSplitSelectTokenTests {

	
	
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
	public class ZelleSplitSelectTokenTests extends Apploader {

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
				wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		 
			//   OMAV-T1786 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_Navigation
			
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
			public void verifyZelleSplitNavigation() throws InterruptedException {
				
			
				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
				zelleSplitMoney.zelleSplitButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			}
				
		
			@Test  (groups= {"RegressionTest","smokeTest"},priority=1)  
			public void verifyCancelToken() 
			{
				List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
						
				Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
				recipients.get(1).click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
						
				zelleSplitMoney.cancelTokensButton().click();
				Reporter.log("Clicked on Cancel Button");
		
				
			}
			
			@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
			public void verifyUnEnrolledTokenDetails() 
			{
				List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
						
				Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
				recipients.get(1).click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
		
				Assert.assertTrue((zelleSplitMoney.notEnrolledPhoneNums().size()>=1), "recipient not enrolled phone numbers details Not Displayed");
				Reporter.log("Recipient un enrolled phone numbers Details Displayed As Expected");
				
				
				zelleSplitMoney.cancelTokensButton().click();
				Reporter.log("Clicked on Cancel Button");
			}	
		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=3)  
		public void verifySelectTokenInvalidToken() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			
			Assert.assertFalse((zelleSplitMoney.notEnrolledPhoneNums().get(0).isEnabled()), " Un unrolled not disabled to select ");
			Reporter.log("Recipient un enrolled phone numbers Details disabled to select As Expected");
			zelleSplitMoney.cancelTokensButton().click();
			Reporter.log("Clicked on Cancel Button");
		}
		
		
		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=4)  
		public void verifySelectTokenMaxTokens() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			Assert.assertTrue((zelleSplitMoney.emailTokens().size()==3), "recipient Emails details Not Displayed");
			Reporter.log("Recipient Emails tokens Details Displayed As Expected");
			Assert.assertTrue((zelleSplitMoney.phoneNumberTokens().size()==3), " Phone numbers tokens details Not Displayed");
			Reporter.log(" Phone numbers tokens details Displayed As Expected");
			
			zelleSplitMoney.cancelTokensButton().click();
	
		}
		
	
		
	
		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=5)  
		public void verifyTokensOrderDetails() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			Assert.assertTrue((zelleSplitMoney.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
			Assert.assertTrue((zelleSplitMoney.phoneNumberTokens().size()>=1), "recipient phone numbers details Not Displayed");
			Reporter.log("Recipient phone numbers Details Displayed As Expected");
			
			Assert.assertTrue((zelleSplitMoney.notEnrolledPhoneNums().size()>=1), "recipient not enrolled phone numbers details Not Displayed");
			Reporter.log("Recipient not enrolled phone numbers Details Displayed As Expected");
			
			
			zelleSplitMoney.cancelTokensButton().click();
			Reporter.log("Clicked on Cancel Button");
		}
		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=6)  
		public void verifyTokensOrderDetailsWithEmail() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			Assert.assertTrue((zelleSplitMoney.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
			zelleSplitMoney.cancelTokensButton().click();
			Reporter.log("Clicked on Cancel Button");
		}
		
		@Test  (groups= {"RegressionTest","smokeTest"},priority=7)  
		public void verifyTokensOrderDetailsWithPhone() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			
			Assert.assertTrue((zelleSplitMoney.phoneNumberTokens().size()>=1), "recipient phone numbers details Not Displayed");
			Reporter.log("Recipient phone numbers Details Displayed As Expected");
			
			Assert.assertTrue((zelleSplitMoney.notEnrolledPhoneNums().size()>=1), "recipient not enrolled phone numbers details Not Displayed");
			Reporter.log("Recipient not enrolled phone numbers Details Displayed As Expected");
			
			
			zelleSplitMoney.cancelTokensButton().click();
			Reporter.log("Clicked on Cancel Button");
		}
		
		
		//OMAV-T1619 (1.0) Money_Zelle_UI_Send_SelectToken_OneToken
		//OMAV-T1621 (1.0)Money_Zelle_UI_Send_SelectToken_Select
	
		@Test  (groups= {"RegressionTest","smokeTest"},priority=13)  
		public void verifySelectToken() 
		{
			List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
					
			Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
			Assert.assertTrue((zelleSplitMoney.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
			zelleSplitMoney.emailTokens().get(0).click();

			Reporter.log("Token selected successfully");
			
			
			
		}
		
	}

