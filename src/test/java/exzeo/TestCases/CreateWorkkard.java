package exzeo.TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.ReporterConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.ReporterPanel;
import org.testng.xml.XmlTest;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.ReportMetadata;
import org.uncommons.reportng.ReportNGUtils;

import exzeo.Pages.CreateWorkkardPage;
import exzeo.Pages.LandingPage;
import exzeo.Pages.LoginPage;
import exzeo.Pages.WorkkardDetailViewPage;

public class CreateWorkkard extends BaseClass {

	
	HashMap<String, String> workkardDetails=null;
	WorkkardDetailViewPage detailView=null;
	String policyNumber="HCPCI" + Math.random();
	LandingPage landing=null;
	
	HTMLReporter asd= new HTMLReporter();
	
	@Test(priority=1)
	public void loginWithValidUser(){
		LoginPage login= new LoginPage(driver);
		landing= login.loginWithSuccess("pcsupervisor", "12345678");
		landing.clickOnCreateWorkkardButton();
		
	}
	

	
	@Test(priority=2)
	public void createWorkkard(){
		CreateWorkkardPage workkardPage= new CreateWorkkardPage(driver);		
		workkardPage.selectClaimTemplate();
		
		workkardDetails = new HashMap<String, String>();
		
		String workkardNumber="Workkard" + Math.random();
		
		workkardDetails.put("CFN", "Akash");
		workkardDetails.put("CLN", "Singhal");
		workkardDetails.put("CPN", "8958417172");
		workkardDetails.put("APN", "9045856765");
		workkardDetails.put("CEI", "singhalakash17@yopmail.com");
		workkardDetails.put("PA1", "C-128");
		workkardDetails.put("PA2", "Modipon Colony");
		workkardDetails.put("PZIP", "32042");
		workkardDetails.put("PNO",policyNumber );
		workkardDetails.put("PT", "Flood");
		workkardDetails.put("LT", "Hail");
		workkardDetails.put("WS", "This is the summary of workkard");
				
		detailView=workkardPage.createClaimWorkkard(workkardNumber, workkardDetails);
		
		//WorkkardDetailViewPage detailView=workkardPage.createDefaultWorkkard(workkardNumber);
		
	}
	
	@Test(priority=3)
	public void verifyCreatedWorkkard(){
		
		SoftAssert softAssert= new SoftAssert();		
		Assert.assertEquals(workkardDetails.get("CFN")+ " " +workkardDetails.get("CLN"), detailView.getCustomerName(),"Verifying customer name");
		
		Assert.assertEquals(workkardDetails.get("CPN"), detailView.getCustomerPhone(),"Verifying customer phone number");
		
		Assert.assertEquals(workkardDetails.get("APN"), detailView.getAlternatePhone(),"Verifying customer alternate phone number");
		
		Assert.assertEquals(workkardDetails.get("CEI"), detailView.getCustomerEmail(),"Verifying customer email id");
		
		Assert.assertEquals(workkardDetails.get("PNO"), detailView.getPolicyNumber(),"Verifying customer email ID");
		
		Assert.assertEquals(workkardDetails.get("PT"), detailView.getPolicyType(),"Verifying customer PolicyType");
		
		Assert.assertEquals(workkardDetails.get("LT"), detailView.getLossType(),"Verifying customer Loss Type");
		
		Assert.assertEquals(workkardDetails.get("WS"), detailView.getWorkkardSummary(),"Verifying workkard summary");
		
		softAssert.assertEquals(workkardDetails.get("LD"), detailView.getLossDate(),"Verifying customer loss date");
		
		softAssert.assertEquals(workkardDetails.get("RD"), detailView.getReportedDate(),"Verifing reported date of workkard");
		
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void changeWorkkardSponsor(){
		
		detailView.clickActionMenuAndWaitForMenuDispalay();
		
		detailView.clickChangeWorkkardSponsorAndWaitForPopup();
		
		detailView.dragAndDropNewSponsor();
		
		detailView.clickCWSConfirmButton();		
	
	}
}
