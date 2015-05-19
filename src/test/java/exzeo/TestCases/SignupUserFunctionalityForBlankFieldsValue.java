package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class SignupUserFunctionalityForBlankFieldsValue extends BaseClass{

	LoginPage loginPage=null;
	
	@Test(priority=1)
	public void clickSignupButtonWithBlankValues(){
		
		loginPage=new LoginPage(driver);
		loginPage.signUpWithUnsuccess("", "", "");
		
		Reporter.log("Signup button clicked successfully");
	}
	
	@Test(priority=2,dependsOnMethods={"clickSignupButtonWithBlankValues"})
	public void verifyValidationMessages(){
		
		Assert.assertEquals(loginPage.getEmailError(), "Email is required."); 
		
		Assert.assertEquals(loginPage.getFirstNameError(), "First Name is required.");
		
		Assert.assertEquals(loginPage.getLastNameError(), "Last Name is required.");
		
	}

	
}
