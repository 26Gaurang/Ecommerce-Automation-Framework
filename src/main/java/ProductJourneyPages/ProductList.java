package ProductJourneyPages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComp.AbstractComponents;



public class ProductList extends AbstractComponents{

	
	@FindBy(xpath = "//div[@class='product-image-wrapper']")
	List<WebElement> Products;
	
	
	public ProductList(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}

	
	public void ProductsListPage(String ProductWish) {
		
		WebElement ProductHeaderButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
		
		WaitForVisibility(ProductHeaderButton);
		
		CaptureScreen("2.Product Home");
		
		ProductHeaderButton.click();
		
		for(int i=0; i<Products.size(); i++) {
			
			WebElement Prod = Products.get(i);
			String ProductName = Prod.getText().trim();
			
			if(ProductName.contains(ProductWish)) {
				//System.out.println(ProductName);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Prod);
				
				CaptureScreen("3.Product Found");
				
				Actions a = new Actions(driver);
				a.moveToElement(Prod).perform();
				
				WebElement AddButton = Prod.findElement(By.xpath(".//a[@class='btn btn-default add-to-cart']"));
				
				WaitForVisibility(AddButton);
				
			
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);
				
				CaptureScreen("4.Product Added");
				
				break;
				
			} // if ends		
		} // for loop ends
	}// method ends
	
	
	public void ProductAddedPopUp() {
		
		WebElement ViewCartButton = driver.findElement(By.xpath("//a/u[contains(text(), 'View Cart')]"));
		
		WaitForVisibility(ViewCartButton);
		
		CaptureScreen("5.View Product in Cart");
		
		ViewCartButton.click();
		
	}
	
	public void ContinueShop() {
		
		WebElement ContinueButton = driver.findElement(By.xpath("//button[contains(text(), 'Continue Shopping')]"));
		
		WaitForVisibility(ContinueButton);
		
		CaptureScreen("5.Add another Product");
		
		ContinueButton.click();
		
	}
	
public void CartHeader() {
	
	WebElement CartHeaderButton = driver.findElement(By.xpath("//a[contains(text(), 'Cart')]"));
	
	WaitForVisibility(CartHeaderButton);
	
	CartHeaderButton.click();
}	
	
	
	
	
}


