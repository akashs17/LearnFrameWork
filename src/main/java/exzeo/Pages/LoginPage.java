package exzeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exzeo.Configuration.Constants;

public class LoginPage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	public LoginPage(WebDriver driver) {
			
		this.driver=driver;	
		wait= new WebDriverWait(this.driver, Constants.EXPLICT_TIMEOUT);
		// TODO Auto-generated constructor stub		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("login_userName")));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="login_userName")
	WebElement loginUserTextField;
	
	
	@FindBy(id="login_password")
	WebElement passwordTextField;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(partialLinkText="Help")
	WebElement cantAccessLink;
	
	@FindBy(name="loginRemberMe")
	WebElement remembermeCheckbox;
	
	@FindBy(linkText="About")
	WebElement aboutLink;
	
	@FindBy(linkText="Tour")
	WebElement tourLink;
	
	
	@FindBy(linkText="Demo")
	WebElement demoLink;
	
	
	@FindBy(linkText="Careers")
	WebElement careersLink;
	
	@FindBy(id="errLoginMsg")
	WebElement loginErrorMessage;
	
	@FindBy(id="errusername")
	WebElement usernameErrorMessage;
	
	
	@FindBy(id="errpassword")
	WebElement passwordErrorMessage;
	
	@FindBy(id="errLoginMsg")
	WebElement unSuccessErrorMessage;

	
	 /////////////////////////////////////////////////////////////
	
	//Signup Elements	
	@FindBy(id="txtEmail")
	WebElement emailIDTextField;
	
	
	@FindBy(id="txtFirstName")
	WebElement firstNameTextField;
	
	@FindBy(id="txtLastName")
	WebElement lastNameTextField;
	
	@FindBy(id="btnSignup")
	WebElement signUpButton;
	
	@FindBy(id="errEmail")
	WebElement emailError;
	
	@FindBy(id="errFName")
	WebElement firstNameError;
	
	@FindBy(id="errLName")
	WebElement lastNameError;

	
	
	// Below the login methods 
	
	public LoginPage enterUserName(String username){
		
		loginUserTextField.sendKeys(username);
		return this;
	}
	
	public LoginPage enterUserPassword(String password){
		
		
		passwordTextField.sendKeys(password);
		return this;
	}
	
	public void clickOnLoginButton(){
		loginButton.click();
	}
	
	public LandingPage loginWithSuccess(String username,String password){
		
		enterUserName(username);
		enterUserPassword(password);
		clickOnLoginButton();
		return new LandingPage(driver);
	}
	
	public LoginPage loginWithError(String username,String password){
		
		enterUserName(username);
		enterUserPassword(password);
		clickOnLoginButton();
		return new LoginPage(driver);
	}
	
	public String getUserNameErrorMessage(){
		return usernameErrorMessage.getText();
	}
	

	public String getPasswordErrorMessage(){
		return passwordErrorMessage.getText();
	}
	
	public String getUnSucessErrorMessage(){
		return unSuccessErrorMessage.getText();
	}

	public boolean isUserNameErrorDisplayed(){
		return usernameErrorMessage.isDisplayed();
	}
	
	public boolean isPasswordErrorMessageDisplayed(){
		return passwordErrorMessage.isDisplayed();
	}

	//Below are the Signup Methods
	
	
	public void enterUserEmail(String emailID){
		emailIDTextField.sendKeys(emailID);
	}
	
	public void enterFirstName(String firstName){
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		lastNameTextField.sendKeys(lastName);
	}
	
	public String getEmailError(){
		return emailError.getText();
	}
	
	public String getFirstNameError(){
		return firstNameError.getText();
	}
	
	
	public String getLastNameError(){
		return lastNameError.getText();
	}
	
	public void clickOnSignUpButton(){
		signUpButton.click();
	}
	
	
	public boolean isFirstNameErrorDisplayed(){
		 return firstNameError.isDisplayed();
	}
	
	
	public boolean isLastNameErrorDisplayed(){
		 return lastNameError.isDisplayed();
	}
	
	public boolean isEmailErrorDisplayed(){
		return emailError.isDisplayed();
		
	}
		
	public LoginPage signUpWithUnsuccess(String email,String firstName, String lastName){
		
			enterUserEmail(email);
			enterFirstName(firstName);
			enterLastName(lastName);
			clickOnSignUpButton();
			return new LoginPage(driver);
	}
	
	public void waitForSignupElementDisplay(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSignup")));
	}
}
