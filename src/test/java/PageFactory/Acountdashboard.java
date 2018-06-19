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

	By lgoutBtn=By.xpath("//XCUIElementTypeButton[@name='Log Out']");
	By viewTransactionHIstoryBtn=By.xpath("//XCUIElementTypeButton[@name='View Transactions']");
	By Acount=By.xpath("//XCUIElementTypeStaticText[contains(@name,'AccountLabel')]");
	public MobileElement logOutButton()
	{
		MobileElement lgOutBttn=(MobileElement) driver.findElement(lgoutBtn);
		return lgOutBttn;
	}
	
	public MobileElement Account()
	{
		MobileElement accnt=(MobileElement) driver.findElement(Acount);
		return accnt;
		
	}
	public MobileElement viewTransactionListButton()
	{
		MobileElement transactnBtn=driver.findElement(viewTransactionHIstoryBtn);
		return transactnBtn;
	}
}
