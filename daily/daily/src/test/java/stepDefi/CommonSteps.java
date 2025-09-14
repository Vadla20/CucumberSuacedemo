package stepDefi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CommonSteps {
	WebDriver driver = Hooks.driver;
	String baseURL = "https://www.saucedemo.com/v1/";

	@Given("User is on the SauceDemo login page")
	public void user_is_on_the_sauce_demo_login_page() {
		Assert.assertEquals(driver.getCurrentUrl(), baseURL);
		System.out.println("user is navigated to correct URL");
	    
	}

	@When("User logs in with username {string} and password {string}")
	public void user_logs_in_with_username_and_password(String username, String password) throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        System.out.println("User logined successfully");
        Thread.sleep(5000);
	}

	@And("User adds the first item to the cart")
	public void user_adds_the_first_item_to_the_cart() {
		WebElement firstItemAddButton = driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]"));
        firstItemAddButton.click();
        System.out.println("User added item to cart");
	}
	@Then("The item should be present in the cart")
	public void the_item_should_be_present_in_the_cart() throws Exception {
		driver.findElement(By.cssSelector("path[fill='currentColor']")).click();
		System.out.println("Item is in the cart");
		Thread.sleep(3000);
	}

}
