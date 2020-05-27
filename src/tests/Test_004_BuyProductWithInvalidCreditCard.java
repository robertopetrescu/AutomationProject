package tests;

import org.openqa.selenium.support.PageFactory;

import pageObjects.Cart;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class Test_004_BuyProductWithInvalidCreditCard extends BaseTest{
	
	@Test
	public void buyProduct() throws InterruptedException {
			
			//open homepage
			HomePage homepage = PageFactory.initElements(driver,HomePage.class);
			//click on products
			homepage.clickProducts();
							
			Products products = PageFactory.initElements(driver,Products.class);
			//select a product
			products.chooseProduct(4);
							
			//initialize product page
			Product product = PageFactory.initElements(driver,Product.class);
					
			//add to cart and don't close 
			product.addToCart();
							
			product.editCart();
			
			Cart cart = PageFactory.initElements(driver,Cart.class);
				
			cart.clickElement(cart.ProceedToCheckout);
				
			Checkout checkout = PageFactory.initElements(driver,Checkout.class);
			//checkout.ss();

			checkout.populateFields("someone@whocares.com", "Test", "Tester", "Comandante Izarduy 67, Barcelona, 08940", 1113344455566L, "4111111111111111, 08/24, 111");
			
			assertTrue(checkout.ErrorMessage.isDisplayed(),"There was no error message");
	}
}
