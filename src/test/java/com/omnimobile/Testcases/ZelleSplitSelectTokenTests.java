package com.omnimobile.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;

//public class ZelleSplitSelectTokenTests {

	
	
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import io.appium.java_client.MobileElement;

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
				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
				zelleSplitMoney.zelleSplitButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
//			
//		//      OMAV-T1825 (1.0)-Money_Zelle_UI_SplitBill_SelectToken_Cancel
//		
			@Test  (groups= {"RegressionTest","smokeTest"},priority=0)  
			public void verifyCancelToken() 
			{
				List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
						
				Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
				recipients.get(1).click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
						
				zelleSplitMoney.cancelTokensButton().click();
				Reporter.log("Clicked on Cancel Button");
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
				String recipientScreen=zelleSplitMoney.selectRecipientLabel().getAttribute("name");
				Assert.assertTrue(recipientScreen.equalsIgnoreCase("SELECT RECIPIENT"), "Unable to see select recipient screen");
				Reporter.log("User navigated back to slect recipients screen after clicking on Cancel button");
				try {
					boolean isTokenSelected=zelleSplitMoney.slectChkIocn().isDisplayed();
					Assert.assertFalse((isTokenSelected), "recipients selected");
					
				}catch(Exception e) {
					Reporter.log("recipients not selected as expected and test passed");
				
				
				}
			
				
				
			
			}

			
			
				
				
		//		Money_Zelle_UI_SplitBill_SelectToken_InvalidToken      	
				
				
				@Test  (groups= {"RegressionTest","smokeTest"},priority=1)  
				public void verifySelectTokenInvalidToken() 
				{
					List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
							
					Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
					recipients.get(1).click();
					
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
					
					Assert.assertFalse((zelleSplitMoney.notEnrolledPhoneNums().get(0).isEnabled()), " Un unrolled not disabled to select ");
					Reporter.log("Recipient un enrolled phone numbers Details disabled to select As Expected");
					
					zelleSplitMoney.notEnrolledPhoneNums().get(0).click();
					Assert.assertTrue((zelleSplitMoney.cancelTokensButton().isDisplayed()), "Invalid Token selected");
					Reporter.log("Invavlid token not selected as expected");
					zelleSplitMoney.cancelTokensButton().click();
					Reporter.log("Clicked on Cancel Button");
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
					try {
						boolean isTokenSelected=zelleSplitMoney.slectChkIocn().isDisplayed();
						Assert.assertFalse((isTokenSelected), "recipients selected");
						
					}catch(Exception e) {
						Reporter.log("recipients not selected as expected and test passed");
					
					
					}
				}
				
				
				
				
				
				
				
				
//		       OMAV-T1827 (1.0)-Money_Zelle_UI_SplitBill_SelectToken_MaxTokens
				
				@Test  (groups= {"RegressionTest","smokeTest"},priority=2)  
				public void verifySelectTokenMaxTokens() 
				{
					List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
							
					Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
					recipients.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
					int emails=zelleSplitMoney.emailTokens().size();
					int phoneNums=zelleSplitMoney.phoneNumberTokens().size();
					int unEnrolledPhoneNums=zelleSplitMoney.notEnrolledPhoneNums().size();
					Assert.assertTrue((emails<=3), "recipient Emails details Not Displayed");
					Reporter.log("Recipient Emails tokens Details Displayed As Expected");
					Assert.assertTrue((phoneNums<=3), " Phone numbers tokens details Not Displayed");
					Reporter.log(phoneNums+" Phone numbers tokens details Displayed As Expected");
					
					Assert.assertTrue(( unEnrolledPhoneNums<=3), "  Un enrolled Phone numbers tokens details Not Displayed");
					Reporter.log( unEnrolledPhoneNums+" Un enrolled Phone numbers tokens details Displayed As Expected");
					
					zelleSplitMoney.cancelTokensButton().click();
			
				}
				
				
				
				
				
				//      OMAV-T1829 (1.0)-Money_Zelle_UI_SplitBill_SelectToken_Select
				
				
			
				@Test  (groups= {"RegressionTest","smokeTest"},priority=5)  
				public void verifySelectToken_select() throws InterruptedException 
				{
					List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
							
					Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
					recipients.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
					Assert.assertTrue((zelleSplitMoney.emailTokens().size()>=1), "recipient Email details Not Displayed");
					Reporter.log("Recipient Emails Details Displayed As Expected");
					
					zelleSplitMoney.emailTokens().get(0).click();

					Reporter.log("Token selected successfully");
					
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
					String recipientScreen=zelleSplitMoney.selectRecipientLabel().getAttribute("name");
					Assert.assertTrue(recipientScreen.equalsIgnoreCase("SELECT RECIPIENT"), "Unable to see select recipient screen");
					
					Assert.assertTrue((zelleSplitMoney.slectIocn().get(0).isEnabled()), "recipient token not selected");
					Reporter.log("recipient email token selected as expected");
					zelleSplitMoney.slectIocn().get(0).click();
					Thread.sleep(4000);
					recipients.get(1).click();
					Thread.sleep(4000);
					zelleSplitMoney.phoneNumberTokens().get(0).click();

					Reporter.log("Token selected successfully");
					
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
					Assert.assertTrue((zelleSplitMoney.slectIocn().get(0).isEnabled()), "recipient phone number token not selected");
					Reporter.log("recipient phone number token selected as expected");
					
					
								
					
				}	
//				
				
				 //       OMAV-T1830 (1.0)-Money_Zelle_UI_SplitBill_SelectToken_TokensOrder
				
				@Test  (groups= {"RegressionTest","smokeTest"},priority=4)  
				public void verifyTokensOrderDetails() 
				{
					String tokenTxt;
					boolean emailOrder=false;
					boolean phoneNumOrder=false;
					int counter=0;
				
					List<MobileElement> recipients=	zelleSplitMoney.recipientsDetailsList();
							
					Assert.assertTrue((recipients.size()>1), "recipients Lists Not Displayed");
					recipients.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.emailTokens().get(0)));
				    List<MobileElement> tokens=zelleSplitMoney.tokensDetails();
				    int numOfTokens=tokens.size();
				    System.out.println("Num of tokes dispalyed "+numOfTokens);
				    
				    int numofEmails=zelleSplitMoney.emailTokens().size();
				    int numOfPhoneNums=zelleSplitMoney.phoneNumberTokens().size();
				
				    for(int i=0;i<numofEmails;i++) {
				    	tokenTxt=tokens.get(i).getAttribute("name");
				    	System.out.println(" Token  displayed "+tokenTxt);
				    	if(tokenTxt.contains("@")) {
				    		emailOrder=true;
				    		
				    	}else {
				    		emailOrder=false;
				    	}
				    	counter=i;
				    	
				    	}
				    Assert.assertTrue(emailOrder, "recipient Email details Not Displayed");
					Reporter.log("Recipient Emails Details Displayed in order As Expected");
					
					for(int j=counter;j<numOfPhoneNums+numofEmails;j++) {
				    	tokenTxt=tokens.get(j).getAttribute("name");
				    	System.out.println(" Token  displayed "+tokenTxt);
				    	if(tokenTxt.contains("(")) {
				    		phoneNumOrder=true;
				    		
				    	}else {
				    		phoneNumOrder=false;
				    	}
				    	counter=j;
				    	
				    	}
				    Assert.assertTrue(phoneNumOrder, "recipient phone numbers details Not Displayed");
					Reporter.log("Recipient phone numbers Details Displayed in order As Expected");
					
				
					zelleSplitMoney.cancelTokensButton().click();
					Reporter.log("Clicked on Cancel Button");
				  }
				    
					
					
					
					
				

				
				
				
				
				
				
	}		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			
			
              
				
		
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			
			
			
