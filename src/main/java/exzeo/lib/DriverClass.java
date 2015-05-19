package exzeo.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverClass {

		
	public WebDriver getWebDriver(String browserName, WebDriver driver) {
		
		if(browserName.startsWith("I"))
			driver= new InternetExplorerDriver();
		else if(browserName.startsWith("F"))
			driver= new FirefoxDriver();
		else if(browserName.startsWith("C"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
			
		return driver;
		
	}
}
