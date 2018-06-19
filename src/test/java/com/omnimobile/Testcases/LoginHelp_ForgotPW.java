package com.omnimobile.Testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;

public class LoginHelp_ForgotPW extends Apploader
{
	
	private static String Username = "jnyt1dev01";
	private static String phonenum = "0000000000";
	private static String SSN = "0000";
	private static String createPassword = "spring18";
	private static String retypeNewPassword = "spring18";
	
	//Clicking loginhelp button on login screen and entering validation page of Forgot password flow
	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_Validation_HappyPath() throws InterruptedException 
	
	
	{
		loginhelp.LgnhelpBtn().click();
		System.out.println("Clicked loginhelp button");	
		loginhelp.Forgotpassword().click();
		System.out.println("Clicked forgot password button");	
		String forgotPW_validation_subHeader = Loginhelppage.statictxt().getText();
		System.out.println(forgotPW_validation_subHeader);
		AssertJUnit.assertTrue(forgotPW_validation_subHeader.equals("We need to make sure it's really you"));
		Loginhelppage.Username().sendKeys(Username);
		Loginhelppage.Phoneoremailverify().sendKeys(phonenum);  
		Loginhelppage.Last4SSN().sendKeys(SSN);
		String forgotPW_validation_helpSSN = Loginhelppage.SSNHelp().getText();
		System.out.println(forgotPW_validation_helpSSN);
		AssertJUnit.assertTrue(forgotPW_validation_helpSSN.contains("No Social Security number? Call 877-202-0043 for help."));
		Boolean Continue = Loginhelppage.Continuebutton().isEnabled();

		int usernameLength = Loginhelppage.Username().getText().length();
		int phoneLength = Loginhelppage.Phoneoremailverify().getText().length();
		int ssnLength = Loginhelppage.Last4SSN().getText().length();
		System.out.println(ssnLength);
		System.out.println(usernameLength);
		System.out.println(phoneLength);
		
			if (Continue == true) 
			{
				
				if((usernameLength >=7 && usernameLength <=22) && (phoneLength >=8 && phoneLength <=24) && (ssnLength == 4 ))
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
		//	if(loginPage.PLError().getText() == "The username or password you entered is incorrect. Do you need help logging in?")
				{
					System.out.println("Data entered is incorrect");
				}
				
			
			}
			Thread.sleep(2000);
			
		
		
	}
	
/*	
	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_AccountType_HappyPath() 
	
	
	{
		Loginhelppage.PersonalAccount().click();
		
		Loginhelppage.BusinessAccount().click();
		
		Loginhelppage.PersonalAccount().click();

		Loginhelppage.Continuebutton().click();
		
		
	}
	*/
	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_createPassword_HappyPath() throws InterruptedException
	
	{
					
		 
					String forgotPassword_createPassword_header=Loginhelppage.TittleHeader().getText();
					AssertJUnit.assertEquals(forgotPassword_createPassword_header,"Create a new password.");
					System.out.println(forgotPassword_createPassword_header);
				
					String Length=Loginhelppage.lengthCheckLabel().getText();
					System.out.println(Length);
				
					String NumberLabel = Loginhelppage.NumberCheckLabel().getText();
					System.out.println(NumberLabel);
				
					String LetterLabel = Loginhelppage.LetterCheckLabel().getText();
					System.out.println(LetterLabel);
			
					Loginhelppage.NewPasswordField().sendKeys(createPassword);
					String lengthimage = Loginhelppage.lengthCheckImage().getAttribute("enabled");
					String Numberimage = Loginhelppage.numberCheckImage().getAttribute("enabled");
					String letterImage = Loginhelppage.letterCheckImage().getAttribute("enabled");
					
					
					Loginhelppage.ReEnterPasswordField().sendKeys(retypeNewPassword);
					
					Loginhelppage.Savepasswordbutton().click();
					
					
	
	}
}
