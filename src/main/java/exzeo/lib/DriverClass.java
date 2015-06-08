package exzeo.lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverClass {

		
	public WebDriver getWebDriver(String browserName, WebDriver driver) throws MalformedURLException  {
		
		DesiredCapabilities capbilities=null;
		
		if(browserName.startsWith("I"))
			driver= new InternetExplorerDriver();
		else if(browserName.startsWith("F"))
		{
			capbilities=DesiredCapabilities.firefox();
			capbilities.setBrowserName("firefox");
			capbilities.setPlatform(Platform.VISTA);
			driver= new RemoteWebDriver( new URL("http://tryexzeo.com"),capbilities);
		
			
			//capbilities.setCapability("jenkins.nodeName","(master)");
			//capbilities.setVersion("36");
			
			
			//driver=new FirefoxDriver();
		}
		else if(browserName.startsWith("C"))
		{
			String dir=System.getProperty("user.dir") + "\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", dir);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			
		}
			
		return driver;
		
	}
}
