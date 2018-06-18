package PageFactory;

import org.openqa.selenium.By;

import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Acountdashboard extends Basedriver
{

	public Acountdashboard(IOSDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By lgoutBtn=By.id("Log Out");
	
	public MobileElement logOutButton()
	{
		MobileElement lgOutBttn=(MobileElement) driver.findElement(lgoutBtn);
		return lgOutBttn;
	}
}
