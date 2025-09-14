package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Test4 {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
    }
	@DataProvider(name = "users")
    public Object[][] getUsers() {
        return new Object[][]{
            {"standard_user", "secret_sauce"},
            {"problem_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "users")
    public void loginTest(String username, String password) throws Exception {
    	 // Step 1: Enter credentials
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed for user: " + username);
        
     // Step 3: Logout for next test iteration
        driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        
        System.out.println("Users login Successfully!");
    }
	 @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

}
