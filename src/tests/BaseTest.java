package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

    @Before
    public void setup(){
           System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().window().setPosition(new Point(2000,0));
           driver.manage().window().maximize();
           driver.get("https://eu.wahoofitness.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    
}
