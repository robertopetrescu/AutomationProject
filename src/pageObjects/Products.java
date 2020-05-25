package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class Products {
	@FindBy(how=How.CLASS_NAME, using ="amlabel-div")
	List<WebElement> allProducts;
	
	@FindBy(how=How.CLASS_NAME, using ="product-full")
	List<WebElement> productsFull;
	
	/*@FindBy(how=How.XPATH, using ="//button[@title='Add to Cart']/ancestor::li")
	List<WebElement> allProducts;*/
	
	
	public void chooseProducts(int product) {
		System.out.println(allProducts.size());
		for(int j=0;j<allProducts.size();j++)
		{
			//select only items that have 'Add to cart' details
		}
		allProducts.get(product).click();

		
	}
	

	
	
}