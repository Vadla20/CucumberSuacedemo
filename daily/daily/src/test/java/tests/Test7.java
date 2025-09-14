package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test7 {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }
	@Test
	public void purchaseItem() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        WebElement firstItemAddButton = driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]"));
        firstItemAddButton.click();
        driver.findElement(By.cssSelector("path[fill='currentColor']")).click();
        driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Bhalla");
        driver.findElement(By.id("last-name")).sendKeys("Vad");
        driver.findElement(By.id("postal-code")).sendKeys("456895");
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='FINISH']")).click();
        WebElement msg = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String message = msg.getText();
        System.out.println("Message: "+message);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
