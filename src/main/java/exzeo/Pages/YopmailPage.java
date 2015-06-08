package exzeo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailPage {

	@FindBy(id="login")
	WebElement loginTextField;
	
	@FindBy(css="css=.sbut")
	WebElement checkInboxButton;
	
	
}
