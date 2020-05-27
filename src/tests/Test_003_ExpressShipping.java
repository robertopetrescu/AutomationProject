package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

public class Test_003_ExpressShipping extends BaseTest{
	
	@Test
	public void expressShipping() throws InterruptedException {
		//open homepage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		//click on products
		homepage.clickProducts();
						
		Products products = PageFactory.initElements(driver,Products.class);
		//select a product
		products.chooseProduct(3);
						
		Thread.sleep(2000);
		//initialize product page
		Product product = PageFactory.initElements(driver,Product.class);
				
		//add to cart and don't close 
		product.addToCart(false);
						
		product.editCart();
		
		Cart cart = PageFactory.initElements(driver,Cart.class);
			
		cart.proceedToCheckout.click();
			
		Checkout checkout = PageFactory.initElements(driver,Checkout.class);
		//checkout.ss();
		Thread.sleep(9000);
		
		assertTrue(checkout.CheckExpressShipping(),"Express shipping price is not calculated correctly");
	}
}
