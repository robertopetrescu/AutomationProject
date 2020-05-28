package tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

public class Test_003_CheckMandatoryFields extends BaseTest{
	
	@Test
	public void checkMandatoryFields() throws InterruptedException {
		
		//initialize HomePage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		
		//Click on products
		homepage.clickProducts();
		
		//Initialize Products page
		Products products = PageFactory.initElements(driver,Products.class);
				
		//Select a product
		products.chooseProduct(4);
			
		//Initialize product page
		Product product = PageFactory.initElements(driver,Product.class);
		
		//Add to cart
		product.addToCart();
				
		//Click on edit Cart
		product.editCart();
		
		Cart cart = PageFactory.initElements(driver,Cart.class);
		
		//proceed to checkout - Public WebElement
		cart.clickElement(cart.ProceedToCheckout);
			
		Checkout checkout = PageFactory.initElements(driver,Checkout.class);
		
		//Place Order - public WebElement called from test
		checkout.clickElement(checkout.PlaceOrder);
		
		checkout.checkErrorMessage();
	
	}
}
