
package com.omnimobile.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;

//public class ZelleSplitSelectRecipient {

	
	
	
	
	import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

	//@Listeners({com.omnimobile.listeners.listener.class});
	public class ZelleSplitSelectRecipientTests extends Apploader {

		String recipientName;
		String recipientEmail;
		String recipientFirstName;
		String recipientPhoneNumber;
		String recipientLastName;
		String specialCharEmail;
		String spanishName;
		String Username;
		String password;
		
		/**
		 * @author Nagarjuna Reddy
		 * @story 
		 *  Zelle Split Confirmation Screen.
		 */
		
		
		
		

		
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
				spanishName=commonUtil.loadTestData("spanishName");
				loginPage.userNameTextBox().sendKeys(this.Username);
				loginPage.passwordTextbox().sendKeys(this.password);
				driver.hideKeyboard();
			//	loginPage.loginButton().click();
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
			
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
			zelleSplitMoney.zelleSplitButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			zelleSplitMoney.cancelSplitScreebButton().click();
			Reporter.log(" Clicked on  Cancel button as expected ");
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			
			Assert.assertTrue(zelleSelectRecipient.zelleButton().isDisplayed(), " Dashboard page not displayed");
			Reporter.log("Dashboard screen displayed as expected ");
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
			zelleSplitMoney.zelleSplitButton().click();
			
		}
		
		//  OMAVT1783(1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_AvatarInitials
//		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 1)
		public void verifyRecipientAvatarIntials() {
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			
			List<MobileElement> recipients = zelleSplitMoney.recipientsAvatars();
			String avatarIntials=recipients.get(1).getAttribute("value");
			
			Assert.assertTrue((avatarIntials.length()==2), "recipient Avators intials  Not Displayed");
			Reporter.log("Recipient Avators intials "+avatarIntials+" Displayed As Expected");

		}
		
		//   OMAVT1784(1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_AvatarPhoto
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 2)
		public void verifyRecipientAvatarPhoto() {
			zelleSplitMoney.selectRecipientLabel().isDisplayed();
			List<MobileElement> recipients = zelleSplitMoney.recipientsAvatars();
			Assert.assertTrue((recipients.size() > 1), "recipient Avators Not Displayed");
			Reporter.log("Recipient Avators Displayed As Expected");

		}
		
		
		// OMAV-T1785 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_Header
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 3)
		public void verifyHeader() throws InterruptedException {
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			zelleSelectRecipient.selectRecipientLabel().isDisplayed();
			Reporter.log("Select recipient header dispalyed as expected ");
			Assert.assertTrue(zelleSplitMoney.zelleSplitLable().isDisplayed(), "Split Money Header not displayed");
			Reporter.log("Split money header dispalyed as expected ");

		}
		
		
		//   OMAV-T1801 (1.0)- Money_Zelle_UI_SplitBill_SelectRecipients_Next_NoRecipientsSelected
		 


		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 5)
		public void verifyNextBtnNoRecipientSelected() throws InterruptedException {
		
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
		
			Assert.assertFalse(zelleSplitMoney.nextBtn().isEnabled()," Next button Enabled when No recipient selected");
			Reporter.log("Next button Disabled when No recipient selected");

		}
		
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 6)
		public void verifyRecipients() {

			zelleSplitMoney.selectRecipientLabel().isDisplayed();
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
			Reporter.log("Recipient Details Displayed As Expected");

		}

	  //     OMAV-T1787 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_PreconditionsMet

		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 7)
		public void verifyRecipientsPreconditionsMet() {

			zelleSplitMoney.selectRecipientLabel().isDisplayed();
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
			Reporter.log("Recipient Details Displayed As Expected");

		}

		// OMAV-T1788 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 8)
		public void verifyRecipientSearchByEmail() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.recipientEmail);
			Reporter.log("Email entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As Per the Applied Filtered");

		}
		
		
	  //  OMAV-T1789 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail_Casing
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 9)
		public void verifyRecipientSearchByEmailCasing() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.recipientEmail.toUpperCase());
			Reporter.log("Email entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the email casing the Applied Filtered");

		}
		
		
	
		//  OMAV-T1792 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail_Numbers
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 11)
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
		
		

		
		
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 12)
		public void verifyRecipientSearchByName() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			
			zelleSplitMoney.filterField().sendKeys(this.recipientName);
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");

		}
		
		
		
		//     Money_Zelle_UI_SplitBill_SelectRecipients_SearchByFirstName

		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 13)
		public void verifyRecipientSearchByFirstName() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.enterCharsFromKeyboard(this.recipientFirstName);
			Reporter.log("FirstName entered in the  Filter");
		
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");

		}
		
		
		
	//      OMAV-T1796 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByName_SpanishCharacters
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 11)
		public void verifyRecipientSearchBySpanishCharacters() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.spanishName);
			Reporter.log("Spanish Characters entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the Spanish characters in the Applied Filtered");

		}
		

		
	//      OMAV-T1794 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByName_LastName
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 14)
		public void verifyRecipientSearchByLastName() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.recipientLastName);
			Reporter.log("Last name entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() >1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As Per the Applied Filtered");

		}

		

	//      OMAV-T1797 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByPhone
		
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 15)
		public void verifyRecipientSearchByPhone() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.recipientPhoneNumber);
			Reporter.log("Phone number entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() >1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As Per Phone number in the Applied Filtered");

		}

		
		
		
	//    OMAV-T1793 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_SearchByEmail_SpecialCharacters
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 16)
		public void verifyRecipientSpecialCharEmail() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.filterField().sendKeys(this.specialCharEmail);
			Reporter.log("Special characters Email" + specialCharEmail + " in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +"Displayed As Per Phone number in the Applied Filtered");		
			

		}
		

		// OMAV-T1810 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_ManyRecipients

		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 20)
		public void verifyManyRecipients() throws InterruptedException {
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.doneButton().click();
			
			 List<MobileElement> recipients= zelleSplitMoney.recipientsDetailsList();
			 
			 Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
			 recipients.get(1).click();
			 wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailToken()));
			 zelleSplitMoney.emailTokens().get(0).click();
              Thread.sleep(6000);
			 Reporter.log("Recipient selected As Expected");
			 recipients.get(2).click();
			 Thread.sleep(6000);
			 wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailToken()));
			 zelleSplitMoney.emailTokens().get(0).click();
			 Thread.sleep(6000);
			 Assert.assertTrue((zelleSplitMoney.slectIocn().size()>1 ), " Many recipients not selected ");
			 Reporter.log("Many recipients selected as expected" );
			 recipients.get(1).click();
			 recipients.get(2).click();
		}

		
		

		// OMAV-T1810 (1.0)-Money_Zelle_UI_SplitBill_SelectRecipients_Scrolling

		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 21)
		public void verifyRecipientsScrolling() throws InterruptedException {
			
			zelleSplitMoney.selectRecipientLabel().isDisplayed();
			zelleSplitMoney.filterField().clear();
			zelleSplitMoney.filterField().click();
			zelleSplitMoney.doneButton().click();
			List<MobileElement> recipients = zelleSplitMoney.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
			Reporter.log("Recipient Details Displayed As Expected");	
			System.out.println("Before Swipe");
			commonUtil.swipeDown();
			System.out.println("After Swipe");
			Thread.sleep(1000);
			List<MobileElement> recipients1 = zelleSplitMoney.recipientsDetailsList();
			Assert.assertTrue((recipients1.size() > 1), "recipient Details Not Displayed after scrolling");
			Reporter.log("Recipient Details Displayed As Expected after scrolling");
		

			
			
			
			
		} 

	
	
	
	
	
	
}  
