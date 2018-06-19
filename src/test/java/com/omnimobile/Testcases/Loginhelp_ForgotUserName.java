package com.omnimobile.Testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;

import PageFactory.Login;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;

public class Loginhelp_ForgotUserName extends Apploader {

	private static String phonenum = "0000000000";
	private static String SSN = "0000";
	private static String usernameFound, RecoveryUser;
	
	@Test(groups= {"RegressionTest"}) 
	public void a_Loginhelp() throws InterruptedException 
	{
		
		loginhelp.LgnhelpBtn().click();
		System.out.println("Clicked loginhelp button");	
		loginhelp.Forgotusername().click();
		String subHeader = Loginhelppage.statictxt().getText();
		System.out.println(subHeader);
		AssertJUnit.assertTrue(subHeader.contains("We need to make sure it's really you"));
		Loginhelppage.Phoneoremailverify().sendKeys(phonenum);  
		Loginhelppage.Last4SSN().sendKeys(SSN);
		String helpSSN = Loginhelppage.SSNHelp().getText();
		System.out.println(helpSSN);
		AssertJUnit.assertTrue(helpSSN.contains("No Social Security number? Call 877-202-0043 for help."));
		Boolean Continue = Loginhelppage.Continuebutton().isEnabled();
		
		int phoneLength = Loginhelppage.Phoneoremailverify().getText().length();
		int ssnLength = Loginhelppage.Last4SSN().getText().length();
		System.out.println(ssnLength);
		System.out.println(phoneLength);
		
			if (Continue == true) 
			{
				
				if((phoneLength >=8 && phoneLength <=24) && (ssnLength == 4 ))
				{
					
										
							System.out.println("Data entered is correct");
							Loginhelppage.Continuebutton().click();
							String Validation = Loginhelppage.Accountoptionstext().getText();
							AssertJUnit.assertEquals(Validation,"Which account you want to log in to?");
							System.out.println("Account page opened");
							System.out.println(Validation + "  Account Page sub header verified : Test case Sucess");
							Thread.sleep(3000);
				}
			
			else 
				//if(loginPage.PLError().getText() == "The username or password you entered is incorrect. Do you need help logging in?")
				{
					System.out.println("Data entered is incorrect");
				}
				
			
			}
			
		}
	}
	
	/*@Test(groups= {"RegressionTest"}) 
	public void a_Loginhelp() throws InterruptedException {
		loginhelp.LgnhelpBtn().click();
		System.out.println("Clicked loginhelp button");
		Alert alert = driver.switchTo().alert();
	}
	
	@Test(groups= {"RegressionTest"})
	public void b_ForgotUsername() {
		loginhelp.Forgotusrname().click();
	}
	
	@Test(groups= {"RegressionTest"})
	public void c_txtverify() {
		String Userverifytext = Loginhelppage.statictxt().getText();
		System.out.println(Userverifytext);
		assertTrue(Userverifytext.contains("We need to make sure it's really you"));
		
	}
	
	@Test(groups= {"RegressionTest"})
	public void d_SSN() {
		Loginhelppage.Last4SSN().sendKeys(SSN);
	System.out.println(SSN);
	}
	
	@Test(groups= {"RegressionTest"})
	public void e_Phoneoremail() throws InterruptedException {
		Loginhelppage.Phoneoremailverify().sendKeys(phonenum);
    
    //System.out.println(phoneoremail);
	}
	
	@Test(groups= {"RegressionTest"})
	public void f_noSSN() {
		String noSSN = Loginhelppage.SSNHelp().getText();
		System.out.println(noSSN);
		assertTrue(noSSN.contains("No Social Security number? Call 877-202-0043 for help."));
	}
	@Test(groups= {"RegressionTest"})
	public void g_HelpDesk() {
		String noSSN = Loginhelppage.HelpDesk().getText();
		System.out.println(noSSN);
		assertTrue(noSSN.contains("877-202-0043"));
	}
	
	@Test(groups= {"RegressionTest"})
	public void h_Continue() {
	Boolean Continue = Loginhelppage.Continuebutton().isEnabled();
	if (Continue == false) {
		System.out.println("continue button is not enabled");
		}
	Loginhelppage.Continuebutton().click();
	System.out.println("Account page opened");
	}
	
	@Test(groups= {"RegressionTest"})
	public void i_accountoptions() {
		String accountoptions = Loginhelppage.Accountoptionstext().getText();
		System.out.println(accountoptions);
		assertTrue(accountoptions.contains("Which account you want to log in to?"));
	}
	
	@Test(groups= {"RegressionTest"})
	public void j_PeraonalAccount() {
		Loginhelppage.PersonalAccount().click();
	}
	
	@Test(groups= {"RegressionTest"})
	public void k_BusinessAccount() {
		Loginhelppage.BusinessAccount().click();
	}
	@Test(groups= {"RegressionTest"})
	public void l_Continue() {
		Loginhelppage.CntnueBtn().click();
	}
	@Test(groups= {"RegressionTest"})
	public void m_PersonalID() {
		String FoundText = Loginhelppage.FoundText().getText();
		//assertTrue(FoundText.contains("sample"));
		System.out.println(FoundText);
	}
	
//	@Test(groups= {"RegressionTest"})
//	public void n_usernameselecticon() {
//	    usernameFound = Username.UserIDFound().getText();
//		//assertTrue(usernameFound.contains("sample"));
//		Username.UserIDFound().click();
//		System.out.println(usernameFound);	
//	}
	
	@Test(groups= {"RegressionTest"})
	public void n_Username() throws InterruptedException {
	    usernameFound = Loginhelppage.UserIDFound().getText();
		//assertTrue(usernameFound.contains("sample"));
	    Loginhelppage.UserIDFound().click();
		System.out.println(usernameFound);		
	}
	
	@Test(groups= {"RegressionTest"})
	public void o_UserID() throws InterruptedException {
	    Thread.sleep(3000l);
		RecoveryUser = Loginhelppage.Recoveredusername().getAttribute("value");
		assertTrue(RecoveryUser.equals(usernameFound));
		System.out.println(RecoveryUser);
	}*/

