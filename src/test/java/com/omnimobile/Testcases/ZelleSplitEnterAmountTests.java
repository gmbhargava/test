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
import java.text.DecimalFormat;
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
	 public static int numOfSelectedRecipients=2;

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

				zelleSelectRecipient.zelleButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.zelleSplitButton()));
				zelleSplitMoney.zelleSplitButton().click();
				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
				
			}
			
			
			
		}
		 
	
			
	 //      OMAV-T1890 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_Header
	 
	 @Test(groups = { "RegressionTest"},priority=1,alwaysRun=true)
		public void enterAmountVerifyHeader() throws InterruptedException {
			Reporter.log("Token selected successfully");
			Reporter.log("Recipient selected As Expected");
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			String entrAmountHeader=zelleSplitMoneyEnterAmount.selectAmountLabel().getAttribute("name");
			String enterAmountTitle=zelleSplitMoneyEnterAmount.splitMoneyLable().getAttribute("value");
			Assert.assertTrue((entrAmountHeader.equalsIgnoreCase("ENTER AMOUNT"))," Enter amount header not displayed");
			Reporter.log(" Amount header displayed as expected");
			Assert.assertTrue((enterAmountTitle.equalsIgnoreCase("Split"))," Enter amount  title not displayed");
			Reporter.log(" Amount title displayed as expected");
			
			
			
			
			
			
			
			
			
			
	 }
	 
	 
	 
	 
 //   OMAV-T1886 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_DefaultHintAmount
	 
	 @Test(groups = { "RegressionTest" },priority=2)
		public void verifyDefaultAmountHint() {
		
		 	wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			String amountHint=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value");
			Assert.assertTrue(amountHint.equalsIgnoreCase("0.00"),"Amount deault hint not displayed");
	
			Reporter.log(" Amount deault hint Displayed as expected");
		}
	 
//   OMAV-T1887 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_EnterIndividualAmounts_MaximumDigits
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=3)
		public void verifyEnterIndividualAmountsMaxDigits()   {
			boolean amountFlag=false;
			String amountVal;
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			int numOfAmountFileds=zelleSplitMoneyEnterAmount.splitAmountFileds().size();
			if (numOfAmountFileds>0) {
				for(int i=0;i<numOfAmountFileds;i++) {
					
					zelleSplitMoneyEnterAmount.splitAmountFileds().get(i).sendKeys("12345678");
					
					zelleSplitMoneyEnterAmount.doneButtn().click();
					
					amountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(i).getAttribute("value").trim().toString();
					System.out.println(" Recipient amount maximum allowed value is "+amountVal);
					if(amountVal.equalsIgnoreCase("12,345.67")) {
						amountFlag=true;	
						
					}else {
						amountFlag=false;
					}
					
					System.out.println(" Test status is "+amountFlag);
				}
			}

			Assert.assertTrue(amountFlag," Individual amounts allowed more than Max digits");
				
			Reporter.log(" Individual amounts allowed only Max digits as expected");
				
			Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
			
			Reporter.log(" Rview button enabled for maximum amount as expected");
			
			
		}
	 
			
//     OMAV-T1899 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_EnterIndividualAmounts_Minimum
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=4)
		public void verifyEnterIndividualAmountsMinimumDigits() {
			boolean amountFlag=false;
			String recipientAmountVal;
			String totalAmount;
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().click();
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.doneButtn().click();
			int numOfAmountFileds=zelleSplitMoneyEnterAmount.splitAmountFileds().size();
			if (numOfAmountFileds>0) {
				for(int i=0;i<numOfAmountFileds;i++) {
					zelleSplitMoneyEnterAmount.splitAmountFileds().get(i).sendKeys("0.01");
					zelleSplitMoneyEnterAmount.doneButtn().click();
					recipientAmountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(i).getAttribute("value").trim().toString();
					totalAmount=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
					System.out.println(" Recipient amount minimum allowed value is "+recipientAmountVal);
					System.out.println(" Total amount minimum allowed value is "+totalAmount);
					if((recipientAmountVal.equalsIgnoreCase("0.01")) && (totalAmount.equalsIgnoreCase("0.01"))) {
						amountFlag=true;					
					}else {
						amountFlag=false;
					}
					System.out.println(" Test status is "+amountFlag);
					
					zelleSplitMoneyEnterAmount.enterAmntField().click();
					zelleSplitMoneyEnterAmount.enterAmntField().clear();
					zelleSplitMoneyEnterAmount.doneButtn().click();
					
					
				}
			}

			Assert.assertTrue(amountFlag," Individual amounts not allowed minimum digits");
				
			Reporter.log(" Individual amounts allowed minimum digits as expected");
				
		}
	 
	 //OMAV-T1904 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_EnterIndividualAmounts_TotalAmountRecalculation
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=5)
		public void verifyEnterIndividualAmountsTotalAmountRecalculation() {
			boolean userAmountFlag=false;
			boolean recipientAmountFlag=false;
			String recipientAmountVal;
			String userAmountVal;
			String totalAmount;
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().click();
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.doneButtn().click();
			int numOfAmountFileds=zelleSplitMoneyEnterAmount.splitAmountFileds().size();
			if (numOfAmountFileds>0) {
				
					zelleSplitMoneyEnterAmount.splitAmountFileds().get(0).sendKeys("0.01");
					zelleSplitMoneyEnterAmount.doneButtn().click();
					userAmountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(0).getAttribute("value").trim().toString();
					totalAmount=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
					System.out.println(" User amount value is "+userAmountVal);
					System.out.println(" Total amount  value is "+totalAmount);
					if((userAmountVal.equalsIgnoreCase("0.01")) && (totalAmount.equalsIgnoreCase("0.01"))) {
						userAmountFlag=true;					
					}else {
						userAmountFlag=false;
					}
					System.out.println(" Test status is "+userAmountFlag);
					
					Assert.assertTrue(userAmountFlag,"  Total amount not recalucated for user amount");
					
					Reporter.log(" Total amount recalucated for user amount as expected");
					
					zelleSplitMoneyEnterAmount.splitAmountFileds().get(1).sendKeys("0.01");
					zelleSplitMoneyEnterAmount.doneButtn().click();
					recipientAmountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(1).getAttribute("value").trim().toString();
					totalAmount=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
					System.out.println(" Recipient amount allowed value is "+recipientAmountVal);
					System.out.println(" Total amount allowed value is "+totalAmount);
					if((recipientAmountVal.equalsIgnoreCase("0.01")) && (totalAmount.equalsIgnoreCase("0.02"))) {
						recipientAmountFlag=true;					
					}else {
						recipientAmountFlag=false;
					}
					System.out.println(" Test status is "+recipientAmountFlag);
					
				
					
					
				
			}

			Assert.assertTrue(recipientAmountFlag,"Total amount not recalucated for recipient amount");
				
			Reporter.log(" Total amount recalucated for recipient amount as expected");
				
	 }
	 
	 
	 
	 
	 
	  
	 
    // OMAV-T1900 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_EvenDivison
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=6)
		public void verifyEnterAmountEnterTotalAmount_EvenDivison() {
			boolean userAmountFlag=false;
			boolean recipientAmountFlag=false;
			double expTotalAmnt=36.06;
			String recipientAmountVal;
			String userAmountVal;
			String totalAmount;
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().click();
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys(String.valueOf(expTotalAmnt));
			zelleSplitMoneyEnterAmount.doneButtn().click();
			int numOfAmountFileds=zelleSplitMoneyEnterAmount.splitAmountFileds().size();
			double splitAmnt=expTotalAmnt/numOfAmountFileds;
			 DecimalFormat df= new DecimalFormat(".##");
			String individualAmnt=df.format(splitAmnt);
			// String individualAmnt
			System.out.println(" Expected individual amount to be displayed as  "+individualAmnt);
			if (numOfAmountFileds>0) {
				
					userAmountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(0).getAttribute("value").trim().toString();
					
					totalAmount=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
					System.out.println(" Recipient amount minimum allowed value is "+userAmountVal);
					System.out.println(" Total amount minimum allowed value is "+totalAmount);
					if((userAmountVal.equalsIgnoreCase(String.valueOf(individualAmnt))&& (totalAmount.equalsIgnoreCase(String.valueOf(expTotalAmnt))))) {
						userAmountFlag=true;					
					}else {
						userAmountFlag=false;
					}
					System.out.println(" Test status is "+userAmountFlag);
					
					Assert.assertTrue(userAmountFlag,"  User amount not devided as per the Total amount");
					
					Reporter.log(" User amount devided as per the Total amount as expected");
					for(int i=1;i<numOfAmountFileds;i++) {
					recipientAmountVal=zelleSplitMoneyEnterAmount.splitAmountFileds().get(i).getAttribute("value").trim().toString();
					totalAmount=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
					System.out.println(" Recipient amount minimum allowed value is "+recipientAmountVal);
					System.out.println(" Total amount minimum allowed value is "+totalAmount);
					if((recipientAmountVal.equalsIgnoreCase(String.valueOf(individualAmnt)))) {
						recipientAmountFlag=true;					
					}else {
						recipientAmountFlag=false;
					}
					System.out.println(" Test status is "+recipientAmountFlag);
					
					}
					
					
				
			}

			Assert.assertTrue(recipientAmountFlag,"Recipient amount not devided as per total amount entered");
				
			Reporter.log(" Recipient amount not devided as per total amount entered");
				
	 }
	 


	  	 
//  OMAV-T1887 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_MaximumDigits
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=7)
		public void verifyEnterTotalAmount_MaximumDigits() {
			boolean amountFlag=false;
			String amountVal;
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			
			zelleSplitMoneyEnterAmount.enterAmntField().click();
			
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("12345678");
			zelleSplitMoneyEnterAmount.doneButtn().click();
			amountVal=zelleSplitMoneyEnterAmount.enterAmntField().getAttribute("value").trim().toString();
			System.out.println(" Total amount maximum allowed value is "+amountVal);
			if(amountVal.equalsIgnoreCase("12,345.67")) {
					amountFlag=true;					
				}else {
					amountFlag=false;
				}
					
			System.out.println(" Test status is "+amountFlag);
			Assert.assertTrue(amountFlag," Total amount allowed more than Max digits");
			Reporter.log(" Total amount allowed only Max  7 digits as expected");
					
		}
			
	
	
   //  OMAV-T1889 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_EnterZero
	 
	 @Test(groups = { "RegressionTest", "smokeTest" },priority=8)
		public void enterAmountAsZero() {
		
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.enterAmntField().click();
			zelleSplitMoneyEnterAmount.enterAmntField().clear();
			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("0.00");
			Reporter.log(" Amount Entered as zero succesfully");
			zelleSplitMoneyEnterAmount.doneButtn().click();
			Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("false"),"Review button not disabled");
			Reporter.log(" Rview button disabled for zero amount as expected");
		}
	 
	 
	 
	 
	 
	 
	 

	 
    //   OMAV-T1891 (1.0) -Money_Zelle_UI_SplitBill_EnterAmount_Keyboard
	 
		@Test(groups = { "RegressionTest", "smokeTest" },priority=9)
		public void verifyKeyBoard() {
		
		 	wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
		 	zelleSplitMoneyEnterAmount.enterAmntField().click();
			Assert.assertTrue(zelleSplitMoneyEnterAmount.keyBoard().isDisplayed(),"Amount keyboard not displayed");
			Reporter.log(" Amount keyboard Displayed as expected");
			Assert.assertTrue(zelleSplitMoneyEnterAmount.doneButtn().isDisplayed(),"Done button in amoun keyboard not displayed");
			Reporter.log(" Done button in Amount keyboard Displayed as expected");
		}
		
		//OMAV-T1892 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_Navigation
	     @Test(groups = { "RegressionTest"},priority=15)
	    public void verifyEnterAmount_Navigation() {
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
			zelleSplitMoneyEnterAmount.backButton().click();
			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoney.selectRecipientLabel()));
			Assert.assertTrue(zelleSplitMoney.selectRecipientLabel().isDisplayed()," Select recipients screen not displayed");
		
			Reporter.log(" Select recipients screen displayed");
	     }
	     
	     
	     
//	 	//    OMAV-T1894 (1.0)-	Money_Zelle_UI_SplitBill_EnterAmount_RecipientDetail_AvatarInitials
	 	
	 		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 9)
	 		public void verifyRecipientAvatarIntials() {
	 			
	 			boolean intialsFlag=false;
	 			List<MobileElement> recipients = zelleSplitMoneyEnterAmount.splitRecipientsAvtars();
	 			int numOfRecipients=recipients.size();
	 			String avatarIntials;
	 			for(int i=0;i<numOfRecipients;i++) {
	 				avatarIntials=recipients.get(i).getAttribute("value");
	 				System.out.println(" Recipint intials displayed as " +avatarIntials);
	 				if(avatarIntials.length()<=2) {
	 					intialsFlag=true;
	 				}else {
	 					intialsFlag=false;
	 					
	 				}
	 			}
	 			
	 			
	 				 			
	 			Assert.assertTrue((intialsFlag), "recipient Avators intials  Not Displayed");
	 			Reporter.log("Recipient Avators intials Displayed As Expected");
	 
	 		}
	 	
//		 	//    OMAV-T1903 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_RecipientsList
		 	
		 		@Test(groups = { "RegressionTest", "smokeTest" }, priority = 10)
		 		public void verifyEnterAmount_RecipientsList() {
		 			
		 			boolean recipientsFlag=false;
		 			List<MobileElement> recipients = zelleSplitMoneyEnterAmount.splitRecipientsAvtars();
		 			int numOfRecipients=recipients.size();
		 			
		 			String userNoChargesTxt=zelleSplitMoneyEnterAmount.noChargesTxt().getAttribute("value");
		 			Assert.assertTrue((userNoChargesTxt.equalsIgnoreCase("You won't be charged")), " You won't be charged text Not Displayed");
		 			Reporter.log(" You won't be charged text for user Displayed As Expected");
		 			String avatarIntials;
		 			String recipientsNames;
		 			for(int i=0;i<numOfRecipients;i++) {
		 				avatarIntials=recipients.get(i).getAttribute("value");
		 				System.out.println(" Recipint intials displayed as " +avatarIntials);
		 				recipientsNames=zelleSplitMoneyEnterAmount.recipientsNames().get(i).getAttribute("value");
		 				System.out.println(" Recipint name displayed as " +recipientsNames);
		 				if((avatarIntials.length()<=2) && (recipientsNames.length()>2)) {
		 					recipientsFlag=true;
			 				}else {
			 					recipientsFlag=false;
			 				}
		 			}
		 			
		
		 			Assert.assertTrue((recipientsFlag), "recipients name and  intials  Not Displayed");
		 			Reporter.log("recipients name and  intials Displayed As Expected");
		 			
		 
		 		}
		 		  // OMAV-T1896 (1.0) Money_Zelle_UI_SplitBill_EnterAmount_YouAndOhers_MultipleRecipients
		 		 
		 		 @Test(groups = { "RegressionTest", "smokeTest" },priority=11)
		 			public void verifyYouAndOhers_MultipleRecipients() {
		 			
		 				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
		 						
		 				Assert.assertTrue(zelleSplitMoneyEnterAmount.multiUserAvatar().isDisplayed() ,"  multi-person avatar not disabled");
		 				Reporter.log("  multi-person avatar displayed as expected");
		 				String multiusersTxt=zelleSplitMoneyEnterAmount.multipleUserTxt().getAttribute("value");
		 				System.out.println("Multi user text displayed as "+multiusersTxt);
		 				String expTxt="You and "+numOfSelectedRecipients+" others";
		 				Assert.assertTrue(multiusersTxt.equalsIgnoreCase(expTxt)," Multiple text not displayed");
		 				Reporter.log("Multiple user text displayed "+ multiusersTxt+" as expected");
		 			
		 			}
		 		 
//		 		 //       OMAV-T1908 (1.0)- Money_Zelle_UI_SplitBill_EnterAmount_Review
		 		 
		 		 @Test(groups = { "RegressionTest", "smokeTest" },priority=12)
		 			public void verifyReviwButton() {
		 				wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
		 				zelleSplitMoneyEnterAmount.enterAmntField().clear();
		 				zelleSplitMoneyEnterAmount.doneButtn().click();
		 				String reviewTxt=zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("label");
		 				Assert.assertTrue(reviewTxt.equalsIgnoreCase("Review"),"Review text not displayed");
		 				Reporter.log("Review text displayed as expected");
		 				Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("false"),"Review button Enabled");
		 				Reporter.log(" Review Button Disable as we expected");
		 				 				
		 				
		 				
		 			}
		 		 
		 		 
	     
}    
	     
	     
	     
	     
	     
	 	/*     

//	 
//	 

//	 
//	 
//	 
//	   //  OMAV-T1888 (1.0) - Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_Minimum_OneRecipient
//	 
//	 @Test(groups = { "RegressionTest", "smokeTest" },priority=5)
//		public void enterAmountAsMinimum() {
//		
//			
//			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
//			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("0.01");
//			Reporter.log(" Amount Entered as zero successfully");
//			zelleSplitMoneyEnterAmount.doneButtn().click();
//			Assert.assertTrue(this.zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
//			Reporter.log(" Review button enabled for minimum amount as expected");
//		}
//	 
//	 
//	 
//	 
//	 //       OMAV-T1908 (1.0)- Money_Zelle_UI_SplitBill_EnterAmount_Review
//	 
//	 @Test(groups = { "RegressionTest", "smokeTest" },priority=6)
//		public void verifyReviwButton() {
//		
//			
//			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
//			zelleSplitMoneyEnterAmount.enterAmntField().clear();
//			zelleSplitMoneyEnterAmount.doneButtn().click();
//			Reporter.log(" Amount Entered successfully");
//			Assert.assertFalse(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button Enabled");
//			Reporter.log(" Review button Disabled as expected");
//			
//		}
//	 
//	 
//	 
//	 //    OMAV-T1887 (1.0)-Money_Zelle_UI_SplitBill_EnterAmount_EnterTotalAmount_MaximumDigits
//	 
//	 @Test(groups = { "RegressionTest", "smokeTest" },priority=7)
//		public void verifyMaxDigitsAmount() {
//		
//			
//			wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
//			zelleSplitMoneyEnterAmount.enterAmntField().clear();
//			zelleSplitMoneyEnterAmount.enterAmntField().sendKeys("123456700");
//			zelleSplitMoneyEnterAmount.doneButtn().click();
//			Reporter.log(" Amount Entered successfully");
//			Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
//			Reporter.log(" Review button enabled for maximum amount as expected");
//			
//		}
//	 
//	 
//	 
//	 
//	 
//	 
//	@Test(groups = { "RegressionTest", "smokeTest" },priority=8)
//	public void enterAmount() {
//	
//		
//		wait.until(ExpectedConditions.visibilityOf(zelleSplitMoneyEnterAmount.selectAmountLabel()));
//		zelleSplitMoneyEnterAmount.enterAmntField().clear();
//		zelleSplitMoneyEnterAmount.enterAmntField().sendKeys(amount);
//		zelleSplitMoneyEnterAmount.doneButtn().click();
//		Reporter.log(" Amount Entered succesfully");
//		Assert.assertTrue(zelleSplitMoneyEnterAmount.reviewButtn().getAttribute("enabled").equalsIgnoreCase("true"),"Review button disabled");
//		Reporter.log(" Rview button enabled for maximum amount as expected");
//		
//	}
//	
//	
//	

//		
//		

	 
   
	 

}

     
*/

















	



