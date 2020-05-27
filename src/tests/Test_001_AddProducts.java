package tests;



import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Products;


public class Test_001_AddProducts extends BaseTest{

	@Test
	public void addProductsToCart() throws InterruptedException {
		
		//initialize HomePage
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		
		//click on products
		homepage.clickProducts();

		//initialize Products page
		Products products = PageFactory.initElements(driver,Products.class);
		
		//select a product
		products.chooseProduct(3);
		
		//initialize single product page
		Product product = PageFactory.initElements(driver,Product.class);
		
		//add product to cart
		product.addToCart(true);
		
		//check item is added to cart
		product.itemIsAddedToCartSidebar();
		
		//go back to products page
		homepage.clickProducts();
		
		//add another product to cart
		products.chooseProduct(4);
		
		//add product to cart and don't close miniCart
		product.addToCart(false);
		
		product.itemIsAddedToCartSidebar();
		
		//remove first element
		product.removeFromCart(0);
		
	}
}
