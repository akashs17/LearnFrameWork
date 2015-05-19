package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exzeo.Pages.LoginPage;

public class ValidateLoginFunctionalityForIncorrectUserNamePassword  extends BaseClass{

	LoginPage loginPage=null;
	
	@Test(priority=1)
	public void enterIncorrectUserNameAndPassword(){
		
		loginPage= new LoginPage(driver);
		
		loginPage.loginWithError("pcsupervisor", "123123123123123");
		
		Reporter.log("Incorrect user name password entered successfully");
	}

	@Test(priority=2,dependsOnMethods={"enterIncorrectUserNameAndPassword"})
	public void checkValidationMessage(){
		
		Assert.assertEquals(loginPage.getUnSucessErrorMessage(),"Username/Email or Password entered is incorrect.");			
						
	}
	
	@Test(priority=3,dependsOnMethods={"enterIncorrectUserNameAndPassword"})
	public void checkNonExistenceOfOtherValidationMessage(){
		
		Assert.assertFalse(loginPage.isUserNameErrorDisplayed());
		
		Assert.assertFalse(loginPage.isPasswordErrorMessageDisplayed());
	}
	
}

