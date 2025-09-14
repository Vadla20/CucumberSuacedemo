package stepDefi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;

public class StepDefiTest10 {
	WebDriver driver = Hooks.driver;
	@Then("User Clicks on the sort button")
	public void user_clicks_on_the_sort_button() {
		WebElement drop = driver.findElement(By.className("product_sort_container"));
    	Select sortDropdown = new Select(drop);
         sortDropdown.selectByValue("za");
         System.out.println("item is sorted");
	}

}
