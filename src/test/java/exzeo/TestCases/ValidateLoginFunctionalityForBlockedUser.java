package exzeo.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import exzeo.Pages.LoginPage;

public class ValidateLoginFunctionalityForBlockedUser extends BaseClass {

	
	  LoginPage loginPage=null;
	
	  @Test(priority=1)
	  public void loginWithBlockedUser() {
		  
		  loginPage= new LoginPage(driver);
		  loginPage.loginWithError("garimauser5@yopmail.com", "12345678");		  
		  Reporter.log("Blocked user tried to login in to the application");
	  }
	  
	  @Test(priority=2,dependsOnMethods={"loginWithBlockedUser"})
	  public void verifyBlockUserErrorMessage(){
		  
		  Assert.assertEquals(loginPage.getUnSucessErrorMessage(), "Your account is not accessible, Please contact to administrator.");
	  }
	  
}
