package exzeo.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import exzeo.Configuration.Constants;

public class CreateWorkkardPage {

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@FindBy(id="lnkCreateWorkkard")
	WebElement createWorkkardButton;
	
	@FindBy(id = "urlddl")
	WebElement templateType;

	@FindBy(id = "txtWorkkardNumber")
	WebElement workkardNumber;

	@FindBy(id = "txtareaWorkkardDesc")
	WebElement workkardSummary;

	@FindBy(id = "txtLastName")
	WebElement customerLastName;

	@FindBy(id = "txtFirstName")
	WebElement customerFirstName;

	@FindBy(id = "txtPhone")
	WebElement customerPhone;

	@FindBy(id = "txtAltPhone")
	WebElement customerAlternatePhone;

	@FindBy(id = "txtEmailWorkkard")
	WebElement customerEmailId;

	@FindBy(id = "txtPropertyAddress1")
	WebElement propertyAddress1;

	@FindBy(id = "txtPropertyAddress2")
	WebElement propertyAddress2;

	@FindBy(id = "txtPropertyZip")
	WebElement propertyZipCode;

	@FindBy(id = "chkMailingAddress")
	WebElement mailingAddressCheckBox;

	@FindBy(id = "txtMailingZip")
	WebElement mailingZip;

	@FindBy(id = "txtMailingAddress1")
	WebElement mailingAddress1;

	@FindBy(id = "txtMailingAddress2")
	WebElement mailingAddress2;

	@FindBy(id = "txtPolicyNumber")
	WebElement policyNumber;

	@FindBy(id = "ddPolicyType")
	WebElement policyTypeDropDown;

	@FindBy(id = "txtLossDate")
	WebElement lossDate;

	@FindBy(id = "txtReportedDate")
	WebElement reportedDate;

	@FindBy(id = "ddLossType")
	WebElement lossTypeDropDown;

	@FindBy(css = "input[value=CAT]")
	WebElement workkardTypeCatRadio;

	@FindBy(css = "input[value=Daily]")
	WebElement workkardTypeDialyRadio;

	@FindBy(id = "btnSaveWorkkardPopup")
	WebElement saveButton;

	@FindBy(id = "btnSaveWorkkard")
	WebElement saveAndAddActivity;

	@FindBy(id = "btnCancelWorkkard")
	WebElement cancelLink;
	
	public CreateWorkkardPage(WebDriver driver) {
		
		this.driver=driver;	
		wait= new WebDriverWait(this.driver, Constants.EXPLICT_TIMEOUT);
		// TODO Auto-generated constructor stub		
		waitForJQueryProcessing(driver); 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("txtWorkkardNumber")));
		PageFactory.initElements(driver, this);		
	}
	
	public boolean waitForJQueryProcessing(WebDriver driver) {
		boolean jQcondition = false;
		try{
			
			new WebDriverWait(driver, Constants.EXPLICT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject)
							.executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return window.jQuery != undefined && jQuery.active === 0");
			return jQcondition;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return jQcondition;
	}
	
	


	public boolean isTemplateDisplayed()
	{
		
		return templateType.isDisplayed();
	}
	

	public boolean isWorkkardNumber()
	{
		return workkardNumber.isDisplayed();
	}

	public boolean isWorkkardSummaryDisplayed()
	{
		return workkardSummary.isDisplayed();
	}

	public boolean isWrokkardTypeCATDisplayed()
	{
		return workkardTypeCatRadio.isDisplayed();
	}

	public boolean isWorkkardTypeDailyDisplayed()
	{
		return workkardTypeDialyRadio.isDisplayed();
	}


	public boolean isCustomerFirstNameDisplayed()
	{
		return customerFirstName.isDisplayed();
	}

	public boolean isCustomerLastNameDisplayed()
	{
		return customerLastName.isDisplayed();
	}

	public boolean isCustomerEmailDisplayed()
	{
		return customerEmailId.isDisplayed();
	}
	
	public boolean isCustomerPhoneDisplayed()
	{
		return customerPhone.isDisplayed();
	}

	public boolean isCustomerAlternatePhoneDisplayed()
	{
		return customerAlternatePhone.isDisplayed();
	}

	public void enterPropertyAdress1(String address1)
	{
		propertyAddress1.sendKeys(address1);
	}

	public void enterPropertyAdress2(String address2)
	{
		propertyAddress2.sendKeys(address2);
	}
	
	public void enterPropertyZip(String zipCode)
	{
		propertyZipCode.sendKeys(zipCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action= new Actions(driver);		
		action.sendKeys(propertyZipCode,Keys.TAB);
	}
	


	public void enterPolicyNumber(String pNumber)
	{
		 policyNumber.sendKeys(pNumber);
	}
	
	public void selectPolicyType(String pType)
	{
		Select policyType=new Select(policyTypeDropDown);
		policyType.selectByVisibleText(pType);
	}
	
	public void enterLossDate(HashMap<String, String> workkardDetails)
	{
		Date date = new Date();
		SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy");
		String dateWithFormat=format.format(date);
		workkardDetails.put("LD", dateWithFormat);
		lossDate.sendKeys(dateWithFormat);
	}
	
	public void enterLossType(String lType)
	{
		Select lossType=new Select(lossTypeDropDown);
		lossType.selectByVisibleText(lType);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	
	public void selectClaimTemplate() 
	{
			Select tempType= new Select(templateType);			
			tempType.selectByIndex(1);			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtFirstName")));		
	}
	

	public void enterWorkkardNumber(String wkNo)
	{
		workkardNumber.sendKeys(wkNo);
	}

	public void enterWorkkardSummary(String summary)
	{
		workkardSummary.sendKeys(summary);
	}


	public void enterCustomerFirstName(String firstName)
	{
		 customerFirstName.sendKeys(firstName);
	}

	public void enterCustomerLastName(String lastName)
	{
		customerLastName.sendKeys(lastName);
	}

	public void enterCustomerEmailID(String emailID)
	{
		customerEmailId.sendKeys(emailID);;
	}
	
	public void enterCustomerPhoneNumber(String phoneNumber)
	{
		customerPhone.sendKeys(phoneNumber);
	}

	public void enterAlternatePhoneNumber(String aPNO)
	{
		customerAlternatePhone.sendKeys(aPNO);
	}

	public void enterReportedDate(HashMap<String, String> workkardDetails){
		
		Date date = new Date();
		SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy");
		String dateWithFormat=format.format(date);
		workkardDetails.put("RD",dateWithFormat);
		reportedDate.sendKeys(dateWithFormat);
	}
	
	public void selectLossType(String lType){
		selectLossType(lType);
	}
	
	public boolean isPropertyAddress1Displayed()
	{
		return propertyAddress1.isDisplayed();
	}

	public boolean isPropertyAddress2Displayed()
	{
		return propertyAddress2.isDisplayed();
	}
	
	public boolean isPropertyZipDisplayed()
	{
		return propertyZipCode.isDisplayed();
	}
	
	public boolean isPropertyAddressDisplayed()
	{
		return propertyAddress1.isDisplayed();
	}
	
	public boolean isMailingAdress1Displayed()
	{
		return mailingAddress1.isDisplayed();
	}
	
	public boolean isMailingAdress2Displayed()
	{
		return mailingAddress2.isDisplayed();
	}
	
	public boolean isMailingAdressZipDisplayed()
	{
		return mailingZip.isDisplayed();
	}
	
	public boolean isMailingAdressCheckboxDisplayed()
	{
		return mailingAddressCheckBox.isDisplayed();
	}

	public boolean isPolicyNumberDisplayed()
	{
		return policyNumber.isDisplayed();
	}
	
	public boolean isPolicyTypeDropDownDisplayed()
	{
		return policyTypeDropDown.isDisplayed();
	}
	
	public boolean isLossDateDisplayed()
	{
		return lossDate.isDisplayed();
	}
	
	public boolean isLossTypeDropDownDisplayed()
	{
		return lossTypeDropDown.isDisplayed();
	}
	
	public boolean isSaveButtonDisplayed()
	{
		return saveButton.isDisplayed();
	}
	
	public boolean isSaveAndAddActivityButtonDisplayed()
	{
		return saveAndAddActivity.isDisplayed();
	}
	
	public boolean isCancelLinkDisplayed()
	{
		return cancelLink.isDisplayed();
	}
		
	public WorkkardDetailViewPage createDefaultWorkkard(String workkardNumber){
		
		Reporter.log("Before to enter workard number");
		enterWorkkardNumber(workkardNumber);
		
		Reporter.log("After enter workard number");
		enterWorkkardSummary("This is a default workkard");
		
		clickOnSaveButton();
		return new WorkkardDetailViewPage(driver);
	}
	
	public  WorkkardDetailViewPage  createClaimWorkkard(String workkardNumber,HashMap<String, String> workkardDetails){
		
		enterWorkkardNumber(workkardNumber);
		workkardDetails.put("WNO", workkardNumber);
		enterCustomerFirstName(workkardDetails.get("CFN"));
		enterCustomerLastName(workkardDetails.get("CLN"));
		enterCustomerPhoneNumber(workkardDetails.get("CPN"));
		enterAlternatePhoneNumber(workkardDetails.get("APN"));
		enterCustomerEmailID(workkardDetails.get("CEI"));
		enterPropertyAdress1(workkardDetails.get("PA1"));
		enterPropertyAdress2(workkardDetails.get("PA2"));
		enterPropertyZip(workkardDetails.get("PZIP"));
		enterPolicyNumber(workkardDetails.get("PNO"));
		selectPolicyType(workkardDetails.get("PT"));
		enterLossDate(workkardDetails);
		enterReportedDate(workkardDetails);
		enterLossType(workkardDetails.get("LT"));
		enterWorkkardSummary(workkardDetails.get("WS"));
		clickOnSaveButton();
		return new WorkkardDetailViewPage(driver);
	}
	
}




