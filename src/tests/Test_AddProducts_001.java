package tests;



import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;


public class Test_AddProducts_001 extends BaseTest{

	@Test
	public void addProductsToCart() throws InterruptedException {
		//open homepage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		//click on products
		homepage.clickProducts();

		
		Products products = PageFactory.initElements(driver,Products.class);
		//select a product
		products.chooseProducts(19);
		
		//initialize product page
		Product product = PageFactory.initElements(driver,Product.class);
		//add product to cart
		product.addToCart(true);
		//check item is added to cart
		product.itemIsAddedToCartSidebar();
		//go back to products page
		homepage.clickProducts();
		//add another product to cart
		products.chooseProducts(26);
		//add product to cart and don't close 
		product.addToCart(false);
		
		product.itemIsAddedToCartSidebar();
		//to remove alert somehow..
		product.removeFromCart(driver,0);
		
	}
}
