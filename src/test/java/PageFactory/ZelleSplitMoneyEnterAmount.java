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

	By nextBtn               =       By.id("Next");
	
	By enterAmountFlowLable  =       By.id("ENTER AMOUNT");
	
	By enteAmntLable         =       By.id("EnterAmountTitle");
		
	By amountField           =       By.id("EnterAmountTextField");
	
	By multiUserAvatarsImg   =       By.id("tickImage");
	
	By multiUserTxt          =       By.id("RecipientName");
	
	By receipientsAvatrs     =       By.name("IndividualAvatarView");
	
	By spiltAmountFields     =       By.name("AmountTextFieldToBeEntered");
	
	By amountKeyBoard        =       By.className("XCUIElementTypeKeyboard");
		
	By doneBtn               =       By.name("Done");
	
	By backBtn               =       By.id("backArrow 1");
	
	By reviewBtn             =       By.id("ReviewAmountButton");
	
	By cancelBtn             =       By.id("CancelButton");
	
	By noChargeTxt           =       By.id("TokenTitle");
	
	By recipientName       	 =       By.name("RecipientNameIndividual");
	
	
	
	

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
		MobileElement requestLabl=(MobileElement) driver.findElement(this.enteAmntLable);
		return requestLabl;
	}
	
	public MobileElement enterAmntField()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(this.amountField);
		return filterFiel;
	}
	
	public MobileElement multiUserAvatar()
	{
		MobileElement img=(MobileElement) driver.findElement(this.multiUserAvatarsImg);
		return img;
	}
	
	
	
	public 	List<MobileElement> splitAmountFileds()
	{
		List<MobileElement> icon=(List<MobileElement>) driver.findElements(this.spiltAmountFields);
		return icon;
	}
	
	
	public 	List<MobileElement> recipientsNames()
	{
		List<MobileElement> names=(List<MobileElement>) driver.findElements(this.recipientName);
		return names;
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
	
	public MobileElement multipleUserTxt()
	{
		MobileElement txt =(MobileElement)driver.findElement(this.multiUserTxt);
		return txt;
	}
	
	public MobileElement reviewButtn()
	{
		MobileElement revwButton =(MobileElement)driver.findElement(this.reviewBtn);
		return revwButton;
	}

	public MobileElement noChargesTxt()
	{
		MobileElement revwButton =(MobileElement)driver.findElement(this.noChargeTxt);
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
   
 


	
	
	
	
	
	
	
	
	
	
	
	

	

