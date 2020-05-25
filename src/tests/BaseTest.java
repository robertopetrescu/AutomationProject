package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

    @Before
    public void setup(){
           System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.get("https://eu.wahoofitness.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    
    

}
