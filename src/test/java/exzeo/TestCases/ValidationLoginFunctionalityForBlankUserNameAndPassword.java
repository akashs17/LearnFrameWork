package exzeo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class ValidationLoginFunctionalityForBlankUserNameAndPassword extends BaseClass{
	
	LoginPage loginPage=null;
	
	@Test(priority=1)
	public void enterBlankUserNamePassword(){
		
		loginPage= new LoginPage(driver);
		
		loginPage.loginWithError("", "");
	}

	@Test(priority=2,dependsOnMethods={"enterBlankUserNamePassword"})
	public void checkValidationMessage(){
		
		Assert.assertEquals(loginPage.getUserNameErrorMessage().trim(),"Username/Email is required.");
		
		Assert.assertEquals(loginPage.getPasswordErrorMessage().trim(), "Password is required.");
	}
}
