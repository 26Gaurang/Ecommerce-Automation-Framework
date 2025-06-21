package ProductJourneyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponents;

public class LoginHome extends AbstractComponents {


	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement LoginEmailId;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement LoginSubmit;

	public LoginHome(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void LoginHomePage(String emailID, String LogPassword) {
		
		LoginEmailId.sendKeys(emailID);
		LoginPassword.sendKeys(LogPassword);
		
		CaptureScreen("1.Login Page");
		
		LoginSubmit.click();
		
		
		
	}
	
}
