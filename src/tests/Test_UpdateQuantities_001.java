package tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

public class Test_UpdateQuantities_001 extends BaseTest{

	@Test
	public void updateQuantities() throws InterruptedException {
		//open homepage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		//click on products
		homepage.clickProducts();
				
		Products products = PageFactory.initElements(driver,Products.class);
		//select a product
		products.chooseProduct(3);
				
		//initialize product page
		Product product = PageFactory.initElements(driver,Product.class);
		
		product.addToCart(false);
				
		product.editCart();
		
		Cart cart = PageFactory.initElements(driver,Cart.class);
		
		cart.updateQuantity("3");
		
	}
	
}
