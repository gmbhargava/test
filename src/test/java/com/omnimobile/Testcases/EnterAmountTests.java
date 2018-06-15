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
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners({com.omnimobile.listeners.listener.class});
public class EnterAmountTests extends Apploader {

	private static String recipientName = "Kranthi";
	private CharSequence recipientPhoneNumber = "";
	private CharSequence recipientEmail;
	private CharSequence recipientList;

	private static String Username = "asdfghj";
	private static String password = "12345666";

	@BeforeTest
	public void login() {
		try {
			loginPage.userNameTextBox().sendKeys(Username);
			loginPage.passwordTextbox().sendKeys(password);
			driver.hideKeyboard();
			loginPage.loginButton().click();
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(groups = { "RegressionTest", "smokeTest" })
	public void enterAmount() {
//		TouchAction ac = new TouchAction(driver);
//		MobileElement ele = ZelleSelectRecipient.
//		ac.longPress(ele).waitAction().moveTo(0, 88).release().perform();
//		ZelleSelectRecipient.HelpMeIcon().click();	
		List<MobileElement> recipients = zelleSelectRecipient.recipientsDetailsList();
		Assert.assertTrue((recipients.size() > 1), "recipients Lists Not Displayed");
		recipients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(zelleSelectRecipient.emailToken()));
		zelleSelectRecipient.emailToken().click();
		Reporter.log("Recipient selected As Expected");
		zelleSelectRecipient.nextBtn().click();
		wait.until(ExpectedConditions.visibilityOf(enterAmountScreen.selectAmountLabel()));
		enterAmountScreen.enterAmntField().sendKeys("1234.00");
		enterAmountScreen.doneButtn().click();
		Reporter.log(" Amount Entered succesfully");
	}
	}


