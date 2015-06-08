package exzeo.TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import exzeo.Pages.LandingPage;
import exzeo.Pages.LoginPage;
import exzeo.Pages.WorkkardDetailViewPage;

public class ValidateOrgImageUploadFunctionality extends BaseClass {

		
		HashMap<String, String> workkardDetails=null;
		WorkkardDetailViewPage detailView=null;
		String policyNumber="HCPCI" + Math.random();
		LandingPage landing=null;
		
		HTMLReporter asd= new HTMLReporter();
		
		@Test(priority=1)
		public void loginWithValidUser(){
			LoginPage login= new LoginPage(driver);
			landing= login.loginWithSuccess("pcsupervisor", "12345678");
			//landing.clickOnCreateWorkkardButton();
			
		}
		
		@Test(priority=2)
		public void uploadImage(){
			
			landing.clickOnChangeOrgImage();
			
			landing.waitForPopUpDialogBoxDisplay();
			
			landing.UploadImageAndWaitTillLoad("D:\\installer_r24.2-windows.exe");
			
			Assert.assertEquals(landing.getUploadErrorMEssage(),"Please select the right image format.");		
		}
		
		
		
		
		@Test(priority=3,dataProvider="imageLocation")
		public void uploadImageAndCheckValidationMessage(String path){
			
			landing.UploadImageAndWaitTillLoad(path);
			
			Assert.assertEquals(landing.getUploadErrorMEssage(),"Please select the right image format.");
		}
		
		@Test(priority=4)
		public void closeDialogBox(){
			landing.clickOnCloseIconOfPopUpAndVerifyNonExistence();
			
		}
		
		@DataProvider(name="imageLocation")
		public Object[][] imageLocationPath(){
			
			Object[][] paths={{"D:\\logs\\web\\exzeo-ruleengine.log"},{"D:\\Others\\~!@#$%^&()~-=_+{},.;'[].txt"},{"D:\\Others\\1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij.txt"}};
			return paths;
		}
}
