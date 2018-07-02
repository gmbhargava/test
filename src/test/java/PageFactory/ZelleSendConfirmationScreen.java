package PageFactory;

import org.openqa.selenium.By;

import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleSendConfirmationScreen extends Basedriver {

	
	By confirmationFlowLable=By.xpath("//XCUIElementTypeNavigationBar[@name=\"CONFIRMATION\"]");
	
	By sentLable=By.xpath("//XCUIElementTypeStaticText[@name=\"Money Sent\"]");
	
	
	By confirmationIcon=By.id("icon-checkmark");
	
	
	
	By doneBtn =By.id("Done");
	
	By reviewBtn= By.xpath("//XCUIElementTypeButton[@name=\"Review\"]");


	public ZelleSendConfirmationScreen(IOSDriver driver)
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
		MobileElement requestLabl=(MobileElement) driver.findElement(sentLable);
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
	

