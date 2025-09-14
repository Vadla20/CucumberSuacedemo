package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }
	@Test
	public void errorMsgVerify() {
		 driver.findElement(By.id("user-name")).sendKeys("invalid_user");
         driver.findElement(By.id("password")).sendKeys("secret_sauce");
         driver.findElement(By.id("login-button")).click();
         
         String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

         System.out.println("error message :" +errorMsg);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
