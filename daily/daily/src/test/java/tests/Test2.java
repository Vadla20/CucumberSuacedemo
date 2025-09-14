package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }
	 @Test
	    public void testRemoveItemFromCart() throws Exception {
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        Thread.sleep(5000);
	       
	        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	        driver.findElement(By.cssSelector("path[fill='currentColor']")).click();
	        driver.findElement(By.xpath("//button[text()='REMOVE']")).click();
	        System.out.println("Item Removed from cart");

	 }
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
