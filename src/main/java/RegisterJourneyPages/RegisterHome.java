package RegisterJourneyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponents;

public class RegisterHome extends AbstractComponents{

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement SignUpUserName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement SignUpEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement SignUpButton;


	public RegisterHome(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void SignUpFlow(String Name, String Email) {

		SignUpUserName.sendKeys(Name);
		SignUpEmail.sendKeys(Email);
		
		CaptureScreen("1.Register Page");
		
		SignUpButton.click();

	}


}
