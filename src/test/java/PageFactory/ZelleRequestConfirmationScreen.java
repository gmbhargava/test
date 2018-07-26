package PageFactory;

import org.openqa.selenium.By;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleRequestConfirmationScreen extends Basedriver {

	
	By confirmationFlowLable=By.xpath("//XCUIElementTypeOther[@name=\"CONFIRMATION\"]");
	
	By requestLable=By.id("ConfirmationHeaderTitle");
	
	
	By confirmationIcon=By.id("icon-checkmark");
	
	
	
	By doneBtn =By.id("DoneButton");
	
	By reviewBtn= By.xpath("//XCUIElementTypeButton[@name=\"Review\"]");
	
	By recipentAvatar=By.id("MainAvtatView");
	
	By recipentName=By.id("RecipientName");
	
	By recipentToken=By.id("RecipientToken");
	
	By amountLabl=By.id("EnterAmountLabel");
	
	By confirmationDetails=By.id("RecipientAccountInfoLabel");
	
	By expiryMsg =By.id("ExpiryMessage");
	
	


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
	
	
	public MobileElement expiryMessage()
	{
		MobileElement eMsg=(MobileElement)driver.findElement(this.expiryMsg);
		
		
		return eMsg;
	}
	
	
	public MobileElement doneButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.doneBtn);
		
		
		return nextButton;
	}
	
	
	public MobileElement recipientName()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.recipentName);
		
		
		return nextButton;
	}
	
	public MobileElement recipientAvatar()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.recipentAvatar);
		
		
		return nextButton;
	}
	
	public MobileElement recipientToken()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.recipentToken);
		
		
		return nextButton;
	}
	
	public List<MobileElement> confirmationDetails()
	{
		List<MobileElement> nextButton =(List<MobileElement>)driver.findElements(this.confirmationDetails);
		
		
		return nextButton;
	}
    
	public MobileElement confirmationAmount()
	{
		MobileElement amnt=(MobileElement)driver.findElement(this.amountLabl);
		
		
		return amnt;
	}
	
}
	

