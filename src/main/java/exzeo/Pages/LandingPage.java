package exzeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
}
