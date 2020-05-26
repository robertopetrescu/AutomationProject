package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Products {
	
	WebDriver _driver;
	
	public Products(WebDriver driver) {
		_driver = driver;
	}
	
	// Method 1: create a webelement only with the items that correspond
	  
	  //Create a list of Web Elements that can be added to cart
	//Then go to the second parent to go to the product details
	@FindBy(how=How.XPATH, using ="//button[@title='Add to Cart']/ancestor::div[2]")
	List<WebElement> allProducts;
	
	//Click on specified element
	public void chooseProduct(int product) {
		allProducts.get(product).click();
	}
	
	// Method 2: create a List and filter
	 /*
	//Click on specified element
	public void chooseProduct(int product) {
		List<WebElement> allProducts = _driver.findElements(By.cssSelector(".item div[class='text']"));
		
		filterProducts(allProducts);
		
		allProducts.get(product).click();
	}
	
	//return only items that can be added to cart
	public List<WebElement> filterProducts(List<WebElement> products) 
	{
		//iterate through each element
		for(int i=0;i<products.size();i++) 
		{
			//check if button 'Add to Cart' isPresent
			Boolean isPresent = products.get(i).findElements(By.cssSelector("div[class='actions'] button")).size() > 0;
						
			//if button is not present remove the element from the list
			if(!isPresent)
			{
				products.remove(i--);
			}
		}
		
		return products;
	}
	*/
}