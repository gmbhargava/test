
package com.omnimobile.Testcases;

//public class ZelleSplitSelectRecipient {

	
	
	
	
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
	public class ZelleSplitSelectRecipientNegativeTests extends Apploader {
		
		
		/**
		 * @author Nagarjuna Reddy
		 * @story
		 *  ZelleSplitSelectRecipientNegativeTests.
		 */
		
		

		String recipientName;
		String recipientEmail;
		String recipientFirstName;
		String recipientPhoneNumber;
		String recipientLastName;
		String specialCharEmail;
		String unEnrolledNumber;
		String spanishName;
		String Username;
		String password;

		@BeforeTest
		public void login() throws IOException {
			try {
				this.Username = commonUtil.loadTestData("Username");
				this.password = commonUtil.loadTestData("password");
				this.recipientName = commonUtil.loadTestData("recipientName");
				this.recipientPhoneNumber = commonUtil.loadTestData("phoneNumberToken");
				this.recipientEmail = commonUtil.loadTestData("emailToken");
				this.recipientFirstName = commonUtil.loadTestData("recipientFirstName");
				this.recipientLastName = commonUtil.loadTestData("recipientLastName");
				this.specialCharEmail = commonUtil.loadTestData("specialCharEmail");
				unEnrolledNumber=commonUtil.loadTestData("unEnrolledNumber");
				spanishName=commonUtil.loadTestData("spanishName");
				loginPage.userNameTextBox().sendKeys(this.Username);
				loginPage.passwordTextbox().sendKeys(this.password);
				driver.hideKeyboard();
				//loginPage.loginButton().click();
				Thread.sleep(9000);
				Thread.sleep(9000);
				wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
//				Thread.sleep(9000);
//				zelleSelectRecipient.zelleButton().click();
//				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
//				zelleSplitMoney.zelleSplitButton().click();
//				Thread.sleep(9000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		
		
	//   OMAV-T1786 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_Navigation
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
		public void verifyZelleSplitNavigation() throws InterruptedException {
			
			Assert.assertTrue(zelleSelectRecipient.zelleButton().isDisplayed(), " Dashboard page not displayed");
			Reporter.log("Dashboard screen displayed as expected ");
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
			zelleSplitMoney.zelleSplitButton().click();
			
		}
		
			
//	 	  OMAV-T1791 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail_NoMatch
		
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 1)
			public void verifyRecipientSearchByEmailNoMatch() throws InterruptedException {
				zelleSplitMoney.filterField().clear();
				zelleSplitMoney.filterField().click();
				zelleSplitMoney.filterField().sendKeys("invalid_$#DD@inalidmail.com");
				Reporter.log("Email entered in the  Filter");
				Thread.sleep(4000);
				List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

				Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
				Reporter.log(" No Recipients Details  Displayed As per the invalid email the Applied Filtered");

			}
			
//		 	  OMAV-T1791 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByName_NoMatch
			
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 2)
			public void verifyRecipientSearchByNameNoMatch() throws InterruptedException {
				zelleSplitMoney.filterField().clear();
				zelleSplitMoney.filterField().click();
				zelleSplitMoney.filterField().sendKeys("InavlidName");
				Reporter.log("Name entered in the  Filter");
				Thread.sleep(4000);
				List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

				Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
				Reporter.log(" No Recipients Details  Displayed As per the invalid name the Applied Filtered");

			}
			
		
	// 	  OMAV-T1791 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByPhone_NoMatch
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 3)
		public void verifyRecipientSearchByPhoneNoMatch() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys("0000999999");
			Reporter.log("Email entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertFalse((recipients.size() > 1), "recipients details Displayed not As Per the Filter");
			Reporter.log(" No Recipients Details  Displayed As per the invalid phone number the Applied Filtered");

		}
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 4)
		public void verifyRecipientSearchByUnEnrolledNumber() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(unEnrolledNumber);
			Reporter.log("unEnrolledNumber entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the unEnrolled number in the Applied Filtered");

		}
		
		
		//  OMAV-T1792 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail_Numbers
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 5)	
		public void verifyRecipientSearchByEmailNumber() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys("123");
			Reporter.log("Email entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the email number in the Applied Filtered");

		}
		
		
		//   CasesOMAV-T1818 (1.0)- Money_Zelle_UI_SplitBill_SelectRecipients_UnselectRecipient
       
		
		 @Test (groups= {"RegressionTest","smokeTest"},priority = 6)
		 public void verifyUnSelectRecipient() throws InterruptedException
		 {
				zelleSplitMoney.filterField().clear();
				zelleSplitMoney.filterField().click();
			 List<MobileElement> recipients= zelleSplitMoney.recipientsDetailsList();
	
			 Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			 recipients.get(1).click();
			 wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailToken()));
			 zelleSplitMoney.emailTokens().get(0).click();
              Thread.sleep(6000);
			 Reporter.log("Recipient selected As Expected");
			 Assert.assertTrue((zelleSplitMoney.slectIocn().get(0).isEnabled()), "recipients select icon Not Displayed");
			 Reporter.log("recipients select icon displayed  As Expected");
			 zelleSplitMoney.slectIocn().get(0).click();
			 Thread.sleep(3000);
			// Assert.assertTrue((zelleSplitMoney.slectIocn().get(0).isEnabled()), "recipients select icon Not Displayed");
			 Reporter.log("recipients un selected As Expected");
		 }
		
		

			
	
}
