package ProductJourneyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComp.AbstractComponents;


public class PaymentOrder extends AbstractComponents{

	

	@FindBy(xpath = "//input[@data-qa='name-on-card']")
	WebElement NameOnCard;
	
	@FindBy(xpath="//input[@data-qa='card-number']")
	WebElement CardNum;
	
	@FindBy(xpath="//input[@data-qa='cvc']")
	WebElement Cvc;
	
	@FindBy(xpath="//input[@data-qa='expiry-month']")
	WebElement ExpiryMonth;
	
	@FindBy(xpath="//input[@data-qa='expiry-year']")
	WebElement ExpiryYear;
	
	@FindBy(xpath="//button[@data-qa='pay-button']")
	WebElement PayConfirm;
	
	@FindBy(xpath="//div[@class='alert-success alert']")
	WebElement PaySuccess;
	
	
	
	public PaymentOrder(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void Payment(String CardName, String CardNumber, String cvc, String ExpiryM, String ExpiryY) {
	
		NameOnCard.sendKeys(CardName);
		CardNum.sendKeys(CardNumber);
		Cvc.sendKeys(cvc);
		ExpiryMonth.sendKeys(ExpiryM);
		ExpiryYear.sendKeys(ExpiryY);
		
		CaptureScreen("7.payment details entered");
		
		PayConfirm.click();
		
	}
	

	
	
}
