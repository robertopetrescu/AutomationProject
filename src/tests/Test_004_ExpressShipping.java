package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

public class Test_004_ExpressShipping extends BaseTest{
	
	@Test
	public void expressShipping() throws InterruptedException {
		
		//Initialize Homepage class
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		
		//Click on products
		homepage.clickProducts();
		
		//Initialize All Products class
		Products products = PageFactory.initElements(driver,Products.class);
		
		//Select a product
		products.chooseProduct(4);
		
		//Initialize single Product class
		Product product = PageFactory.initElements(driver,Product.class);
				
		//Add to cart and don't close miniCart
		product.addToCart();
						
		//Click on Edit Cart and user will be redirected to Cart page
		product.editCart();
		
		//initialize Cart class
		Cart cart = PageFactory.initElements(driver,Cart.class);
		
		//click on Proceed to checkout
		cart.clickElement(cart.ProceedToCheckout);
			
		Checkout checkout = PageFactory.initElements(driver,Checkout.class);
		
		//check if the new Total value is calculated correctly after pressing 'Express Shipping'
		assertTrue(checkout.CheckExpressShipping(),"Express shipping price is not calculated correctly");
	}
}
