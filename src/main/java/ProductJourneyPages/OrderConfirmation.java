package ProductJourneyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComp.AbstractComponents;

public class OrderConfirmation extends AbstractComponents{

	//@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	//WebElement OrderPlace;
	
	@FindBy(xpath = "//a[text()='Download Invoice']")
	WebElement InvoiceButton;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement ContinueButton;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement LogOut;
	
	public OrderConfirmation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void OrderPlaced() {
		
		CaptureScreen("8.Product order page");
		
		InvoiceButton.click();
		
		CaptureScreen("9.invoice downloaded");

		ContinueButton.click();
		
		CaptureScreen("10.product ordered");
		
	
	}
	
	public void Logout() {
		
		LogOut.click();
		
		CaptureScreen("11.Log out");
		
	}
	
}
