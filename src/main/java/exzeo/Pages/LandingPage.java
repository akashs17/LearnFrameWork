package exzeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exzeo.Configuration.Constants;

public class LandingPage {

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@FindBy(id="lnkCreateWorkkard")
	WebElement createWorkkardButton;
	
	@FindBy(id = "urlddl")
	WebElement templateType;
	
	
	@FindBy(id="anchChangeLogo")
	WebElement changeLogoLink;
	
	@FindBy(id="organizationLogo")
	WebElement logoImage;
	
	@FindBy(css="div.popup.cc-popup")
	WebElement popupDialogBox;
	
	@FindBy(id="uploadLogo")
	WebElement uploadLogoLink;
	
	@FindBy(id="btnUploadLogoCancel")
	WebElement uploadCancel;
	
	@FindBy(id="logo_loader_upload")
	WebElement logoLoader;
	
	@FindBy(css="#divLogoError > span.spanErrorMsg")
	WebElement errorMessage;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;	
		wait= new WebDriverWait(this.driver, Constants.EXPLICT_TIMEOUT);
		// TODO Auto-generated constructor stub		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("workkardtab")));
		PageFactory.initElements(driver, this);		
	}
		
	public void clickOnCreateWorkkardButton(){
		createWorkkardButton.click();
	}
	
	public void selectClaimTemplate()
	{
		Select tempType= new Select(templateType);
		tempType.selectByValue("Claim Workkard");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtFirstName")));
	}
	
	public void clickOnChangeOrgImage(){
		
		Actions actions= new Actions(driver);
		actions.moveToElement(logoImage).build().perform();
		changeLogoLink.click();
		
	}
	
	public void waitForPopUpDialogBoxDisplay(){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.popup.cc-popup")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnUploadLogoCancel")));
	}
	
	public void clickOnCloseIconOfPopUpAndVerifyNonExistence(){
				
		uploadCancel.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.popup.cc-popup")));
	}
	
	public void UploadImageAndWaitTillLoad(String path){
		
		uploadLogoLink.sendKeys(path);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logo_loader_upload")));
	}
	
	public String getUploadErrorMEssage(){
		return errorMessage.getText();
	}
}
