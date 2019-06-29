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
import PageFactory.ZelleSplitMoneyRecipient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class ZelleRequestSelectRecipientTests extends Apploader {

	

	/**
	 * @author Nagarjuna Reddy
	 * @story
	 *  ZelleRequestSelectRecipientTests.
	 */
	
	
	String recipientName;
	String recipientEmail;

	String recipientFirstName;
	String recipientPhoneNumber;
	String recipientLastName;
	String specialCharEmail;
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
			spanishName=commonUtil.loadTestData("spanishName");
			loginPage.userNameTextBox().sendKeys(this.Username);
			loginPage.passwordTextbox().sendKeys(this.password);
			driver.hideKeyboard();
			//loginPage.loginButton().click();
			Thread.sleep(9000);
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			Thread.sleep(9000);
			zelleSelectRecipient.zelleButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleRequestButton()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
			

	}
	
	
	
	
 //   OMAV-T1041 (1.0)-Money_Zelle_UI_Request_SelectRecipient_Header
	

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
	public void verifyHeader() throws InterruptedException {
		zelleSelectRecipient.zelleRequestButton().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		Assert.assertTrue(zelleSelectRecipient.requestLable().isDisplayed(), "Request Money Header not displayed");
		Reporter.log("Select recipient header dispalyed as expected ");

	}
	
	
  //   OMAV-T1819 (1.0)-Money_Zelle_UI_Request_SelectRecipient_ManyRecipients

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 1)
	public void verifyRecipients() {

		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
		Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
		Reporter.log("Recipient Details Displayed As Expected");

	}

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 2)
	public void verifyRecipientAvatar() {
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients = zelleSelectRecipient.recipientsAvatars();
		Assert.assertTrue((recipients.size() > 1), "recipient Avators Not Displayed");
		Reporter.log("Recipient Avators Displayed As Expected");

	}
	
//  OMAV-T1044 (1.0)-Money_Zelle_UI_Request_SelectRecipient_AvatarInitials
	
	
	
	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 3)
	public void verifyRecipientAvatarIntials() {
		zelleSelectRecipient.selectRecipientLabel().isDisplayed();
		List<MobileElement> recipients = zelleSelectRecipient.recipientsAvatars();
		String avatarIntials=recipients.get(1).getAttribute("value");
		
		Assert.assertTrue((avatarIntials.length() >= 1), "recipient Avators intials  Not Displayed");
		Reporter.log("Recipient Avators intials "+avatarIntials+" Displayed As Expected");

	}
	
	//   OMAV-T1043 (1.0)-Money_Zelle_UI_Request_SelectRecipient_PreconditionsMet
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 4)
		public void verifyRecipientsPreconditionsMet() {

			zelleSelectRecipient.selectRecipientLabel().isDisplayed();
			List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipient Details Not Displayed");
			Reporter.log("Recipient Details Displayed As Expected");

		}
		

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 5)
	public void verifyRecipientSearchByName() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		// zelleSelectRecipient.enterCharsFromKeyboard(this.recipientName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");
		
		
	}
		
		
	//     OMAV-T1692 (1.0)-Money_Zelle_UI_Request_SelectRecipient_SearchByName_SpanishCharacters
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 6)
		public void verifyRecipientSearchBySpanishCharacters() throws InterruptedException {
			zelleSelectRecipient.filterField().clear();
			zelleSelectRecipient.filterField().click();
			zelleSelectRecipient.filterField().sendKeys(this.spanishName);
			Reporter.log("Spanish Characters entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the Spanish characters in the Applied Filtered");
			

		}
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 7)
		public void verifyRecipientSearchByEmailNumber() throws InterruptedException {
			zelleSelectRecipient.filterField().clear();
			zelleSelectRecipient.filterField().click();
			zelleSelectRecipient.filterField().sendKeys("123");
			Reporter.log("Email entered in the  Filter");
			Thread.sleep(4000);
			List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

			Assert.assertTrue((recipients.size() > 1), "recipients details Not Displayed As Per the Filter");
			Reporter.log("Recipients Details "+recipients.size() +" Displayed As per the email number in the Applied Filtered");

		}
		
		
	
		

	

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 8)
	public void verifyRecipientSearchByFirstName() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		zelleSelectRecipient.enterCharsFromKeyboard(this.recipientFirstName);
		Reporter.log("FirstName entered in the  Filter");
		// zelleSelectRecipient.filterField().sendKeys(this.recipientName);
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");

	}

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 9)
	public void verifyRecipientSearchByLastName() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		// zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientLastName);
		Reporter.log("Last name entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");

	}

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 10)
	public void verifyRecipientSearchByEmail() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		// zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientEmail);
		Reporter.log("Email entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per the Applied Filtered");

	}

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 11)
	public void verifyRecipientSearchByPhone() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		// zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.recipientPhoneNumber);
		Reporter.log("Phone number entered in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");

	}

	@Test(groups = { "RegressionTest", "smokeTest" }, priority = 12)
	public void verifyRecipientSpecialCharEmail() throws InterruptedException {
		zelleSelectRecipient.filterField().clear();
		zelleSelectRecipient.filterField().click();
		// zelleSelectRecipient.enterCharsFromKeyboard(this.recipientLastName);
		zelleSelectRecipient.filterField().sendKeys(this.specialCharEmail);
		Reporter.log("Special characters Email" + specialCharEmail + " in the  Filter");
		Thread.sleep(4000);
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();

		Assert.assertTrue((recipients.size() >= 1), "recipients details Not Displayed As Per the Filter");
		Reporter.log("Recipients Detailed Displayed As Per Phone number in the Applied Filtered");

	}
	
	
	
	
	
	
	

	// @Test (groups= {"RegressionTest","smokeTest"},priority=13)
	// public void selectRecipient()
	// {
	// List<MobileElement> recipients= zelleSelectRecipient.recipientsDetailsList();

	// Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
	// recipients.get(1).click();
	// wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailToken()));
	// zelleSelectRecipient.emailTokens().get(0).click();
	// Reporter.log("Recipient selected As Expected");
	// }

	// @Test (groups= {"RegressionTest","smokeTest"},priority=14)
	// public void verifySelectIcon()
	// {
	// Assert.assertTrue((zelleSelectRecipient.slectIocn().isEnabled()), "recipients
	// select icon Not Displayed");
	// Reporter.log("recipients select displayed As Expected");

	// }

	// @Test (groups= {"RegressionTest"},priority=15)
	// public void verifyBackButton() throws InterruptedException
	// {
	// zelleSelectRecipient.backButton().click();
	// wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.viewTransctionsBtn()));
	// Assert.assertTrue(zelleSelectRecipient.viewTransctionsBtn().isDisplayed(),
	// "Unable to navigate back from Recipient screen");
	// Reporter.log(" User navigated back from Recipient screen as expected ");
	// System.out.println("User navigated back from Recipient screen as expected");

	// }

}
