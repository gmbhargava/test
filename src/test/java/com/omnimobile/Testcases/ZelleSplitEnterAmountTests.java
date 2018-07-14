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
public class ZelleSplitEnterAmountTests extends Apploader {

	 public static String Username;
	 public static String password;
	 public static String amount;
	 public static String reviewBtn;

	 @BeforeTest
		public void login() throws IOException 
		{
			try {
				Username=commonUtil.loadTestData("Username");
				password=commonUtil.loadTestData("password");
				amount=commonUtil.loadTestData("amount");
								
				loginPage.userNameTextBox().sendKeys(Username);
				loginPage.passwordTextbox().sendKeys(password);
				driver.hideKeyboard();
				loginPage.loginButton().click();
			
				Thread.sleep(9000);
				wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.zelleButton()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			
		}
		 
	 
	 
//	 OMAV-T1892 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_Navigation
			
			@Test(groups = { "RegressionTest", "smokeTest" }, priority = 0)
			public void verifyZelleSplitNavigation() throws InterruptedException {
				
			
				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
				zelleSplitMoney.zelleSplitButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			}
	
		
			
	 //      OMAV-T1890 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_Header
	 
	 @Test(groups = { "RegressionTest"},priority=1,alwaysRun=true)
		public void enterAmountVerifyHeader() throws InterruptedException {
		 	List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
			
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

			Reporter.log("Token selected successfully");
			zelleSplitMoneyEnterAmount.nextButtn().click();
			
	//	/*	zelleSelectRecipient.emailTokens().get(0).click();

			Reporter.log("Token selected successfully");
			Reporter.log("Recipient selected As Expected");
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			Assert.assertTrue((zelleSplitMoneyEnterAmount.splitMoneyLable().isDisplayed())," Enter amount header not displayed");
		
			Reporter.log(" Amount header displayed as expected");
		}
	 
	 
 //   OMAV-T1886 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_DefaultHintAmount
	 
	 @Test(groups = { "RegressionTest" },priority=2)
		public void verifyDefaultAmountHint() {
		
		 	wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			String amountHint=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value");
			Assert.assertTrue(amountHint.equalsIgnoreCase("0.00"),"Amount deault hint not displayed");
	
			Reporter.log(" Amount deault hint Displayed as expected");
		}
	 
	 
	 
	 
	 
	 
    //   OMAV-T1891 (1.0) -Money_Zelle_UI_SplitBill_EnterAmount_Keyboard
	 
	 @Test(groups = { "RegressionTest"},priority=3)
		public void verifyKeyBoard() {
		
		 	wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
		 	zelleSplitMoneyEnterAmount.enterAmntField().click();
			Assert.assertTrue(zelleSplitMoneyEnterAmount.keyBoard().isDisplayed(),"Amount keyboard not displayed");
	
			Reporter.log(" Amount keyboard Displayed as expected");
		}
	 
	 
   //  OMAV-T1889 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_EnterZero
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=4)
		public void enterAmountAsZero() {
		
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("0.00");
			Reporter.log(" Amount Entered as zero succesfully");
			zelleSplitMoneyEnterAmount.doneButtn().click();
			Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("false"),"Review button not disabled");
			Reporter.log(" Rview button disabled for zero amount as expected");
		}

	 
	 
	 
	   //  OMAV-T1888 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_Minimum_OneRecipient
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=5)
		public void enterAmountAsMinimum() {
		
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("0.01");
			Reporter.log(" Amount Entered as zero succesfully");
			zelleSplitMoneyEnterAmount.doneButtn().click();
			Assert.assertTrue(this.zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			Reporter.log(" Rview button enabled for minimum amount as expected");
		}
	 
	 
	 
	 
	 //       OMAV-T1908 (1.0)- Money_Zelle_UI_SplitBill_EnterAmount_Review
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=6)
		public void verifyReviwButton() {
		
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.doneButtn().click();
			Reporter.log(" Amount Entered succesfully");
			Assert.assertFalse(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button Enabled");
			Reporter.log(" Rview button Disabled as expected");
			
		}
	 
	 
	 
	 //    OMAV-T1887 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_MaximumDigits
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=7)
		public void verifyMaxDigitsAmount() {
		
			
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("123456700");
			zelleSplitMoneyEnterAmount.doneButtn().click();
			Reporter.log(" Amount Entered succesfully");
			Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			Reporter.log(" Rview button enabled for maximum amount as expected");
			
		}
	 
	 
	 
	 
	 
	 
	@Test(groups = { "RegressionTest", "smokeTest" },priority=8)
	public void enterAmount() {
	
		
		wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
		zelleSplitMoneyEnterAmount.enterAmntField().clear();
		zelleSplitMoneyEnterAmount.enterAmntField().sendKeys(amount);
		zelleSplitMoneyEnterAmount.doneButtn().click();
		Reporter.log(" Amount Entered succesfully");
		Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
		Reporter.log(" Rview button enabled for maximum amount as expected");
		
	}
	
	
	
	//    OMAV-T1894 (1.0)-	Money_Zelle_UI_SplitBill_EnterAmount_RecipientDetail_AvatarInitials
	
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 9)
		public void verifyRecipientAvatarIntials() {
			
			
			List<MobileElement> recipients = zelleSplitMoneyEnterAmount.splitRecipientsAvtars();
			String avatarIntials=recipients.get(1).getAttribute("value");
			
			Assert.assertTrue((avatarIntials.length()==2), "recipient Avators intials  Not Displayed");
			Reporter.log("Recipient Avators intials "+avatarIntials+" Displayed As Expected");

		}
		
		//   	OMAV-T1895 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_RecipientDetail_AvatarPhoto
		
		
		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 10)
		public void verifyRecipientAvatarPhoto() {
			
			List<MobileElement> recipients =  zelleSplitMoneyEnterAmount.splitRecipientsAvtars();
			Assert.assertTrue((recipients.size() >= 1), "recipient Avators Not Displayed");
			Reporter.log("Recipient Avators Displayed As Expected");

		}
		
		

     @Test(groups = { "RegressionTest"},priority=11)
     public void verifyBackButton() {

	wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
	zelleSplitMoneyEnterAmount.backButton().click();
	wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
	Assert.assertTrue(zelleSelectRecipient.selectRecipientLabel().isDisplayed()," Select recipients screen not displayed");

	Reporter.log(" Select recipients screen displayed");
}

	 
   
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}

     


















	



