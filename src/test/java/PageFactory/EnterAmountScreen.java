package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class EnterAmountScreen extends Basedriver {

	
	By enterAmountFlowLable=By.xpath("//XCUIElementTypeNavigationBar[@name=\"ENTER AMOUNT\"]");
	
	By requestLable=By.xpath("//XCUIElementTypeStaticText[@name=\"Request Money\"]");
	
	
	By amountField=By.xpath("//XCUIElementTypeTextField");
	By amountKeyBoard=By.className("XCUIElementTypeKeyboard");
	
	
	
	By doneBtn =By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
	By backBtn=By.id("backArrow 1");
	
	By reviewBtn= By.id("Review");


		private By viewTransctionbtn;
	
	
	public EnterAmountScreen(IOSDriver driver)
	{
		super(driver);
	}
	
	
	
	public MobileElement selectAmountLabel()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(enterAmountFlowLable);
		return selectLable;
	}
	
	public MobileElement requestLable()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(requestLable);
		return requestLabl;
	}
	
	public MobileElement enterAmntField()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(this.amountField);
		return filterFiel;
	}
	
	
	public MobileElement keyBoard()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(this.amountKeyBoard);
		return selectLable;
	}
	
	
	public MobileElement doneButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.doneBtn);
		return nextButton;
	}
	
	public MobileElement reviewButtn()
	{
		MobileElement revwButton =(MobileElement)driver.findElement(this.reviewBtn);
		return revwButton;
	}





    public MobileElement backButton()
    {
    	
	   MobileElement backButon=(MobileElement)driver.findElement(backBtn);
	  return backButon;

    }

    


public MobileElement viewTransctionsBtn()
    {
	
	
	MobileElement viewTrans=(MobileElement)driver.findElement(this.viewTransctionbtn);
	return viewTrans;

    
    }  

}
   
 


	
	
	
	
	
	
	
	
	
	
	
	

	

