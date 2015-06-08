package exzeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exzeo.Configuration.Constants;

public class WorkkardDetailViewPage {
	
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	public WorkkardDetailViewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;	
		wait= new WebDriverWait(this.driver, Constants.EXPLICT_TIMEOUT);
		// TODO Auto-generated constructor stub		
		waitForJQueryProcessing(driver);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("workkardId")));		
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
	
	@FindBy(css="span.workkard_number")
	WebElement workkardNumber;
	
	@FindBy(xpath="//label[text()='Policy Type']/following-sibling::em/span")
	WebElement policyType;
	
	@FindBy(xpath="//label[text()='Customer Name']/following-sibling::em")
	WebElement customerName;
	
	@FindBy(xpath="//label[text()='Policy#']/following-sibling::em/span")
	WebElement policyNumber;
	
	@FindBy(xpath="//label[text()='Loss Date']/following-sibling::em")
	WebElement lossDate;
	
	@FindBy(xpath="//label[text()='Loss Type']/following-sibling::em")
	WebElement lossType;
	
	
	@FindBy(xpath="//label[text()='Claim Type']/following-sibling::em")
	WebElement claimType;
	
	@FindBy(xpath="//label[text()='Reported Date']/following-sibling::em")
	WebElement reportedDate;
	
	@FindBy(xpath="//label[text()='Customer Phone']/following-sibling::em")
	WebElement customerPhone;
	
	@FindBy(xpath="//label[text()='Alternate Phone']/following-sibling::em")
	WebElement alternatePhone;

	//-------------------Action Menu----------------------------------
	
	@FindBy(css="#divWorkkardAction span.drop_menu_head")
	WebElement actionIcon;
	
	@FindBy(id="lnkChangeWorkkardSoonsor")
	WebElement changeWorkkardSponsor;
	
	@FindBy(css="div.popup.cc-popup")
	WebElement changeWorkkardSponsorPopUp;
	
	@FindBy(id="drag_img_box")
	WebElement dropImageElement;
	
	@FindBy(css="span[title='testaditya1@yopmail.com']")
	WebElement dragImageElement;
	
	
	@FindBy(id="lnkConfirmSponsor")
	WebElement confirmSponsorButton;
	
	
	public void clickActionMenuAndWaitForMenuDispalay(){
		
		Actions actions= new Actions(driver);
		actions.moveToElement(actionIcon).build().perform();;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lnkChangeWorkkardSoonsor")));
	}
	
	public void clickChangeWorkkardSponsorAndWaitForPopup(){
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", changeWorkkardSponsor);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='testaditya1@yopmail.com']")));
	}
	
	 public void dragAndDropNewSponsor(){
		 
		 Actions actions= new Actions(driver);
		 actions.dragAndDrop(dragImageElement, dropImageElement).build().perform();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lnkConfirmSponsor")));
	 }
	
	public WorkkardDetailViewPage clickCWSConfirmButton(){
		confirmSponsorButton.click();
		return new WorkkardDetailViewPage(driver);
	}
	
	public String getWorkkardNumber() {
		return workkardNumber.getText();
	}

	public String getPolicyType() {
		return policyType.getText();
	}

	public String getCustomerName() {
		return customerName.getText();
	}

	public String getPolicyNumber() {
		return policyNumber.getText();
	}

	public String getLossDate() {
		return lossDate.getText();
	}

	public String getLossType() {
		return lossType.getText();
	}

	public String getClaimType() {
		return claimType.getText();
	}

	public String getReportedDate() {
		return reportedDate.getText();
	}

	public String getCustomerPhone() {
		return customerPhone.getText();
	}

	public String getAlternatePhone() {
		return alternatePhone.getText();
	}

	public String getCustomerEmail() {
		return customerEmail.getText();
	}

	public String getWorkkardSummary() {
		return workkardSummary.getText();
	}

	@FindBy(xpath="//label[text()='Customer Email']/following-sibling::em")
	WebElement customerEmail;
	
	@FindBy(css="div#workkardSummary > p")
	WebElement workkardSummary;
	
	
	
	
}
