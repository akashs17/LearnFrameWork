package exzeo.TestCases;

import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import exzeo.Pages.LandingPage;
import exzeo.Pages.LoginPage;

public class ValidateLoginFunctionalityForValidUserNameAndPassword extends BaseClass {
	
	
  @Test
  public void loginFunctionality() {
	  
	  LoginPage loginPage= new LoginPage(driver);
	  LandingPage landingPage=loginPage.loginWithSuccess("pcsupervisor", "12345678");
	  
  }
}

