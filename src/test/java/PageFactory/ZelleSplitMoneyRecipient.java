package PageFactory;

import org.openqa.selenium.By;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleSplitMoneyRecipient extends Basedriver {

	By viewTransactions     =   By.id("GreetingLabel");
			
	
	By zelleSplitBtn        =   By.id("Split");
	

	By selectFlowLable      =   By.id("SELECT RECIPIENT");
	
	By splitLable           =   By.id("SelectRecipientHeader");
	
	By recipientAvatar      =   By.id("SelectRecipientAvatarView");
	
	By filterField          =   By.id("Filter by name, phone, email");
	
	By recipientsTable      =   By.xpath("//XCUIElementTypeTable");
	
	By recipientDetails     =   By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell");
	
	By nextBtn              =   By.id("Next");
	
	By tokenDialogue        =   By.xpath("//XCUIElementTypeSheet");
	
	By tokensList           =   By.xpath("//XCUIElementTypeSheet//XCUIElementTypeOther/XCUIElementTypeButton");
	
	By emailToken           =   By.xpath("//XCUIElementTypeSheet//XCUIElementTypeButton[contains(@name,'@')]");

	By phoneNumbrsToken     =   By.xpath("//XCUIElementTypeOther/XCUIElementTypeButton[contains(@name,'-')]");
	
	By unEnrolledPhoneNumbrs=   By.xpath("//XCUIElementTypeOther/XCUIElementTypeButton[contains(@name,'not enrolled')]");
	
	By cancelTokenBtn       =   By.id("Cancel");
    
	By cancelSplitScreen    =   By.id("CANCEL");
	
	By backBtn              =   By.id("backArrow 1");
	
	By icon_select          =   By.id("SelectRecipientTokenCheckMark");
	
	
	By doneBtn              =   By.id("Done");
			
	
	
	

	private By recipientName;

	private By recipientPhoneNumbers;

	private By recipientEmail;

	
	
	public ZelleSplitMoneyRecipient(IOSDriver driver)
	{
		super(driver);
	}
	
	public boolean enterCharsFromKeyboard(String Vals) {
		char[] chars=Vals.toCharArray();
		int count=chars.length;
		boolean flag=false;
		String val;
		for(int i=0;i<count;i++) {
			val=String.valueOf(Vals.charAt(i));
			
			
			driver.findElement(By.xpath("//XCUIElementTypeKey[@name='"+val+"']")).click();
			flag=true;

		}
		return flag;
		
	}
	
	public MobileElement zelleSplitButton()
	{
		MobileElement zelle=(MobileElement) driver.findElement(zelleSplitBtn);
		return zelle;
	}
	
		
	public MobileElement selectRecipientLabel()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(selectFlowLable);
		return selectLable;
	}
	
	public MobileElement zelleSplitLable()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(splitLable);
		return requestLabl;
	}
	
	public 	List<MobileElement> slectIocn()
	{
		List<MobileElement> icon=(List<MobileElement>) driver.findElements(this.icon_select);
		return icon;
	}
	
	public 	MobileElement slectChkIocn()
	{
		MobileElement icon=(MobileElement) driver.findElement(this.icon_select);
		return icon;
	}
	
	public MobileElement filterField()
	{
		MobileElement filterFiel=(MobileElement) driver.findElement(filterField);
		return filterFiel;
	}
	
	public MobileElement recipientsTable()
	{
		MobileElement recipientsTab=(MobileElement) driver.findElement(recipientsTable);
		return recipientsTab;
	}
	
	public List<MobileElement> recipientsDetailsList()
	{
		List<MobileElement> recipients=(List<MobileElement>) driver.findElements(this.recipientDetails);
		return recipients;
	}
	
	public List<MobileElement> tokensDetails()
	{
		List<MobileElement> tokens=(List<MobileElement>) driver.findElements(tokensList);
		return tokens;
	}
	
	public List<MobileElement> emailTokens()
	{
		List<MobileElement> recipients=(List<MobileElement>) driver.findElements(this.emailToken);
		return recipients;
	}
	
	public List<MobileElement> phoneNumberTokens()
	{
		List<MobileElement> recipients=(List<MobileElement>) driver.findElements(this.phoneNumbrsToken);
		return recipients;
	}
	
	public List<MobileElement> notEnrolledPhoneNums()
	{
		List<MobileElement> recipients=(List<MobileElement>) driver.findElements(this.unEnrolledPhoneNumbrs);
		return recipients;
	}

	public MobileElement nextBtn()
	{
		MobileElement nextButton =(MobileElement)driver.findElement(nextBtn);
		return nextButton;
	}
	
	public MobileElement tokenDialogue()
	{
		MobileElement tokenDia=(MobileElement)driver.findElement(tokenDialogue);
		return tokenDia;
	}
	
	public MobileElement emailToken()
	{
		MobileElement emailTicket=(MobileElement)driver.findElement(emailToken);
		return emailTicket;
	}
	
	public MobileElement backButton() {
		MobileElement backButon=(MobileElement)driver.findElement(backBtn);
		return backButon;
	}
	
	public MobileElement doneButton() {
		MobileElement backButon=(MobileElement)driver.findElement(doneBtn);
		return backButon;
	}
	
	public MobileElement viewTransctionsBtn() {
		MobileElement viewTrans=(MobileElement)driver.findElement(this.viewTransactions);
		return viewTrans;
	}
	
	public List<MobileElement> recipientsAvatars(){
		List<MobileElement> avatars=(List<MobileElement>)driver.findElements(recipientAvatar);
		return avatars;
		
	}
	
	
	public List<MobileElement> recipientNames(){
		List<MobileElement> names=(List<MobileElement>)driver.findElements(recipientName);
		
		return names;
		
	}
	
	
	

	public List<MobileElement> recipientPhoneNumbers(){

		List<MobileElement> numbers=(List<MobileElement>)driver.findElements(recipientPhoneNumbers);
		return numbers;
	
	
	}
	
	

	public List<MobileElement> recipientEmails(){

	
		List<MobileElement> Emails=(List<MobileElement>)driver.findElements(recipientEmail);
		return Emails;
	}
	
	
	
	
	public MobileElement cancelTokensButton(){
		MobileElement btn=(MobileElement)driver.findElement(this.cancelTokenBtn);
		return btn;
		
	}
	
	public MobileElement cancelSplitScreebButton(){
		MobileElement btn=(MobileElement)driver.findElement(this.cancelSplitScreen);
		return btn;
		
	}



	public MobileElement recipientsList()
	{
		MobileElement recipientsBtn=(MobileElement) driver.findElementsByXPath("(//XCUIElementTypeStaticText[@name=\"SelectRecipientName\"])[16]");
		return recipientsBtn;
	}

	
	


}	

