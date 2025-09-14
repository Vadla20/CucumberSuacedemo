package stepDefi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;

public class StepDefiTest9 {
	WebDriver driver = Hooks.driver;
	@And("The item is removen from Cart")
	public void the_item_is_removen_from_cart() {
		driver.findElement(By.xpath("//button[text()='REMOVE']")).click();
        System.out.println("Item Removed from cart");
	}

}
