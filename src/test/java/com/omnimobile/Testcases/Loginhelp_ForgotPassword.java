/*package com.omnimobile.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;

import PageFactory.Login;

public class Loginhelp_ForgotPassword extends Apploader{

	private static String Username = "userapp01";
	private static String phonenum = "0000000000";
	private static String SSN = "0000";
	private static String createPassword = "spring18";
	private static String retypeNewPassword = "spring18"; 
	
	
	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_Validation_HappyPath() throws InterruptedException {
		//this.login().getClass();
		Thread.sleep(5000);
		loginhelp.LgnhelpBtn().click();
		System.out.println("Clicked loginhelp button");	
		loginhelp.Forgotpassword().click();
		String subHeader = Loginhelppage.statictxt().getText();
		System.out.println(subHeader);
		AssertJUnit.assertTrue(subHeader.contains("We need to make sure it's really you"));
		Loginhelppage.Username().sendKeys(Username);
		Loginhelppage.Phoneoremailverify().sendKeys(phonenum);  
		Loginhelppage.Last4SSN().sendKeys(SSN);
		String helpSSN = Loginhelppage.SSNHelp().getText();
		System.out.println(helpSSN);
		AssertJUnit.assertTrue(helpSSN.contains("No Social Security number? Call 877-202-0043 for help."));
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
			
		}
	
	
	

	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_AccountType_HappyPath() throws InterruptedException{
		
			//this.UnRU_forgotPassword_Validation_HappyPath();
		
			Loginhelppage.PersonalAccount().click();	
			Loginhelppage.BusinessAccount().click();
			Loginhelppage.PersonalAccount().click();
			
			Loginhelppage.CntnueBtn().click();
			String Title=Loginhelppage.TittleHeader().getText();
			AssertJUnit.assertEquals(Title,"Create a new password.");
			System.out.println(Title);
		}

	@Test(groups= {"RegressionTest"})
	public void UnRU_forgotPassword_createPassword_HappyPath() throws InterruptedException{
		
					//this.UnRU_forgotPassword_Validation_HappyPath();
					//this.UnRU_forgotPassword_AccountType_HappyPath();
					String Title=Loginhelppage.TittleHeader().getText();
					AssertJUnit.assertEquals(Title,"Create a new password.");
					System.out.println(Title);
				
					String Length=Loginhelppage.lengthCheckLabel().getText();
					System.out.println(Length);
				
					String NumberLabel = Loginhelppage.NumberCheckLabel().getText();
					System.out.println(NumberLabel);
				
					String LetterLabel = Loginhelppage.LetterCheckLabel().getText();
					System.out.println(LetterLabel);
			
					Loginhelppage.NewPasswordField().sendKeys(createPassword);
					String lengthimage = Loginhelppage.lengthCheckImage().getAttribute("enabled");
					
					if (createPassword.matches("^(?=.*?\\p{Ll})(?=.*?[\\p{L}&&[^\\p{Lu}]])(?=.*?\\d)" + "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$")||createPassword.matches("^(?=.*?\\p{Lu})(?=.*?[\\p{L}&&[^\\p{Ll}]])(?=.*?\\d)" + "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$"))
					{
						if((lengthimage.equals("true")))
						{
						System.out.println("password Contains alphabet, number and special characters");
						}
					}
					else
					{
						System.out.println("password do not Contains alphabet and number");
					}
					
					Loginhelppage.ReEnterPasswordField().sendKeys(retypeNewPassword);
					
					if(createPassword == retypeNewPassword) 
					{
						System.out.println("Passwords match");
						
					}
					else
					{
						System.out.println("Passwords do not match");
					}
			
		if((newPasswordlength >=8 && newPasswordlength<=24))
		{
			String lengthimage = Loginhelppage.lengthCheckImage().getAttribute("enabled");
			AssertJUnit.assertTrue(lengthimage.equals("true"));
			
		}
		
			
		 	String lengthimage = Loginhelppage.lengthCheckImage().getAttribute("enabled");
			AssertJUnit.assertTrue(lengthimage.equals("true"));
		
			String numberImage = Loginhelppage.numberCheckImage().getAttribute("enabled");
			AssertJUnit.assertTrue(numberImage.equals("true"));
		
			String letterImage = Loginhelppage.letterCheckImage().getAttribute("enabled");
			AssertJUnit.assertTrue(letterImage.equals("true"));
	
		
		
	}





	@Test(groups= {"RegressionTest"})
public void RU_forgotPassword_Validation_HappyPath() throws InterruptedException {
	//this.login().getClass();
	Thread.sleep(5000);
	loginhelp.LgnhelpBtn().click();
	System.out.println("Clicked loginhelp button");	
	loginhelp.Forgotpassword().click();
	String subHeader = Loginhelppage.statictxt().getText();
	System.out.println(subHeader);
	AssertJUnit.assertTrue(subHeader.contains("We need to make sure it's really you"));
	//Loginhelppage.Username().sendKeys(Username);
	Loginhelppage.Phoneoremailverify().sendKeys(phonenum);  
	Loginhelppage.Last4SSN().sendKeys(SSN);
	String helpSSN = Loginhelppage.SSNHelp().getText();
	System.out.println(helpSSN);
	AssertJUnit.assertTrue(helpSSN.contains("No Social Security number? Call 877-202-0043 for help."));
	Boolean Continue = Loginhelppage.Continuebutton().isEnabled();
	
	//int usernameLength = Loginhelppage.Username().getText().length();
	int phoneLength = Loginhelppage.Phoneoremailverify().getText().length();
	int ssnLength = Loginhelppage.Last4SSN().getText().length();
	System.out.println(ssnLength);
	//System.out.println(usernameLength);
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
	//	if(loginPage.PLError().getText() == "The username or password you entered is incorrect. Do you need help logging in?")
			{
				System.out.println("Data entered is incorrect");
			}
			
		
		}
		
	}


/*

@Test(groups= {"RegressionTest"})
public void UnRU_forgotPassword_AccountType_HappyPath() throws InterruptedException{
	
		//this.UnRU_forgotPassword_Validation_HappyPath();
	
		Loginhelppage.PersonalAccount().click();	
		Loginhelppage.BusinessAccount().click();
		Loginhelppage.PersonalAccount().click();
		
		Loginhelppage.CntnueBtn().click();
		String Title=Loginhelppage.TittleHeader().getText();
		AssertJUnit.assertEquals(Title,"Create a new password.");
		System.out.println(Title);
	}

@Test(groups= {"RegressionTest"})
public void RU_forgotPassword_createPassword_HappyPath() throws InterruptedException{
	
				//this.UnRU_forgotPassword_Validation_HappyPath();
				//this.UnRU_forgotPassword_AccountType_HappyPath();
				String Title=Loginhelppage.TittleHeader().getText();
				AssertJUnit.assertEquals(Title,"Create a new password.");
				System.out.println(Title);
			
				String Length=Loginhelppage.lengthCheckLabel().getText();
				System.out.println(Length);
			
				String NumberLabel = Loginhelppage.NumberCheckLabel().getText();
				System.out.println(NumberLabel);
			
				String LetterLabel = Loginhelppage.LetterCheckLabel().getText();
				System.out.println(LetterLabel);
		
				Loginhelppage.NewPasswordField().sendKeys(createPassword);
				
				
				String lengthimage = Loginhelppage.lengthCheckImage().getAttribute("enabled");
				AssertJUnit.assertTrue(lengthimage.equals("true"));
				
				String numberImage = Loginhelppage.numberCheckImage().getAttribute("enabled");
				AssertJUnit.assertTrue(numberImage.equals("true"));
				
				String letterImage = Loginhelppage.letterCheckImage().getAttribute("enabled");
				AssertJUnit.assertTrue(letterImage.equals("true"));
		
				if(createPassword.length() >=8)
				{
					
					System.out.println("Password length 8");
					
				}	
				
				if(Loginhelppage.numberCheckImage().isSelected() == true)	
					{
						System.out.println("Radio button is selected if lenght is above 8");
					}
						
				if (createPassword.matches("^(?=.*?\\p{Ll})(?=.*?[\\\\p{L}&&[^\\\\p{Lu}]])(?=.*?[0-9])" ) || createPassword.matches("^(?=.*?\\p{Lu})(?=.*?[\\p{L}&&[^\\p{Ll}]])(?=.*?[0-9])"))
					{	
						System.out.println("Password has alphabet and number");
					
					}		
						
						if(createPassword.matches( "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$"))/*||createPassword.matches("^(?=.*?\\p{Lu})(?=.*?[\\p{L}&&[^\\p{Ll}]])(?=.*?\\d)")) + "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$"))
					{
						
						//if((lengthimage.equals("true")) && (numberImage.equals("true")) && (letterImage.equals("true")))
						
						System.out.println("password Contains alphabet, number and special characters");
					}
				
				else
				{
					System.out.println("password do not Contains alphabet and number");
				}
				
				Loginhelppage.ReEnterPasswordField().sendKeys(retypeNewPassword);
				
				if(createPassword == retypeNewPassword) 
				{
					System.out.println("Passwords match");
					
				}
				else
				{
					System.out.println("Passwords do not match");
				}
	
}


}

*/


/*
	
	 * 						//for special characters
						Pattern regex = Pattern.compile("[$&+,:;=?@#|]");
						Matcher matcher = regex.matcher("123=456");
						if (regex.pattern() == createPassword)
						{
							System.out.println("password Contains special character");
						}

	
	
	
*/