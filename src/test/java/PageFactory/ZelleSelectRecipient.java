package PageFactory;

import org.openqa.selenium.By;

import java.util.List;

import org.openqa.grid.selenium.*;



import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ZelleSelectRecipient extends Basedriver {

	By viewTransactions=By.xpath("//XCUIElementTypeButton[@name=\"View Transactions\"]");
	
	By zelleBtn=By.xpath("(//XCUIElementTypeButton[@name='Zelle'])[1]");
	
	By selectFlowLable=By.xpath("//XCUIElementTypeNavigationBar[@name='SELECT RECIPIENT']");
	
	By requestLable=By.xpath("//XCUIElementTypeStaticText[@name=\"Request Money\"]");
	
	By recipientAvatar=By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[1]");
	
	By filterField=By.id("Filter by name, phone, email");
	
	By recipientsTable=By.xpath("//XCUIElementTypeTable");
	
	By recipientDetails=By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell");
	
	By nextBtn =By.id("Next");
	
	By tokenDialogue= By.xpath("//XCUIElementTypeSheet[contains(@name,'How would you like us')]");
	
	By emailToken=By.xpath("//XCUIElementTypeSheet//XCUIElementTypeButton[contains(@name,'@')]");
	
	By backBtn =By.id("Back");
	
	//By pullBar =By.id("pullBarImage");
	
	//By zelle  =By.xpath("//XCUIElementTypeButton[@name=\"Zelle\"]");
	
	

	private By recipientName;

	private By recipientPhoneNumbers;

	private By recipientEmail;

	private By recipientlist;
	
	
	public ZelleSelectRecipient(IOSDriver driver)
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
	
	public MobileElement zelleButton()
	{
		MobileElement zelle=(MobileElement) driver.findElement(zelleBtn);
		return zelle;
	}
	
	//public MobileElement pullBarImage()
	//{
	//	MobileElement pullBarButton=(MobileElement) driver.findElement(pullBar);
     //return pullBarButton;
	//}
	
	public MobileElement selectRecipientLabel()
	{
		MobileElement selectLable=(MobileElement) driver.findElement(selectFlowLable);
		return selectLable;
	}
	
	public MobileElement requestLable()
	{
		MobileElement requestLabl=(MobileElement) driver.findElement(requestLable);
		return requestLabl;
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
	
	
	
	
	

	public List<MobileElement> recipientListselectrecipient (){
		
		List<MobileElement> selectRecipients=(List<MobileElement>)driver.findElements(recipientlist);
		return selectRecipients;
	
	
	}

	
	
    public List<MobileElement> recipientVerifyListofRecipients (){
		
		List<MobileElement> selectRecipients=(List<MobileElement>)driver.findElements(recipientlist);
		return selectRecipients;
	
	
	
	
	
   }
	
    
 public List<MobileElement> recipientListSearchByPhone (){
		
		List<MobileElement> selectRecipients=(List<MobileElement>)driver.findElements(recipientlist);
		return selectRecipients;
    
    
    
	
 }
	
}
	

