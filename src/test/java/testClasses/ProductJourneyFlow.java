package testClasses;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import ProductJourneyPages.LoginHome;
import ProductJourneyPages.OrderConfirmation;
import ProductJourneyPages.PaymentOrder;
import ProductJourneyPages.ProductList;
import ProductJourneyPages.ShopCart;
import Resources.getSQLData;

public class ProductJourneyFlow extends BaseTest{

	@Test(dataProvider = "sqlData", dataProviderClass = getSQLData.class)
	public void ProductCatalogue(String Email, String Pass, String Product, String Name, String CardNo, String cvv, String expmonth, String expyear) {
		
		LoginHome lh = new LoginHome(driver);
		lh.LoginHomePage(Email, Pass);	
		test.info("logged in");
		
		ProductList pl = new ProductList(driver);
		pl.ProductsListPage(Product);
		
		test.info("product selected");
		
		pl.ProductAddedPopUp();
		
		test.info("view cart pressed");
	
		ShopCart sc = new ShopCart(driver);
		sc.CartCheckout();
		sc.ReviewOrder();
		
		test.info("cart viewed");
		
		PaymentOrder po = new PaymentOrder(driver);
		po.Payment(Name, CardNo, cvv, expmonth, expyear);
		
		test.info("payment done");
		
		OrderConfirmation oc = new OrderConfirmation(driver);
		oc.OrderPlaced();
		
		test.info("order placed & invoice downloaded");
		
		oc.Logout();
		
		test.info("logged out");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
