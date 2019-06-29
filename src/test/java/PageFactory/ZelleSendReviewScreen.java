package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleSendReviewScreen extends Basedriver {
	//IOSDriver driver;
	
	By reviewFlowLable=By.id("REVIEW");
	
	By sendLable=By.id("ReviewAmountHeader");
	
	
	By confirmationIcon=By.id("icon-checkmark");
	
	
	By msgInput=By.id("OptionalMessageTextView");
	By sendBtn =By.id("SendOrRequestMoneyButton");
	
	By reviewBtn= By.xpath("//XCUIElementTypeButton[@name=\"Review\"]");
	By yesBtn=By.xpath("//XCUIElementTypeButton[@name=\"Yes\"]");
	
	By noBtn=By.xpath("//XCUIElementTypeButton[@name=\"NO\"]");


	public ZelleSendReviewScreen(IOSDriver driver)
	{
		super(driver);
	}
	
//	public void swipeDown() {
//		Dimension size = driver.manage().window().getSize();
//		int starty=(int)(size.height*0.5);
//		int endy=(int)(size.height*0.2);
//		int startx=size.width/2;
//		this.driver.swipe(startx,endy,startx,starty,2000);
//
//	}

	
	
	
	public MobileElement reviewFlowLabl()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(reviewFlowLable);
		return selectLable;
	}
	
	public MobileElement sendLabl()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(sendLable);
		return requestLabl;
	}
	
	

	public MobileElement messageInput()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(msgInput);
		return requestLabl;
	}
	
	public MobileElement confirmIcon()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(confirmationIcon);
		return filterFiel;
	}
	
	
	
	public MobileElement sendButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.sendBtn);
		
		
		return nextButton;
	}
	
	public MobileElement yesButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.yesBtn);
		
		
		return nextButton;
	}
	
	public MobileElement noButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.noBtn);
		
		
		return nextButton;
	}
 
	
}
	

