package PageFactory;

import org.openqa.selenium.By;

import com.omnimobile.commonUtilities.commonUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import com.omnimobile.commonUtilities.Basedriver;

public class Login extends Basedriver
{
	
	
	By usrName=By.xpath("//XCUIElementTypeCell[2]");
	
	By password=By.xpath("//XCUIElementTypeCell[3]");
	
	By lgnBtn=By.id("loginButton");
	
	By clrtxt=By.id("Close");
	
	By usrNametxtField=By.id("usernameTextField");
	
	By rememberme =By.id("rememberMeSwitch");
	
	By shwPasswd= By.id("Ic Show");
	
	By psswdTxtfld=By.id("passwordTextField");
	
	By Lgnhelp= By.name("loginHelpButton");
	
	By Forgotusrname = By.id("Forgot username?");
	
	By Forgotpassword = By.id("Forgot password?");
	
	By cncl = By.id("Cancel");
	
	By PLErr = By.xpath("//XCUIElementTypeOther[@name=\"The username or password you entered is incorrect. Do you need help logging in?\"]/XCUIElementTypeButton[2]");
	
	By needHlp = By.id("need help");
	
	
	 
	public Login(IOSDriver driver)
	{
		super(driver);
	}
	
	public MobileElement userNameTextBox()
	{
		MobileElement usrNameTextBox=(MobileElement) driver.findElement(usrName);
		return usrNameTextBox;
	}
	
	public MobileElement userNameTextField()
	{
		MobileElement usrnmeTxtFld=(MobileElement) driver.findElement(usrNametxtField);
		return usrnmeTxtFld;
	}
	
	public MobileElement passwordTextbox()
	{
		MobileElement passwrdTextbox=(MobileElement) driver.findElement(password);
		return passwrdTextbox;
	}
	
	public MobileElement loginButton()
	{
		MobileElement lgnButton=(MobileElement) driver.findElement(lgnBtn);
		return lgnButton;
	}
	
	public MobileElement clearTexticon()
	{
		MobileElement clearTxt=(MobileElement) driver.findElement(clrtxt);
		return clearTxt;
	}

	public MobileElement rememberMeSwitch()
	{
		MobileElement rememberMeswtch=(MobileElement)driver.findElement(rememberme);
		return rememberMeswtch;
	}
	
	public MobileElement showPasswordIcon()
	{
		MobileElement showPasswd=(MobileElement)driver.findElement(shwPasswd);
		return showPasswd;
	}
	
	public MobileElement passwordTextField()
	{
		MobileElement passwordtxtFld=(MobileElement)driver.findElement(psswdTxtfld);
		return passwordtxtFld;
	}
	public MobileElement LgnhelpBtn()
	{
		MobileElement LgnhelpBtn=(MobileElement) driver.findElement(Lgnhelp);
		return LgnhelpBtn;
	}

	public MobileElement Forgotusername()
	{
		MobileElement Forgotuserbtn=(MobileElement) driver.findElement(Forgotusrname);
		return Forgotuserbtn;
	}
	public MobileElement Forgotpassword()
	{
		MobileElement Forgotpswrd=(MobileElement) driver.findElement(Forgotpassword);
		return Forgotpswrd;
	}
	
	public MobileElement cancel()
	{
		MobileElement cancel=(MobileElement) driver.findElement(cncl);
		return cancel;
	}
	
	public MobileElement PageLevelError()
	{
		MobileElement PLError=(MobileElement) driver.findElement(PLErr);
		return PLError;
	}
	
	public MobileElement needHelp()
	{
		MobileElement needHelp=(MobileElement) driver.findElement(needHlp);
		return needHelp;
	}
	
}
