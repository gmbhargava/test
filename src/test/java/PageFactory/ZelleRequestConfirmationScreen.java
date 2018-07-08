package PageFactory;

import org.openqa.selenium.By;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleRequestConfirmationScreen extends Basedriver {

	
	By confirmationFlowLable=By.xpath("//XCUIElementTypeNavigationBar[@name='REQUEST SENT']");
	
	By requestLable=By.xpath("//XCUIElementTypeStaticText[@name='Money Requested']");
	
	
	By confirmationIcon=By.id("icon-checkmark");
	
	
	
	By doneBtn =By.id("DoneButton");
	
	By reviewBtn= By.xpath("//XCUIElementTypeButton[@name=\"Review\"]");


	public ZelleRequestConfirmationScreen(IOSDriver driver)
	{
		super(driver);
	}
	
	
	
	public MobileElement confirmFlowLable()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(confirmationFlowLable);
		return selectLable;
	}
	
	public MobileElement requestLable()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(requestLable);
		return requestLabl;
	}
	
	public MobileElement confirmIcon()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(confirmationIcon);
		return filterFiel;
	}
	
	
	
	public MobileElement doneButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.doneBtn);
		
		
		return nextButton;
	}
	
	
    
 
	
}
	

