package com.omnimobile.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;

public class TransactionHistory extends Apploader {

	@Test(priority=0)
	public void viewTransactionsHistory() throws InterruptedException
	{
		
		commonUtil.login();
		Thread.sleep(4000);
		accountDashboardPage.Account().click();
		Thread.sleep(12000);
		transactionHistoryPage.backNavigationButton().click();
		test.log(LogStatus.INFO, "Moving back to Account dashboard");
		accountDashboardPage.logOutButton().click();
		//test.log(LogStatus.INFO, test.);
		
		
	}
	
	@Test(priority=3)
	public void selectSpecificTransaction() throws InterruptedException
	{
		loginPage.userNameTextBox().click();
		 loginPage.clearTexticon().click();

		loginPage.userNameTextBox().click();;
		driver.getKeyboard().sendKeys("jnyt1dev04");
		loginPage.passwordTextbox().click();
		driver.getKeyboard().sendKeys("spring18");
		driver.hideKeyboard();
		loginPage.loginButton().click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "User successfully logged in");
		accountDashboardPage.Account().click();
		test.log(LogStatus.INFO, "Navigating to Transaction History page");
		Thread.sleep(8000);
		transactionHistoryPage.merchantInfo().click();
		for(MobileElement info:transactionHistoryPage.merchantInfos())
		{
			if(info.getAttribute("value").equals("CANCELLED CK RETURN FEE"))
			{
				test.log(LogStatus.INFO, "Found Transaction: \"CANCELLED CK RETURN FEE\" ");
				break;
			}
			else
			{
				System.out.println(info.getAttribute("value"));
				commonUtil.verticalSwipe(0.35, 0.20);
			}
		}
		
		transactionHistoryPage.backNavigationButton().click();
		test.log(LogStatus.INFO, "Navigated back to Account Dashboard");
		accountDashboardPage.logOutButton().click();
		test.log(LogStatus.INFO, "User Logged out from his account");
		
		
	}
	
	@Test(priority=1)
	public void switchBetweenAccounts() throws InterruptedException
	{
		
		loginPage.userNameTextBox().click();
		
		 loginPage.clearTexticon().click();

		loginPage.userNameTextBox().click();
		driver.getKeyboard().sendKeys("jnyt1dev04");
		test.log(LogStatus.INFO, "Username entered in the username textbox");
		loginPage.passwordTextbox().click();
		driver.getKeyboard().sendKeys("spring18");
		driver.hideKeyboard();
		test.log(LogStatus.INFO, "Entered password");
		loginPage.loginButton().click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked on login button");
		accountDashboardPage.Account().click();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Navigating to specific account's transactions History page ");
		
		for(int i=0;i<=1;i++)
		{
		commonUtil.HorizontalSwipe(0.85,0.25,0.20);
		Thread.sleep(11000);
		test.log(LogStatus.INFO, "Navigating to the Account ="+i);
		}
		transactionHistoryPage.backNavigationButton().click();
		test.log(LogStatus.INFO, "Moving back to Account dashboard");
		accountDashboardPage.logOutButton().click();
		test.log(LogStatus.INFO, "Logging Out from the user account");
	}
	@Test (priority=2)
	public void transactionListInitialLoad() throws InterruptedException
	{
		
		loginPage.userNameTextBox().click();
		
		 loginPage.clearTexticon().click();

		loginPage.userNameTextBox().click();
		driver.getKeyboard().sendKeys("jnyt1dev04");
		test.log(LogStatus.INFO, "Username entered in the username textbox");
		loginPage.passwordTextbox().click();
		driver.getKeyboard().sendKeys("spring18");
		driver.hideKeyboard();
		test.log(LogStatus.INFO, "Entered password");
		loginPage.loginButton().click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked on login button");
		accountDashboardPage.Account().click();
		Thread.sleep(8000);
		test.log(LogStatus.INFO, "Navigating to specific account's transactions History page ");
		
		for(int i=0;i<=3;i++)
		{
			commonUtil.verticalSwipe(0.80, 0.20);
		}
		
		transactionHistoryPage.merchantInfo().click();
		test.log(LogStatus.INFO, "Performed click on individual transaction");
		test.log(LogStatus.FAIL, "Transaction detail page is not present");
		commonUtil.verticalSwipe(0.20, 0.40);
		transactionHistoryPage.backNavigationButton().click();
		test.log(LogStatus.INFO, "Moving back to Account dashboard");
		accountDashboardPage.logOutButton().click();
		
		
		
		Assert.fail();
		
		
	}
	
}
