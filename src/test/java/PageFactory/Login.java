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
	
	By lgnBtn=By.xpath("//XCUIElementTypeCell[5]//XCUIElementTypeButton");
	
	By clrtxt=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
	
	By usrNametxtField=By.xpath("//XCUIElementTypeCell[2]/XCUIElementTypeTextField");
	
	By rememberme =By.xpath("//XCUIElementTypeSwitch[@name='Remember me']");
	
	By shwPasswd= By.xpath("//XCUIElementTypeButton[@name='Ic Show']");
	
	By psswdTxtfld=By.xpath("//XCUIElementTypeCell[3]/XCUIElementTypeSecureTextField");
	By goBtn=By.xpath("/XCUIElementTypeButton[@name=\"Go\"]");
	
	
	public Login(IOSDriver driver)
	{
		super(driver);
	}
	
	public MobileElement userNameTextBox()
	{
		MobileElement usrNameTextBox=(MobileElement) driver.findElement(usrName);
		return usrNameTextBox;
	}
	
	
	public MobileElement goButton()
	{
		MobileElement usrNameTextBox=(MobileElement) driver.findElement(goBtn);
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
}
