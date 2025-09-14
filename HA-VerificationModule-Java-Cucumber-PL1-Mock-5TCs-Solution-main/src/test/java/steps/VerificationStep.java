
package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.Verification_Page;

public class VerificationStep extends TestBase {

	Verification_Page verification = new Verification_Page(driver);

	String requisitionNumber = "";

	LocalDate currentDate = LocalDate.now();
	LocalDate date7DaysAgo = currentDate.minusDays(90);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String toDate = currentDate.format(formatter);
	String fromDate = date7DaysAgo.format(formatter);

//	=====================
//	Common Steps section
//	=====================

	@When("Login in the healthapp application")
	public void login_in_the_healthapp_application() throws InterruptedException {
		verification.login();
	}

	@Given("Scroll & click till {string} menu on the side bar.")
	public void scroll_click_till_menu_on_the_side_bar(String string) {
		Assert.assertTrue(verification.openVerificationMenu());
	}

	@Then("Verify that the user is able to navigate to {string} section")
	public void verify_that_the_user_is_able_to_navigate_to_section(String module) throws InterruptedException {
		Assert.assertTrue(verification.successfullNavigation(module));
	}

//	=====================
//	TC-1 Steps Section
//	=====================

	@When("Choose the date from Jan 2020 to March 2024")
	public void choose_date() {
		// Define date range
		String fromDate = LocalDate.of(2022, 1, 1).format(formatter);
		Assert.assertTrue(verification.chooseDate(fromDate, toDate));
	}

	@When("Click on OK button")
	public void click_ok() {
		Assert.assertTrue(verification.clickOkButton());
	}

	@When("Choose {string} option from requistion status dropdown")
	public void choose_requistion_status(String status) throws Exception {
		Assert.assertTrue(verification.chooseReqStatus(status));
	}
	
	@Then("Verify that the choosen option is {string}")
	public void verify_that_the_choosen_option_is_active(String status) {
		Assert.assertTrue(verification.verifyReqStatus(status));
	}

//	=====================
//	TC-2 Steps Section
//	=====================

	@Then("Click on the {string} Radio button from List by Verification Status")
	public void click_on_the_radio_button_from_list_by_verification_status(String radioButtonText) {
		Assert.assertTrue(verification.selectRadioButton(radioButtonText));
	}

	@When("Fetch the requisition Id & Click on View button from the first row of requisition data")
	public void fetch_requisition_num() {
		requisitionNumber = verification.fetchReqNum();
	}
	
	@When("Verify the requisition Id")
	public void verify_req_id() {
		Assert.assertTrue(verification.verifyReqNum(requisitionNumber));
	}
//	=====================
//	TC-3 Steps Section
//	=====================	

	@Then("Click on {string} under {string}")
	public void click_on_under(String subModule, String module) {
		Assert.assertTrue(verification.clickOnButtonByText(module));
		Assert.assertTrue(verification.clickOnButtonByText(subModule));
	}
	
	@Then("Fetch the total count and check if it matches with total items displayed")
	public void verify_total_count() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(verification.verifyCount());
	}

//	=====================
//	TC-4 Steps Section
//	=====================

	

	@When("Scroll all the way to the bottom of the page")
	public void scroll_all_the_way_to_the_bottom_of_the_page() throws Exception {
		Assert.assertTrue(verification.scrollAllTheWayDown());
	}

	@Then("Verify Previous button is visible")
	public void verify_previous_button_is_visible() throws Exception {
		Assert.assertTrue(verification.isPreviousButtonVisible());
	}

	@Then("Scroll all the way to the top of the page")
	public void scroll_all_the_way_to_the_top_of_the_page() throws Exception {
		Assert.assertTrue(verification.scrollAllTheWayUp());
	}

	@Then("Verify Pending radio button is visible")
	public void verify_pending_radio_button_is_visible() throws Exception {
		Assert.assertTrue(verification.isPendingRadioButtonVisible());
	}

//	=====================
//	TC-5 Steps Section
//	=====================

	@Given("Navigate to the Internal section under Inventory")
	public void navigate_to_the_section_under_inventory() {
		Assert.assertTrue(verification.clickOnInventory());
	}

	@When("Click on Purchase Request")
	public void click_on_purchase_request() {
		Assert.assertTrue(verification.clickOnPurchaseRequest());
	}

	@When("Click on the Create Purchase Request button")
	public void click_on_the_button_create_purchase_request() {
		Assert.assertTrue(verification.clickOnCreatePurchaseRequestButton());
	}

	@When("Click on the Request button")
	public void click_on_the_Request_button() {
		Assert.assertTrue(verification.clickOnRequestButton());
	}

	@Then("Verify error message as {string} is displayed")
	public void verify_error_message_as_is_displayed(String string) {
		Assert.assertEquals(verification.verifyRequiredFieldErrormessage(), "Item is required");
	}

}
