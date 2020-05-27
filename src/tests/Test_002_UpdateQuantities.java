package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

public class Test_002_UpdateQuantities extends BaseTest{

	@Test
	public void updateQuantities() throws InterruptedException {
		
		//open homepage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		
		//click on products
		homepage.clickProducts();
				
		Products products = PageFactory.initElements(driver,Products.class);
		//select a product
		products.chooseProduct(4);
				
		Thread.sleep(2000);
		//initialize product page
		Product product = PageFactory.initElements(driver,Product.class);
		
		//add to cart and don't close 
		product.addToCart();
				
		product.editCart();
		
		Cart cart = PageFactory.initElements(driver,Cart.class);
		
		//update quantity and return total price
		cart.updateQuantity(3);
		
		//check price
		cart.checkSubTotal();
		
		//proceed to checkout - Public WebElement
		cart.clickElement(cart.ProceedToCheckout);
			
		Checkout checkout = PageFactory.initElements(driver,Checkout.class);
		
		//Place Order - public WebElement called from test
		checkout.clickElement(checkout.PlaceOrder);
		
		checkout.checkErrorMessage();
		
		Thread.sleep(5000);
		
	}
	
}
