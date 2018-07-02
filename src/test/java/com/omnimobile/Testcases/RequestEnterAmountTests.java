
// Scripted By Nagarjuna.

package com.omnimobile.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import io.appium.java_client.MobileElement;

//@Listeners({com.omnimobile.listeners.listener.class});
public class RequestEnterAmountTests extends Apploader {
	 String Username;
	 String password;
	 String amount;
	 String reviewBtn;

	 @BeforeTest
	public void login() throws IOException 
	{
		try {
			Username=commonUtil.loadTestData("Username");
			password=commonUtil.loadTestData("password");
			amount=commonUtil.loadTestData("amount");						
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
	 
	 @Test(groups = { "RegressionTest"},priority=0,alwaysRun=true)
		public void enterAmountVerifyHeader() throws InterruptedException {
		
		 zelleSelectRecipient.zelleRequestButton().click();
			List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
			Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
			recipients.get(1).click();
			Assert.assertTrue((zelleSelectRecipient.emailTokens().size()>=1), "recipient Email details Not Displayed");
			Reporter.log("Recipient Emails Details Displayed As Expected");
			
			zelleSelectRecipient.emailTokens().get(0).click();

			Reporter.log("Token selected successfully");
			Reporter.log("Recipient selected As Expected");
			Thread.sleep(9000);
			///zelleSelectRecipient.nextBtn().click();
			wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
			Assert.assertTrue(this.enterAmountScreen.requestLable().isDisplayed()," Enter amount header not displayed");
		
			Reporter.log(" Amount header displayed as expected");
		}
	 
	 @Test(groups = { "RegressionTest" },priority=1)
		public void verifyDefaultAmountHint() {
		
		 	wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
			String amountHint=enterAmountScreen.enterAmntField().getAttribute("value");
			Assert.assertTrue(amountHint.equalsIgnoreCase("0.00"),"Amount deault hint not displayed");
	
			Reporter.log(" Amount deault hint Displayed as expected");
		}
	 
	 @Test(groups = { "RegressionTest"},priority=2)
		public void verifyKeyBoard() {
		
		 	wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
		 	enterAmountScreen.enterAmntField().click();
			Assert.assertTrue(enterAmountScreen.keyBoard().isDisplayed(),"Amount keyboard not displayed");
	
			Reporter.log(" Amount keyboard Displayed as expected");
		}
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=3)
		public void enterAmountAsZero() {
		
			
			wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
			enterAmountScreen.enterAmntField().sendKeys("0.00");
			Reporter.log(" Amount Entered as zero succesfully");
			enterAmountScreen.doneButtn().click();
			Assert.assertTrue(this.enterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("false"),"Review button not disabled");
			Reporter.log(" Rview button disabled for zero amount as expected");
		}

	 
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=4)
		public void enterAmountAsMinimum() {
		
			
			wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
			enterAmountScreen.enterAmntField().sendKeys("0.01");
			Reporter.log(" Amount Entered as zero succesfully");
			enterAmountScreen.doneButtn().click();
			Assert.assertTrue(this.enterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			Reporter.log(" Rview button enabled for minimum amount as expected");
		}
	 
	@Test(groups = { "RegressionTest", "smokeTest" },priority=5)
	public void enterAmount() {
	
		
		wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
		enterAmountScreen.enterAmntField().clear();
		enterAmountScreen.enterAmntField().sendKeys(this.amount);
		enterAmountScreen.doneButtn().click();
		Reporter.log(" Amount Entered succesfully");
		Assert.assertTrue(this.enterAmountScreen.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
		Reporter.log(" Rview button enabled for maximum amount as expected");
		
	}
	
	


@Test(groups = { "RegressionTest"},priority=6)
public void verifyBackButton() {

	wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
	enterAmountScreen.backButton().click();
	wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.selectRecipientLabel()));
	Assert.assertTrue(zelleSelectRecipient.selectRecipientLabel().isDisplayed()," Select recipients screen not displayed");

	Reporter.log(" Select recipients screen displayed");
}

	/* @Test(groups = { "RegressionTest"},priority=6)
		public void verifyreviewBtn() {
		
		 	wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.reviewButtn()));
		 	enterAmountScreen.enterAmntField().click();
			Assert.assertFalse(this.enterAmountScreen.reviewButtn().isDisplayed(),"Amount review button is displayed");
	
			Reporter.log(" Review button disables for zero amount as expected");
		enterAmountScreen.reviewButtn().click();
		Reporter.log(" Rview button enabled for maximum amount as expected");*/




			 
		 
		 
    
	


}










	



