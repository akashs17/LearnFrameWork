package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class SignUpFunctionalityForInvalidFirstLastName extends BaseClass{

	LoginPage loginPage=null;
	
	@Test(priority=1)
	public void signupWithIncorrectFirstAndLastName(){
		
		loginPage=new LoginPage(driver);
		loginPage.signUpWithUnsuccess("akash@yopmail.com", "akash1212", "singhal1212");
		
		Reporter.log("Signup button clicked successfully");
	}
	
	@Test(priority=2,dependsOnMethods={"signupWithIncorrectFirstAndLastName"})
	public void verifyValidationMessages(){
		
		Assert.assertFalse(loginPage.isEmailErrorDisplayed()); 
		
		Assert.assertEquals(loginPage.getFirstNameError(), "Only letters, spaces, hyphens and apostrophes are allowed.");
		
		Assert.assertEquals(loginPage.getLastNameError(), "Only letters, spaces, hyphens and apostrophes are allowed.");
		
	}

}
