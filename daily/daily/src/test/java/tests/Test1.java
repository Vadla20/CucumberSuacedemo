package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }
	 @Test
	    public void testAddItemToCart() throws Exception  {
	        // Step 1: Login
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        Thread.sleep(5000);
	     // Step 2: Add first item to cart //div[@class='inventory_list']//div[1]//div[3]//button[1]
	        WebElement firstItemAddButton = driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]"));
	        firstItemAddButton.click();
	        
	        driver.findElement(By.cssSelector("path[fill='currentColor']")).click();	        
	 }
	 
	 @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
}
