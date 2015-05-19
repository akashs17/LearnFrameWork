package exzeo.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import exzeo.lib.DriverClass;

public class BaseClass {

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@BeforeTest
	public void setUpTest() {
		
		DriverClass driverManage= new DriverClass();
		
		driver=driverManage.getWebDriver(System.getProperty("browser"),driver);
		Assert.assertNotNull(driver);		
		driver.get(System.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
