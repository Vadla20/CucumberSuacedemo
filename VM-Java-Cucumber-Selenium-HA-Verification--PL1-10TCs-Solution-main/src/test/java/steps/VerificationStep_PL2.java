
package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import coreUtilities.utils.FileOperations;
import io.cucumber.java.en.*;
import pages.VerificationPage_PL2;

public class VerificationStep_PL2 extends TestBase {

	String requisitionNumber = "";

	LocalDate currentDate = LocalDate.now();
	LocalDate date7DaysAgo = currentDate.minusDays(90);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String toDate = currentDate.format(formatter);
	String fromDate = date7DaysAgo.format(formatter);

	VerificationPage_PL2 pl2 = new VerificationPage_PL2(driver);

	private final String EXCEL_FILE_PATH = "src/main/resources/config.xlsx"; // Path to the Excel file
	private final String SHEET_NAME = "ExpectedData"; // Sheet name in the Excel file

	@When("Login in the healthapp application")
	public void login_in_the_healthapp_application() {
		Assert.assertTrue(pl2.login(), "Login should return true");
	}

	@Given("Scroll & click till {string} menu on the side bar.")
	public void scroll_click_till_menu_on_the_side_bar(String string) {
		Assert.assertTrue(pl2.openVerificationMenu(), "Menu should open successfully");
	}

	@Then("Verify that the user is able to navigate to {string} section") // OK
	public void verify_that_the_user_is_able_to_navigate_to_section(String module) throws InterruptedException {
		Assert.assertTrue(pl2.successfullNavigation(module), "Navigation to section '" + module + "' should succeed");
	}

	@Then("Verify that {string} button is visible.")
	public void verify_that_buttons_are_visible(String text) {
		Assert.assertTrue(pl2.verifyButtonPresentWithText(text), "Button with text '" + text + "' should be visible");
	}

	@Then("Click on {string} under {string}")
	public void click_on_under(String subModule, String module) {
		Assert.assertTrue(pl2.clickOnButtonByText(module), "Failed to click on module button: " + module);
		Assert.assertTrue(pl2.clickOnButtonByText(subModule), "Failed to click on sub-module button: " + subModule);
	}

	// OK-3
	@Then("Verify these elements are visible on the page Requisition, Purchase Request, Purchase Order, GR Quality Inspection, Ok, print, First, Previous, Next, Last, view, search bar, Requisition Status, Date range, Pending, Approved, Rejected")
	public void verifyElementsArePresentOnThePage() throws Exception {
		Assert.assertTrue(pl2.verifyVerificationComponentsAreVisible());
	}

	@Then("Click on {string} tab")
	public void click_on_tab(String text) {
		pl2.clickOnButtonByText(text);
	}

	@When("Choose the date from Jan 2020 to March 2024")
	public void choose_date() {

		Assert.assertTrue(pl2.chooseDate(fromDate, toDate));
	}

	@Then("Click on the {string} Radio button from List by Verification Status")
	public void click_on_the_radio_button_from_list_by_verification_status(String radioButtonText) {
		Assert.assertTrue(pl2.selectRadioButton(radioButtonText),
				"Failed to select radio button with text: " + radioButtonText);
	}

	@When("Click on OK button")
	public void click_ok() {
		Assert.assertTrue(pl2.clickOkButton());
	}

	@Then("Verify that all the dates present inside the requested date are within the range")
	public void verify_that_all_the_dates_present_inside_the_requested_date_are_within_the_range()
			throws InterruptedException {
		LocalDate currentDate = LocalDate.now();
		LocalDate date7DaysAgo = currentDate.minusDays(90);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = currentDate.format(formatter);
		String fromDate = date7DaysAgo.format(formatter);
		Thread.sleep(3000); // Waiting for data to load
		Assert.assertTrue(pl2.verifyDateRange(fromDate, toDate));
	}

	@Then("Hover on the star and Verify tooltip text as {string}")
	public void hover_on_the_star_and_verify_tooltip_text_as_remember_this_date(String tooltipText) {
		Assert.assertEquals(pl2.verifyToolTipText(), tooltipText);
	}

	@When("Click on tooltip button")
	public void click_tooltip() {
		Assert.assertTrue(pl2.clickTooltip());
	}

	@Then("Verify that the date range remains the same")
	public void verify_desired_date_range() {
		Assert.assertTrue(pl2.verifyDateRangeforReq(fromDate, toDate));
	}

	@When("Select {string} option from the date range dropdown")
	public void date_range(String range) {
		Assert.assertTrue(pl2.chooseDateRange(range));
	}

}
