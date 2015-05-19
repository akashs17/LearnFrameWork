package exzeo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWorkkardPage {

	@FindBy(id = "urlddl")
	WebElement templateType;

	@FindBy(id = "txtWorkkardNumber")
	WebElement workkardNumber;

	@FindBy(id = "txtareaWorkkardDesc")
	WebElement workkardSummary;

	@FindBy(id = "txtLastName")
	WebElement customerLastName;

	@FindBy(id = "txtFirstName")
	WebElement customerFirstName;

	@FindBy(id = "txtPhone")
	WebElement customerPhone;

	@FindBy(id = "txtAltPhone")
	WebElement customerAlternatePhone;

	@FindBy(id = "txtEmailWorkkard")
	WebElement customerEmailId;

	@FindBy(id = "txtPropertyAddress1")
	WebElement propertyAddress1;

	@FindBy(id = "txtPropertyAddress2")
	WebElement propertyAddress2;

	@FindBy(id = "txtPropertyZip")
	WebElement propertyZipCode;

	@FindBy(id = "chkMailingAddress")
	WebElement mailingAddressCheckBox;

	@FindBy(id = "txtMailingZip")
	WebElement mailingZip;

	@FindBy(id = "txtMailingAddress1")
	WebElement mailingAddress1;

	@FindBy(id = "txtMailingAddress2")
	WebElement mailingAddress2;

	@FindBy(id = "txtPolicyNumber")
	WebElement policyNumber;

	@FindBy(id = "ddPolicyType")
	WebElement policyTypeDropDown;

	@FindBy(id = "txtLossDate")
	WebElement lossDate;

	@FindBy(id = "txtReportedDate")
	WebElement reportedDate;

	@FindBy(id = "ddLossType")
	WebElement lossTypeDropDown;

	@FindBy(css = "input[value=CAT]")
	WebElement workkardTypeCatRadio;

	@FindBy(css = "input[value=Daily]")
	WebElement workkardTypeDialyRadio;

	@FindBy(id = "btnSaveWorkkardPopup")
	WebElement saveButton;

	@FindBy(id = "btnSaveWorkkard")
	WebElement saveAndAddActivity;

	@FindBy(id = "btnCancelWorkkard")
	WebElement cancelLink;

	public boolean isTemplateDisplayed()
	{
		return templateType.isDisplayed();
	}
	

	public boolean isWorkkardNumber()
	{
		return workkardNumber.isDisplayed();
	}

	public boolean isWorkkardSummaryDisplayed()
	{
		return workkardSummary.isDisplayed();
	}

	public boolean isWrokkardTypeCATDisplayed()
	{
		return workkardTypeCatRadio.isDisplayed();
	}

	public boolean isWorkkardTypeDailyDisplayed()
	{
		return workkardTypeDialyRadio.isDisplayed();
	}


	public boolean isCustomerFirstNameDisplayed()
	{
		return customerFirstName.isDisplayed();
	}

	public boolean isCustomerLastNameDisplayed()
	{
		return customerLastName.isDisplayed();
	}

	public boolean isCustomerEmailDisplayed()
	{
		return customerEmailId.isDisplayed();
	}
	
	public boolean isCustomerPhoneDisplayed()
	{
		return customerPhone.isDisplayed();
	}

	public boolean isCustomerAlternatePhoneDisplayed()
	{
		return customerAlternatePhone.isDisplayed();
	}

	public boolean isPropertyAddress1Displayed()
	{
		return propertyAddress1.isDisplayed();
	}

	public boolean isPropertyAddress2Displayed()
	{
		return propertyAddress2.isDisplayed();
	}
	
	public boolean isPropertyZipDisplayed()
	{
		return propertyZipCode.isDisplayed();
	}
	
	public boolean isPropertyAddressDisplayed()
	{
		return propertyAddress1.isDisplayed();
	}
	
	public boolean isMailingAdress1Displayed()
	{
		return mailingAddress1.isDisplayed();
	}
	
	public boolean isMailingAdress2Displayed()
	{
		return mailingAddress2.isDisplayed();
	}
	
	public boolean isMailingAdressZipDisplayed()
	{
		return mailingZip.isDisplayed();
	}
	
	public boolean isMailingAdressCheckboxDisplayed()
	{
		return mailingAddressCheckBox.isDisplayed();
	}

	public boolean isPolicyNumberDisplayed()
	{
		return policyNumber.isDisplayed();
	}
	
	public boolean isPolicyTypeDropDownDisplayed()
	{
		return policyTypeDropDown.isDisplayed();
	}
	
	public boolean isLossDateDisplayed()
	{
		return lossDate.isDisplayed();
	}
	
	public boolean isLossTypeDropDownDisplayed()
	{
		return lossTypeDropDown.isDisplayed();
	}
	
	public boolean isSaveButtonDisplayed()
	{
		return saveButton.isDisplayed();
	}
	
	public boolean isSaveAndAddActivityButtonDisplayed()
	{
		return saveAndAddActivity.isDisplayed();
	}
	
	public boolean isCancelLinkDisplayed()
	{
		return cancelLink.isDisplayed();
	}
	
	
	
}




