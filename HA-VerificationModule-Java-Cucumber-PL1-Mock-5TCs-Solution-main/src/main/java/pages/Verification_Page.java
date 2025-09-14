package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Verification_Page extends StartupPage {

	public Verification_Page(WebDriver driver) {
		super(driver);
	}
	
	public By getReqStatus() {
		return By.cssSelector("div[ref='eCenterContainer'] div[col-id='RequisitionStatus']");
	}
	public By getRequisitionNumberLocatorFromTheReport() {
		return By.xpath("//div[text()='Requisition No:']/b");
	}
	private By emailInput = By.cssSelector("input#username_id");
	private By passwordInput = By.cssSelector("#password");
	private By signInButton = By.cssSelector("#login");
	public By getVerificationLocator() {
		return By.xpath("//a[@href='#/Verification']");
	}
	
	public By calendarFromDropdown() {
		return By.xpath("(//input[@id='date'])[1]");
	}

	public By calendarToDropdown() {
		return By.xpath("(//input[@id='date'])[2]");
	}

	public By getOkButtonLocator() {
		return By.xpath("//button[@class='btn green btn-success']");
	}
	
	public By verifyRequisitionDropdown() {
		return By.xpath("//div[contains(text(),'Requisition Status:')]/../div/select");
	}
	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}
	public By getRadioButtonsLocator(String radioButtonName) {
		return By.xpath("//input[@value='" + radioButtonName + "']/../span");
	}
	public By getRequisitionNumberLocatorsForAllRequisitions() {
		return By.xpath("//div[@col-id='RequisitionNo' and @role='gridcell']");
	}
	public By getResultCountLocator() {
		return By.cssSelector("div[class='page-items']");
	}
	public By getTotalRecordCount() {
		return By.cssSelector("span[ref='eSummaryPanel'] span[ref='lbRecordCount']");
	}
//
	public By getButtonLocatorsBytext(String buttonName) {
		return By.xpath("//button[contains(text(),'" + buttonName + "')]");
	}

	public By getInventoryLocator() {
		return By.xpath("//a[@href='#/Inventory']");
	}
//
	public By getInventoryPageBarFixedLocator(String navBarName) {
		return By.xpath("//ul[contains(@class,'page-breadcrumb')]/li/a[@href='#/Inventory/" + navBarName + "']");
	}
//
	public By getSubNavTabLocator(String subNavName) {
		return By.xpath("//div[@class=\"sub-navtab\"]/ul/li/a[text()='" + subNavName + "']");
	}
//
	public By getLocatorById(String idName) {
		return By.id(idName);
	}

	public By getItemNameRequiredMsg() {
		return By.xpath("//div[contains(text(),'Item is required')]");
	}
	

	/**
	 * @Test1.1 @Test2.1 @Test3.1 @Test4.1 @Test5.1
	 * About this method login()
	 *
	 * @param : null
	 * @description : This method performs the login action by entering the email,
	 *              password, and clicking the sign-in button.
	 * @return : void
	 * @throws : Exception - if there is an issue interacting with the email input,
	 *           password input, or sign-in button.
	 */

	public void login() throws InterruptedException {

		driver.findElement(emailInput).sendKeys("admin");
		driver.findElement(passwordInput).sendKeys("pass123");
		driver.findElement(signInButton).click();
		Thread.sleep(5000);
	}
	
	/**
	 * @Test1.2 @Test2.2 @Test3.2 @Test4.2 @Test5.2
	 * about this method openVerificationMenu() *
	 * 
	 * @param : null
	 * @description : This method scrolls to the verification menu using JavaScript
	 *              and clicks on it.
	 * @return : void
	 * @throws : Exception - if there is an issue locating, scrolling to, or
	 *           clicking the verification menu.
	 */

	public boolean openVerificationMenu() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement verificationTab = driver.findElement(getVerificationLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
			verificationTab.click();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test1.3 @Test2.3 @Test3.3 @Test4.3 @Test5.3 
	 * about this method successfullNavigation(String module)
	 *
	 * @param : module - The expected substring to verify in the current URL.
	 * @description : This method verifies that the current URL contains the
	 *              specified module substring after navigation and logs the result.
	 * @return : void
	 * @throws : InterruptedException - if the thread sleep is interrupted.
	 *           AssertionError - if the expected substring is not found in the URL.
	 */

	public boolean successfullNavigation(String module) throws InterruptedException {
		// Get the current URL
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();

		// Substring to verify
		String expectedSubstring = module;
		System.out.println("This is the current URL: " + currentURL);

		// Verify the substring
		if (currentURL.contains(expectedSubstring)) {
			System.out.println("URL contains the expected substring: " + expectedSubstring);
			return true;
		} else {
			Assert.fail("URL does not contain the expected substring: " + expectedSubstring);
			return false; // This won't be reached due to Assert.fail()
		}
	}
	
	
	/**
	 * @Test1.4  @Test2.6 @Test3.5  about this method chooseDate(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in the format "DD-MM-YYYY". toDate - The
	 *          end date in the format "DD-MM-YYYY".
	 * @description : This method sets the "from" and "to" dates by locating and
	 *              interacting with date dropdowns.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or interacting with the
	 *           date dropdowns or buttons.
	 */
	
	public boolean chooseDate(String fromDate, String toDate) {
		try {
			System.out.println("From Date: " + fromDate + ", To Date: " + toDate);

			String[] fromDateComponents = fromDate.split("-");
			String fromDay = fromDateComponents[0];
			String fromMonth = fromDateComponents[1];
			String fromYear = fromDateComponents[2];

			String[] toDateComponents = toDate.split("-");
			String toDay = toDateComponents[0];
			String toMonth = toDateComponents[1];
			String toYear = toDateComponents[2];

			// Locate the date dropdowns and OK button
			WebElement fromDateDropdown = driver.findElement(calendarFromDropdown());
			WebElement toDateDropdown = driver.findElement(calendarToDropdown());
			WebElement okButton = driver.findElement(getOkButtonLocator());

			// Highlight and set the "from" date
			fromDateDropdown.sendKeys(fromDay);
			fromDateDropdown.sendKeys(fromMonth);
			fromDateDropdown.sendKeys(fromYear);

			// Highlight and set the "to" date
			toDateDropdown.sendKeys(toDay);
			toDateDropdown.sendKeys(toMonth);
			toDateDropdown.sendKeys(toYear);

			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test1.5 @Test2.7 @Test3.7 about this method clickOkButton()
	 *
	 * @param : null
	 * @description : This method locates and clicks the "OK" button.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the "OK"
	 *           button.
	 */
	
	public boolean clickOkButton() {
		try {
			WebElement okButton = driver.findElement(getOkButtonLocator());
			okButton.click();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test1.6 @Test2.5
	 * about this method chooseReqStatus()
	 *
	 * @param status : The value to be selected from the requisition status dropdown.
	 * @description : This method locates the requisition status dropdown, selects the
	 *                provided status value, and waits for 10 seconds to allow any resulting
	 *                changes to take effect.
	 * @return : boolean - true if the status is selected successfully.
	 * @throws : Exception - if an error occurs while locating the dropdown or selecting the value.
	 */
	
	public boolean chooseReqStatus(String status) throws Exception {
		try {
			WebElement dropdownElement = driver.findElement(verifyRequisitionDropdown());
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByValue(status);

			System.out.println("Selected the '" + status + "' option from the dropdown.");
			Thread.sleep(10000);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test1.7
	 * about this method verifyReqStatus()
	 *
	 * @param status : The expected status to validate against each displayed requisition status.
	 * @description : This method retrieves all requisition status elements from the page and verifies
	 *                that each one matches the expected status (case-insensitive). If a mismatch is found,
	 *                the test fails and the method returns false.
	 * @return : boolean - true if all requisition statuses match the expected value; false otherwise.
	 * @throws : Exception - if there is an error locating the elements or during status comparison.
	 */

	
	public boolean verifyReqStatus(String status) {
		try {
			List<WebElement> reqStatus = driver.findElements(getReqStatus());
			System.out.println("Number of requisition status records: " + reqStatus.size());

			if (reqStatus.isEmpty()) {
				System.out.println("No requisition status records found.");
				return false;
			}

			for (WebElement statusElement : reqStatus) {
				String statusText = statusElement.getText().trim();
				if (!statusText.equalsIgnoreCase(status)) {
					Assert.fail("Found a status that is not '" + status + "': " + statusText);
					return false;
				}
			}
			System.out.println("All requisition statuses are '" + status + "'.");
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/**
	 * @Test2.4 @Test3.6
	 * about this method selectRadioButton(String radioButtonText)
	 *
	 * @param : radioButtonText - The text associated with the radio button to be
	 *          selected.
	 * @description : This method locates and clicks on a radio button based on the
	 *              provided text.
	 * @return : boolean - Returns true if the radio button is successfully clicked.
	 * @throws : Exception - if there is an issue locating or clicking the radio
	 *           button.
	 */
	public boolean selectRadioButton(String radioButtonText) {
		try {
			WebElement radioButtonToClick = driver.findElement(getRadioButtonsLocator(radioButtonText));
			radioButtonToClick.click();
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
	
	/**
	 * @Test2.8
	 * about this method fetchReqNum()
	 *
	 * @param : null
	 * @description : This method retrieves the list of all requisition numbers, extracts the
	 *                first one as the expected requisition number, clicks the corresponding
	 *                "View" button, and returns the requisition number.
	 * @return : String - the expected requisition number extracted from the list.
	 * @throws : None explicitly, but may throw runtime exceptions if elements are not found.
	 */
	
	public String fetchReqNum() {
		List<WebElement> allRequisionNumbers = driver.findElements(getRequisitionNumberLocatorsForAllRequisitions());
		String expectedRequisitionNumber = allRequisionNumbers.get(0).getText();
		List<WebElement> viewButtonsLocators = driver.findElements(getAnchorTagLocatorByText("View"));
		viewButtonsLocators.get(0).click();
		System.out.println("This is the expected requisition num: " + expectedRequisitionNumber);
		return expectedRequisitionNumber;
	}
	
	/**
	 * @Test2.9
	 * about this method verifyReqNum()
	 *
	 * @param expectedReqNumber : The requisition number expected to appear in the report.
	 * @description : This method fetches the actual requisition number displayed in the report,
	 *                compares it with the expected value, and returns true if they match. If not,
	 *                the test fails and returns false.
	 * @return : boolean - true if the actual requisition number matches the expected one; false otherwise.
	 * @throws : Exception - if there is an error locating or retrieving the requisition number element.
	 */

	
	public boolean verifyReqNum(String expectedReqNumber) {
	try {
		String actualRequisitionNumber = driver.findElement(getRequisitionNumberLocatorFromTheReport()).getText()
				.trim();
		System.out.println("Actual requisition number: " + actualRequisitionNumber);

		if (expectedReqNumber.equals(actualRequisitionNumber)) {
			return true;
		} else {
			Assert.fail("Expected requisition number: " + expectedReqNumber + ", but found: "
					+ actualRequisitionNumber);
			return false;
		}
	} catch (Exception e) {
		throw e;
	}
}
	
	
	/**
	 * @Test3.9
	 * about this method verifyCount()
	 *
	 * @param : null
	 * @description : This method compares the number of results displayed on the page with the total
	 *                record count. It fetches both counts, parses them to integers, and verifies
	 *                whether they match. If they do, it returns true; otherwise, it fails the test.
	 * @return : boolean - true if the shown result count matches the total record count, false otherwise.
	 * @throws : Exception - if there is an issue locating elements, parsing numbers, or during comparison.
	 */
	public boolean verifyCount() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement resultCountElement = driver.findElement(getResultCountLocator());
			String resultCountText = resultCountElement.getText();
			System.out.println("Result count text: " + resultCountText);

			String[] actualResultCount = resultCountText.split(" ");
			String actualResultCountText = actualResultCount[3];

			WebElement totalRecords = driver.findElement(getTotalRecordCount());
			String expectedTotalRecordsCount = totalRecords.getText();

			int shownResultCount = Integer.parseInt(actualResultCountText);
			int totalRecordCount = Integer.parseInt(expectedTotalRecordsCount);

			System.out.println("Shown Result Count: " + shownResultCount);
			System.out.println("Total Record Count: " + totalRecordCount);

			if (shownResultCount == totalRecordCount) {
				return true;
			} else {
				Assert.fail("Mismatch in counts: Shown - " + shownResultCount + ", Expected - " + totalRecordCount);
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/**
	 * @Test3.4 @Test4.4 this method
	 * clickOnButtonByText(String text)
	 *
	 * @param : text - The text of the button to be clicked.
	 * @description : This method locates a button with the specified text and
	 *              performs a click action on it.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the button.
	 */
	
	public boolean clickOnButtonByText(String text) {
		try {
			WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
			element.click();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test4.5
	 * about this method scrollAllTheWayDown()
	 *
	 * @param : null
	 * @description : This method uses JavaScript to scroll the webpage to the bottom of the page.
	 * @return : boolean - true if the scroll operation is executed successfully.
	 * @throws : Exception - if an error occurs during the execution of the scroll script.
	 */
	
	public boolean scrollAllTheWayDown() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			return true;

		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test4.6
	 * about this method isPreviousButtonVisible()
	 *
	 * @param : null
	 * @description : This method locates the "Previous" button on the page, highlights it for visibility,
	 *                and checks whether it is displayed.
	 * @return : boolean - true if the "Previous" button is visible; false otherwise.
	 * @throws : Exception - if there is an error in locating, highlighting, or checking the visibility of the button.
	 */
	public boolean isPreviousButtonVisible() throws Exception {
		try {
			WebElement previousButton = commonEvents.findElement(getButtonLocatorsBytext("Previous"));
			commonEvents.highlight(previousButton);
			return commonEvents.isDisplayed(previousButton);

		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test4.7
	 * about this method scrollAllTheWayUp()
	 *
	 * @param : null
	 * @description : This method uses JavaScript to scroll the webpage to the top of the page.
	 * @return : boolean - true if the scroll operation is executed successfully.
	 * @throws : Exception - if an error occurs during the execution of the scroll script.
	 */
	
	public boolean scrollAllTheWayUp() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
			return true;

		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test4.4 @Test4.8
	 * about this method isPendingRadioButtonVisible()
	 *
	 * @param : null
	 * @description : This method locates the "Pending" radio button, highlights it for visibility,
	 *                and checks whether it is displayed on the page.
	 * @return : boolean - true if the "Pending" radio button is visible; false otherwise.
	 * @throws : Exception - if there is an error in locating, highlighting, or checking the visibility of the radio button.
	 */
	
	public boolean isPendingRadioButtonVisible() throws Exception {
		try {
			WebElement pendingRadioButton = commonEvents.findElement(getRadioButtonsLocator("pending"));
			commonEvents.highlight(pendingRadioButton);
			return commonEvents.isDisplayed(pendingRadioButton);

		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/**
	 * @Test5.4
	 * about this method clickOnInventory()
	 *
	 * @param : null
	 * @description : This method scrolls to the "Inventory" tab using JavaScript, highlights and clicks it.
	 *                Then, it locates the "InternalMain" tab within the inventory page and clicks it as well.
	 * @return : boolean - true if both clicks (Inventory and InternalMain tabs) are successful.
	 * @throws : RuntimeException - if any error occurs during locating, scrolling, highlighting, or clicking elements.
	 */
	public boolean clickOnInventory() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement inventoryTab = commonEvents.findElement(getInventoryLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", inventoryTab);
			commonEvents.highlight(inventoryTab).click(inventoryTab);

			WebElement internalTab = commonEvents.findElement(getInventoryPageBarFixedLocator("InternalMain"));
			commonEvents.highlight(internalTab).click(internalTab);

			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Inventory tab.", e);
		}
	}

	
	/**
	 * @Test5.5
	 * about this method clickOnPurchaseRequest()
	 *
	 * @param : null
	 * @description : This method locates the "Purchase Request" tab in the sub-navigation menu,
	 *                highlights it, and performs a click action.
	 * @return : boolean - true if the click on the "Purchase Request" tab is successful.
	 * @throws : RuntimeException - if an error occurs while locating, highlighting, or clicking the tab.
	 */
	
	public boolean clickOnPurchaseRequest() {
		try {
			WebElement purchaseRequestTab = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
			commonEvents.highlight(purchaseRequestTab).click(purchaseRequestTab);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Purchase Request tab.", e);
		}
	}

	/**
	 * @Test5.6
	 * about this method clickOnCreatePurchaseRequestButton()
	 *
	 * @param : null
	 * @description : This method locates the "Create Purchase Request" button, highlights it,
	 *                and performs a click action.
	 * @return : boolean - true if the click on the "Create Purchase Request" button is successful.
	 * @throws : RuntimeException - if an error occurs while locating, highlighting, or clicking the button.
	 */
	
	public boolean clickOnCreatePurchaseRequestButton() {
		try {
			WebElement purchaseRequestButton = commonEvents
					.findElement(getButtonLocatorsBytext("Create Purchase Request"));
			commonEvents.highlight(purchaseRequestButton).click(purchaseRequestButton);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Create Purchase Request button.", e);
		}
	}
	
	/**
	 * @Test5.7
	 * about this method clickOnRequestButton()
	 *
	 * @param : null
	 * @description : This method locates the "Request PO Requisition" button using its ID,
	 *                highlights it, and performs a click action.
	 * @return : boolean - true if the click on the "Request PO Requisition" button is successful.
	 * @throws : RuntimeException - if an error occurs while locating, highlighting, or clicking the button.
	 */

	public boolean clickOnRequestButton() {
		try {
			WebElement requestPORequisition = commonEvents.findElement(getLocatorById("RequestPORequisition"));
			commonEvents.highlight(requestPORequisition).click(requestPORequisition);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Request PO Requisition button.", e);
		}
	}
	
	/**
	 * @Test5.8
	 * about this method verifyRequiredFieldErrormessage()
	 *
	 * @param : null
	 * @description : This method locates the required-field validation message for the
	 *                “Item Name” field, captures its text, and returns it to the caller.
	 * @return : String – the validation error message text displayed for the “Item Name” field;
	 *                     returns an empty string if the message element is not found.
	 * @throws : None explicitly, but may propagate unchecked exceptions if locating the
	 *           validation message element fails.
	 */

	public String verifyRequiredFieldErrormessage() {
		String itemNameMessageText = "";
		try {

			WebElement itemNameMessageElement = commonEvents.findElement(getItemNameRequiredMsg());
			System.out.println("Item Name message text : " + itemNameMessageElement.getText());
			itemNameMessageText = itemNameMessageElement.getText();

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return itemNameMessageText;
	}

}
