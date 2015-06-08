package exzeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exzeo.Configuration.Constants;

public class InviteCodePage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@FindBy(id="txtInviteCode")
	WebElement inviteCodeTextField;
	
	@FindBy(id="InviteCodeBtn")
	WebElement nextButton;
	
	public InviteCodePage(WebDriver driver) {
		
		this.driver=driver;	
		wait= new WebDriverWait(this.driver, Constants.EXPLICT_TIMEOUT);
		// TODO Auto-generated constructor stub		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("txtInviteCode")));
		PageFactory.initElements(driver, this);		
	}
		
	public void enterInviteCode(String inviteCode){
		inviteCodeTextField.sendKeys(inviteCode);
	}
	
	public void clickOnNextButton(){
		nextButton.click();
		
	}
}
