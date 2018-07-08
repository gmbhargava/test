package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleSplitMoneyEnterAmount extends Basedriver {

	By nextBtn =By.id("Next");
	By enterAmountFlowLable=By.xpath("//XCUIElementTypeNavigationBar[@name=\"ENTER AMOUNT\"]");
	
	By sendLable=By.id("EnterAmountTitle");
		
	By amountField=By.id("EnterAmountTextField");
	By multiUserAvatarsImg=By.id("Avatar_Multi User");
	By receipientsAvatrs=By.xpath("//XCUIElementTypeStaticText[@name=\"RecipientName\"]/following-sibling::XCUIElementTypeStaticText[1]");
	
	By spiltAmountFields=By.name("AmountTextFieldToBeEntered");
	
	By amountKeyBoard=By.className("XCUIElementTypeKeyboard");
	
	
	
	By doneBtn =By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
	By backBtn=By.id("backArrow 1");
	
	By reviewBtn= By.id("Review");

		private By viewTransctionbtn;
	
	
	public ZelleSplitMoneyEnterAmount(IOSDriver driver)
	{
		super(driver);
	}
	
	
	
	public MobileElement selectAmountLabel()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(enterAmountFlowLable);
		return selectLable;
	}
	
	public MobileElement splitMoneyLable()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(sendLable);
		return requestLabl;
	}
	
	public MobileElement enterAmntField()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(this.amountField);
		return filterFiel;
	}
	
	
	
	public 	List<MobileElement> splitAmountFileds()
	{
		List<MobileElement> icon=(List<MobileElement>) driver.findElements(this.spiltAmountFields);
		return icon;
	}
	
	
	public 	List<MobileElement> splitRecipientsAvtars()
	{
		List<MobileElement> icon=(List<MobileElement>) driver.findElements(this.receipientsAvatrs);
		return icon;
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
	
	public MobileElement nextButtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(this.nextBtn);
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
   
 


	
	
	
	
	
	
	
	
	
	
	
	

	

