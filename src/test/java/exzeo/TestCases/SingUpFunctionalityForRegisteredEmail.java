package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class SingUpFunctionalityForRegisteredEmail extends BaseClass{

LoginPage loginPage=null;
	
	@Test(priority=1)
	public void signupUserWithRegisteredEmail(){
		
		loginPage=new LoginPage(driver);
		loginPage.signUpWithUnsuccess("aashuaajay@yopmail.com", "akash", "singhal");
		
		Reporter.log("Signup button clicked successfully");
	}
	
	@Test(priority=2,dependsOnMethods={"signupUserWithRegisteredEmail"})
	public void verifyValidationMessages() throws InterruptedException{
		
		loginPage.waitForSignupElementDisplay();
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getEmailError(), "This email is already registered with Exzeo."); 
		
		Assert.assertFalse(loginPage.isFirstNameErrorDisplayed());
		
		Assert.assertFalse(loginPage.isLastNameErrorDisplayed());
	}
	
}
