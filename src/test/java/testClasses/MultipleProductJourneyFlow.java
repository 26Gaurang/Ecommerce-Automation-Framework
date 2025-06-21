package testClasses;


import org.testng.annotations.Test;

import BaseTest.BaseTest;
import ProductJourneyPages.LoginHome;
	import ProductJourneyPages.OrderConfirmation;
	import ProductJourneyPages.PaymentOrder;
	import ProductJourneyPages.ProductList;
	import ProductJourneyPages.ShopCart;
import Resources.getSQLData;

	public class MultipleProductJourneyFlow extends BaseTest {

		
		@Test(dataProvider = "sqlData", dataProviderClass = getSQLData.class)
		public void ProductCatalogue(String Email, String Pass, String Product, String Name, String CardNo, String cvv, String expmonth, String expyear) {
			
			String[] ProductsBuy = {"Rust Red Linen Saree","Madame Top For Women","Lace Top For Women"};
			
			LoginHome lh = new LoginHome(driver);
			lh.LoginHomePage(Email, Pass);
			
			
			ProductList pl = new ProductList(driver);
			
			for(int i=0; i<ProductsBuy.length;i++) {
				
				pl.ProductsListPage(ProductsBuy[i]);
				pl.ContinueShop();
				
			}
			
			pl.CartHeader();
			
			ShopCart sc = new ShopCart(driver);
			sc.CartCheckout();
			sc.ReviewOrder();
			
			PaymentOrder po = new PaymentOrder(driver);
			po.Payment(Name, CardNo, cvv, expmonth, expyear);
			
			OrderConfirmation oc = new OrderConfirmation(driver);
			oc.OrderPlaced();
			oc.Logout();
		}
		
		

		
	}

	

