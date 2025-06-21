package ProductJourneyPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponents;

public class ShopCart extends AbstractComponents {


	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement ProceedToCheckout;
	
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement PlaceOrder;


	public ShopCart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void CartCheckout() {
		ProceedToCheckout.click();	
	}
	
	public void ReviewOrder() {
		
		CaptureScreen("6.Product order placed");
		
		JSscroll(PlaceOrder);
		
		ElementToBeClickable(PlaceOrder);
		
		JSclick(PlaceOrder);
	}
	
	
	
	
	
	
	
	
	
}
