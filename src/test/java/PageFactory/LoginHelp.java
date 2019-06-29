package PageFactory;

import org.openqa.selenium.By;
import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginHelp extends Basedriver {
	
	
	By statictxt = By.xpath("//XCUIElementTypeStaticText[@name=\"We need to make sure it's really you\"]");
	
	By usernameField = By.id("username");
	
	By Phoneoremailverify=By.id("phoneOrEmail");
	
	By Last4SSN= By.xpath("//XCUIElementTypeTextField[@name='ssn']");
	
	By SSNHelp = By.xpath("//XCUIElementTypeTextView[@value='No Social Security number? Call 877-202-0043 for help.']");
	
	By HelpDesk = By.id("877-202-0043");
	
	By Continuebutton = By.xpath("//XCUIElementTypeButton[@name=\"continue\"]");
	
	By Accountoptionstext = By.xpath("//XCUIElementTypeStaticText[@name='Which account you want to log in to?']");
	
	By PersonalAccount = By.id("Personal");
		
	By BusinessAccount = By.id("Business");
	
	By CntnueBtn = By.name("SelectAccountContinueButton");
	
	By IDFoundtext = By.id("We found your Personal ID");
	
	//By RightIcon = By.id("UserNameSelectButton");
	
	By UserID = By.id("April18mb013");
	
	By Recoveredusername = By.id("usernameTextField");
	
	By header=By.id("titleHeader");
	
	By Label1=By.id("lengthCheckLabel");
	
	By Label2=By.id("numberCheckLabel");
	
	By Label3=By.id("letterCheckLabel");
	
	By NewPassword =By.id("newPasswordTextField");
	
	By ReEnterPwd=By.id("confirmPasswordTextField");
	
	By LengthCheck = By.id("lengthCheckImage");
	
	By NumberCheck =By.id("numberCheckImage");
	
	By LetterCheck =By.id("letterCheckImage");
	
	By Savepassword = By.id("savePasswordButton");
	
	By backArrow = By.id("backArrow 1");
	
	By backArrow_1 = By.id("item");
	
	
	
	 
	

public LoginHelp(IOSDriver driver)
{
	super(driver);
}


public MobileElement statictxt()
{
	MobileElement txtverify=(MobileElement) driver.findElement(statictxt);
	return txtverify;
}

public MobileElement Username()
{
	MobileElement usrname=(MobileElement) driver.findElement(usernameField);
	return usrname;
}

public MobileElement Phoneoremailverify()
{
	MobileElement verify=(MobileElement) driver.findElement(Phoneoremailverify);
	return verify;
}

public MobileElement Last4SSN()
{
	MobileElement SSN=(MobileElement) driver.findElement(Last4SSN);
	return SSN;
}
public MobileElement SSNHelp()
{
	MobileElement NoSSN=(MobileElement) driver.findElement(SSNHelp);
	return NoSSN;
}
public MobileElement HelpDesk()
{
	MobileElement Calloption=(MobileElement) driver.findElement(HelpDesk);
	return Calloption;
}

public MobileElement Continuebutton()
{
	MobileElement Continue=(MobileElement) driver.findElement(Continuebutton);
	return Continue;
}

public MobileElement Accountoptionstext()
{
	MobileElement accountspage=(MobileElement) driver.findElement(Accountoptionstext);
	return accountspage;
}

public MobileElement PersonalAccount()
{
	MobileElement personal=(MobileElement) driver.findElement(PersonalAccount);
	return personal;
}
public MobileElement BusinessAccount()
{
	MobileElement Business=(MobileElement) driver.findElement(BusinessAccount);
	return Business;
}
public MobileElement CntnueBtn()
{
	MobileElement Cntnu=(MobileElement) driver.findElement(CntnueBtn);
	return Cntnu;
}
public MobileElement FoundText()
{
	MobileElement FoundText=(MobileElement) driver.findElement(IDFoundtext);
	return FoundText;
}

public MobileElement UserIDFound()
{
	MobileElement Username=(MobileElement) driver.findElement(UserID);
	return Username;
}
public MobileElement Recoveredusername()
{
	MobileElement UserID=(MobileElement) driver.findElement(Recoveredusername);
	return UserID;
}
public MobileElement TittleHeader()
{
	MobileElement Tittleheader=(MobileElement) driver.findElement(header);
	return Tittleheader;
}
public MobileElement lengthCheckLabel()
{
	MobileElement Lengthcheck=(MobileElement) driver.findElement(Label1);
	return Lengthcheck;
}
public MobileElement NumberCheckLabel()
{
	MobileElement Numbercheck=(MobileElement) driver.findElement(Label2);
	return Numbercheck;
}
public MobileElement LetterCheckLabel()
{
	MobileElement Lettercheck=(MobileElement) driver.findElement(Label3);
	return Lettercheck;
}
public MobileElement NewPasswordField()
{
	MobileElement Password=(MobileElement) driver.findElement(NewPassword);
	return Password;
}
public MobileElement ReEnterPasswordField()
{
	MobileElement ReEnterPassword=(MobileElement) driver.findElement(ReEnterPwd);
	return ReEnterPassword;
}
public MobileElement lengthCheckImage()
{
	MobileElement lengthImage=(MobileElement) driver.findElement(LengthCheck);
	return lengthImage;
}
public MobileElement numberCheckImage()
{
	MobileElement numberImage=(MobileElement) driver.findElement(NumberCheck);
	return numberImage;
}
public MobileElement letterCheckImage()
{
	MobileElement letterImage=(MobileElement) driver.findElement(LetterCheck);
	return letterImage;
}
public MobileElement Savepasswordbutton()
{
	MobileElement savepwd=(MobileElement) driver.findElement(Savepassword);
	return savepwd;
}


}