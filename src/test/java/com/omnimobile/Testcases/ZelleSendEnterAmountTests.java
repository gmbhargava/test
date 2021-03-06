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
public class ZelleSendEnterAmountTests extends Apploader {
	
	/**
	 * @author Nagarjuna Reddy
	 * @story
	 *  ZelleSendEnterAmountTests.
	 */
	
	
	

	 public static String Username;
	 public static String password;
	 public static String amount;
	 public static String reviewBtn;

	 @BeforeTest
		public void login() throws IOException 
		{
			try {
				this.Username=commonUtil.loadTestData("Username");
				this.password=commonUtil.loadTestData("password");	
				this.amount=commonUtil.loadTestData("amount");
				loginPage.userNameTextBox().sendKeys(this.Username);
				loginPage.passwordTextbox().sendKeys(this.password);
				driver.hideKeyboard();
				//loginPage.loginButton().click();
				Thread.sleep(9000);
				Thread.sleep(9000);
				wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
				Thread.sleep(9000);
				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.zelleSendButton()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
			
		}
	 
	 
	 //   OMAV-T1648 (1.0)-Money_Zelle_UI_Send_EnterAmount_Header
	 
	 
	 @Test(groups = { "RegressionTest"},priority=0,alwaysRun=true)
		public void enterAmountVerifyHeader() throws InterruptedException {
		 	
		 	zelleSendSelectRecipientTests.zelleSendButton().click();
		 	Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(zelleSendSelectRecipientTests.selectRecipientLabel()));
			List<MobileElement> recipients = zelleSendSelectRecipientTests.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
		recipients.get(1).click();
			Assert.assertTrue((zelleSendSelectRecipientTests.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
		zelleSelectRecipient.emailTokens().get(0).click();
Thread.sleep(9000);

			Reporter.log("Token selected successfully");
			Reporter.log("Recipient selected As Expected");
			wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
			Assert.assertTrue(this.sendEnterAmountScreen.sendMoneyLable().isDisplayed()," Enter amount header not displayed");
		
			Reporter.log(" Amount header displayed as expected");
		}
	 
	 
	 //   OMAV-T1644 (1.0)-Money_Zelle_UI_Send_EnterAmount_DefaultHintAmount
	 
	 @Test(groups = { "RegressionTest" },priority=1)
		public void verifyDefaultAmountHint() {
		
		 	wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
			String amountHint=sendEnterAmountScreen.enterAmntField().getAttribute("value");
			Assert.assertTrue(amountHint.equalsIgnoreCase("0.00"),"Amount deault hint not displayed");
	
			Reporter.log(" Amount deault hint Displayed as expected");
		}
	 
	 //      OMAV-T1649 (1.0)-Money_Zelle_UI_Send_EnterAmount_Keyboard
	 
	 @Test(groups = { "RegressionTest"},priority=2)
		public void verifyKeyBoard() {
		
		 	wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
		 	sendEnterAmountScreen.enterAmntField().click();
			Assert.assertTrue(sendEnterAmountScreen.keyBoard().isDisplayed(),"Amount keyboard not displayed");
	
			Reporter.log(" Amount keyboard Displayed as expected");
		}
	 
	 
	   //  OMAV-T1647 (1.0)-Money_Zelle_UI_Send_EnterAmount_EnterZero
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=3)
		public void enterAmountAsZero() {
		
			
			wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
			sendEnterAmountScreen.enterAmntField().sendKeys("0.00");
			Reporter.log(" Amount Entered as zero succesfully");
			sendEnterAmountScreen.doneButtn().click();
			Assert.assertTrue(this.sendEnterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("false"),"Review button not disabled");
			Reporter.log(" Rview button disabled for zero amount as expected");
		}

	 
	 
	 
	    //     OMAV-T1646 (1.0)-Money_Zelle_UI_Send_EnterAmount_EnterMinimumAmount
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=4)
		public void enterAmountAsMinimum() {
		
			
			wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
			sendEnterAmountScreen.enterAmntField().sendKeys("0.01");
			Reporter.log(" Amount Entered as zero succesfully");
			sendEnterAmountScreen.doneButtn().click();
			Assert.assertTrue(this.sendEnterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			Reporter.log(" Rview button enabled for minimum amount as expected");
		}
	 
	 
	 
	 
	 
	@Test(groups = { "RegressionTest", "smokeTest" },priority=5)
	public void enterAmount() {
	
		
		wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
		sendEnterAmountScreen.enterAmntField().clear();
		sendEnterAmountScreen.enterAmntField().sendKeys(this.amount);
		sendEnterAmountScreen.doneButtn().click();
		Reporter.log(" Amount Entered succesfully");
		Assert.assertTrue(this.sendEnterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
		Reporter.log(" Rview button enabled for maximum amount as expected");
		
	}
	
	


@Test(groups = { "RegressionTest"},priority=6)
public void verifyBackButton() {

	wait.until(ExpectedConditions.visibilityOf(sendEnterAmountScreen.selectAmountLabel()));
	sendEnterAmountScreen.backButton().click();
	wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
	Assert.assertTrue(zelleSelectRecipient.selectRecipientLabel().isDisplayed()," Select recipients screen not displayed");

	Reporter.log(" Select recipients screen displayed");
}

	 
    
	


}










	



