package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class SignupFunctionalityForInvalidEmailID extends BaseClass {

	LoginPage loginPage=null;
	
	@Test(priority=1)
	public void signupWithIncorrectEmail(){
		
		loginPage=new LoginPage(driver);
		loginPage.signUpWithUnsuccess("akash", "akash", "singhal");
		
		Reporter.log("Signup button clicked successfully");
	}
	
	@Test(priority=2,dependsOnMethods={"signupWithIncorrectEmail"})
	public void verifyValidationMessages(){
		
		loginPage.waitForSignupElementDisplay();
		
		Assert.assertEquals(loginPage.getEmailError(), "Invalid Email."); 
		
		Assert.assertFalse(loginPage.isFirstNameErrorDisplayed());
		
		Assert.assertFalse(loginPage.isLastNameErrorDisplayed());
		
	}

}
