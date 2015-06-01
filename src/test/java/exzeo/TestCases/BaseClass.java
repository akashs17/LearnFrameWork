package exzeo.TestCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import exzeo.lib.DriverClass;

public class BaseClass {

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@BeforeSuite
	public void beforeSuite(){
		  System.setProperty("org.uncommons.reportng.escape-output", "false");		  
	}
	
	@BeforeTest
	public void setUpTest() throws MalformedURLException {
		
		DriverClass driverManage= new DriverClass();
		
		driver=driverManage.getWebDriver(System.getProperty("browser"),driver);
		Assert.assertNotNull(driver);		
		driver.get(System.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException{
			
			String path=System.getProperty("user.dir")+ "\\ScreenShots"  + "\\"  +result.getName() +".png";
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(path));
								
	}
		
}
