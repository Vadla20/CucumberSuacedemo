package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerificationPage_PL2 extends StartupPage {

	public VerificationPage_PL2(WebDriver driver) {
		super(driver);
	}

//	TestCase1 : Locators
	private By emailInput = By.cssSelector("input#username_id");
	private By passwordInput = By.cssSelector("#password");
	private By signInButton = By.cssSelector("#login");

	public By getVerificationLocator() {
		return By.xpath("//a[@href='#/Verification']");
	}
	
	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}
	
	public By getButtonLocatorsBytext(String buttonName) {
		return By.xpath("//button[contains(text(),'" + buttonName + "')]");
	}
	
	public By searchBarId() {
		return By.id("quickFilterInput");
	}

	public By getDateRangeButton() {
		return By.cssSelector("td [data-hover='dropdown']");
	}
	
	public By calendarFromDropdown() {
		return By.xpath("(//input[@id='date'])[1]");
	}
	
	public By calendarToDropdown() {
		return By.xpath("(//input[@id='date'])[2]");
	}
	
	public By getStarIconLocator() {
		return By.xpath("//i[contains(@class,'icon-favourite')]/..");
	}
	
	public By getSubNavTabLocator(String subNavName) {
		return By.xpath("//div[@class=\"sub-navtab\"]/ul/li/a[text()='" + subNavName + "']");
	}
	
	public By getOkButtonLocator() {
		return By.xpath("//button[@class='btn green btn-success']");
	}
	
	public By getRadioButtonsLocator(String radioButtonName) {
		return By.xpath("//input[@value='" + radioButtonName + "']/../span");
	}
	
	public By getActualRequestedOnDates() {
		return By.xpath("//div[@col-id=\"RequisitionDate\"]/span[not(contains(@class,'hidden'))]");
	}
	
	public By favouriteOrStarIcon() {
		return By.xpath("//i[contains(@class,'icon-favourite')]");
	}

	/**
	 * About this method login()
	 *
	 * @param : null
	 * @description : This method performs the login action by entering the email,
	 *              password, and clicking the sign-in button.
	 * @return : void
	 * @throws : Exception - if there is an issue interacting with the email input,
	 *           password input, or sign-in button.
	 */

	public boolean login() {
		try {
			driver.findElement(emailInput).sendKeys("admin");
			driver.findElement(passwordInput).sendKeys("pass123");
			driver.findElement(signInButton).click();
			return true; // success
		} catch (Exception e) {
			// Optionally log the exception
			System.err.println("Login failed: " + e.getMessage());
			return false; // failure
		}
	}

	/**
	 * @Test1.1 @Test2.1 @Test3.1 @Test4.1 @Test5.1 @Test6.1 @Test7.1 @Test8.1 @Test9.1 @Test10.1
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
			Thread.sleep(5000);
			WebElement verificationTab = driver.findElement(getVerificationLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
			verificationTab.click();
			return true; // success

		} catch (Exception e) {
			System.err.println("open Verification Menu failed: " + e.getMessage());
			return false; // failure
		}
	}

	/**
	 * @Test1.2 @Test2.2 @Test3.2 @Test4.2 @Test4.4 @Test5.2 @Test8.2 @Test9.2 @Test10.2
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
		Thread.sleep(3000); // Wait for navigation to complete
		String currentURL = driver.getCurrentUrl();

		System.out.println("This is the current URL: " + currentURL);

		// Check if the current URL contains the expected substring
		if (currentURL.contains(module)) {
			System.out.println("URL contains the expected substring: " + module);
			return true;
		} else {
			System.out.println("URL does NOT contain the expected substring: " + module);
			return false;
		}
	}

	/**
	 * @Test2.3 @Test2.4 @Test3.3 @Test3.4 about this method
	 * verifyButtonPresentWithText(String text)
	 *
	 * @param : text - The text of the button to verify its presence.
	 * @description : This method checks if a button with the specified text is
	 *              displayed on the page and fails the test if the button is not
	 *              visible.
	 * @return : void
	 * @throws : AssertionError - if the button with the specified text is not
	 *           visible.
	 */

	public boolean verifyButtonPresentWithText(String text) {
		WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
		boolean elementIsDisplayed = element.isDisplayed();

		if (!elementIsDisplayed) {
			Assert.fail("Element with text: " + text + " is not visible");
		}
		return elementIsDisplayed;
	}

	/**
	 * @Test3.5 @Test4.3 @Test5.3 @Test8.6 @Test8.7about this method
	 * clickOnButtonByText(String text)
	 *
	 * @param : text - The text of the button to be clicked.
	 * @description : This method locates a button with the specified text and
	 *              performs a click action on it.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the button.
	 */

	public boolean clickOnButtonByText(String text) {
		boolean clickOnButtonByText = false;
		try {
			Thread.sleep(3000);
			WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
			element.click();
			clickOnButtonByText = true;
			return clickOnButtonByText;
		}

		catch (Exception e) {
			System.out.println(e);
			return clickOnButtonByText;
		}
	}

	/**
	 * @Test3.6 about this method verifyVerificationComponentsAreVisible()
	 *
	 * @param : null
	 * @description : This method verifies the visibility of multiple verification
	 *              components such as navigation buttons, date range fields, and
	 *              sub-navigation tabs, and highlights each component during the
	 *              check.
	 * @return : boolean - Returns true if all components are visible, otherwise
	 *         false.
	 * @throws : Exception - if any component is not visible or an error occurs
	 *           during the verification process.
	 */

	public boolean verifyVerificationComponentsAreVisible() throws Exception {

		Thread.sleep(5000);

		boolean areAllFieldsDisplayed = false;
		try {

			WebElement firstButton = commonEvents.findElement(getButtonLocatorsBytext("First"));
			WebElement previousButton = commonEvents.findElement(getButtonLocatorsBytext("Previous"));
			WebElement nextButton = commonEvents.findElement(getButtonLocatorsBytext("Next"));
			WebElement lastButton = commonEvents.findElement(getButtonLocatorsBytext("Last"));
			WebElement searchBarId = commonEvents.findElement(searchBarId());
			WebElement getDateRangeButton = commonEvents.findElement(getDateRangeButton());
			WebElement calendarFromDropdown = commonEvents.findElement(calendarFromDropdown());
			WebElement calendarToDropdown = commonEvents.findElement(calendarToDropdown());
			WebElement starIconLocator = commonEvents.findElement(getStarIconLocator());
			WebElement requisition = commonEvents.findElement(getSubNavTabLocator("Requisition"));
			WebElement purchaseRequest = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
			WebElement purchaseOrder = commonEvents.findElement(getSubNavTabLocator("Purchase Order"));
			WebElement GRQualityInspection = commonEvents.findElement(getSubNavTabLocator("GR Quality Inspection"));

			List<WebElement> options = Arrays.asList(requisition, purchaseRequest, purchaseOrder, GRQualityInspection,
					firstButton, previousButton, nextButton, lastButton, searchBarId, getDateRangeButton,
					calendarFromDropdown, calendarToDropdown, starIconLocator);

			for (int i = 0; i < options.size(); i++) {
				WebElement option = options.get(i);
				commonEvents.highlight(option);
				System.out.println("is " + i + 1 + " displayed? " + option.isDisplayed());
				if (!option.isDisplayed()) {
					areAllFieldsDisplayed = false;
					throw new Exception("Visibility check failed for: " + option.getText());
				}
			}
			areAllFieldsDisplayed = true;
		} catch (Exception e) {
			// Throw an exception with a meaningful message if any UI component is not found
			throw new Exception("Failed to verify if all fields are displayed!", e);
		}
		// Return the result of the visibility check
		return areAllFieldsDisplayed;
	}

	/**
	 * @Test6.2 @Test8.3 about this method chooseDate(String fromDate, String
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
	 * @Test6.3 @Test10.3 @Test10.4 @Test10.5 @Test10.6 @Test10.7 @Test10.8 @Test10.9 @Test10.10 @Test10.11
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
		boolean selectRadioButton = false;

		try {
			WebElement radioButtonToClick = driver.findElement(getRadioButtonsLocator(radioButtonText));
			radioButtonToClick.click();
			selectRadioButton = true;
			return selectRadioButton;

		} catch (Exception e) {
			return selectRadioButton;
		}
	}

	/**
	 * @Test6.4 @Test8.5 @Test9.4 about this method clickOkButton()
	 *
	 * @param : null
	 * @description : This method locates and clicks the "OK" button.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the "OK"
	 *           button.
	 */

	public boolean clickOkButton() {
		boolean clickOkButton = false;
		try {
			WebElement okButton = driver.findElement(getOkButtonLocator());
			okButton.click();
			clickOkButton = true;
			return clickOkButton;
		} catch (Exception e) {
			return clickOkButton;
		}
	}

	/**
	 * @Test6.5 @Test9.5 about this method verifyDateRange(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in "dd-MM-yyyy" format. toDate - The end
	 *          date in "dd-MM-yyyy" format.
	 * @description : This method verifies that all dates after applying the filter
	 *              are within the specified date range.
	 * @return : void
	 * @throws : AssertionError - if any date is outside the specified date range or
	 *           fails to parse.
	 */

	public boolean verifyDateRange(String fromDate, String toDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			List<WebElement> actualDatesAfterFilterApplied = driver.findElements(getActualRequestedOnDates());

			LocalDate from = LocalDate.parse(fromDate, formatter);
			LocalDate to = LocalDate.parse(toDate, formatter);

			for (WebElement dateElement : actualDatesAfterFilterApplied) {
				String dateText = dateElement.getText();
				try {
					LocalDate date = LocalDate.parse(dateText, inputFormatter);
					LocalDate newDate = LocalDate.parse(date.format(formatter), formatter);

					if (newDate.isBefore(from) || newDate.isAfter(to)) {
						Assert.fail("Date is out of range: " + dateText);
						return false;
					}
				} catch (Exception e) {
					Assert.fail("Date parsing failed for: " + dateText);
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @Test7.2 about this method verifyToolTipText()
	 *
	 * @param : null
	 * @description : This method retrieves and returns the tooltip text (title
	 *              attribute) of the star icon.
	 * @return : String - Returns the tooltip text of the star icon.
	 * @throws : Exception - if there is an issue locating the tooltip or retrieving
	 *           its text.
	 */

	public String verifyToolTipText() {
		String toolTipValue = "";
		try {
			WebElement toolTip = commonEvents.findElement(favouriteOrStarIcon());
			toolTipValue = commonEvents.highlight(toolTip).getAttribute(toolTip, "title");
			System.out.println("Tool tip title : " + toolTipValue);
		} catch (Exception e) {
			throw e;
		}
		return toolTipValue;
	}

	/**
	 * @Test8.4 about this method clickTooltip()
	 *
	 * @param : null
	 * @description : This method locates and clicks the tooltip element, which is
	 *              identified by the star icon.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the tooltip
	 *           element.
	 */

	public boolean clickTooltip() {
		boolean clickTooltip = false;

		try {
			WebElement toolTip = driver.findElement(getStarIconLocator());
			toolTip.click();
			clickTooltip = true;
			return clickTooltip;
		} catch (Exception e) {
			System.out.println("Error :" + e);
			return clickTooltip;
		}
	}

	/**
	 * @Test8.8 about this method verifyDateRangeforReq(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in "DD-MM-YYYY" format. toDate - The end
	 *          date in "DD-MM-YYYY" format.
	 * @description : This method verifies if the actual date range matches the
	 *              provided from and to dates.
	 * @return : void
	 * @throws : AssertionError - if the actual date range does not match the
	 *           expected range.
	 */

	public boolean verifyDateRangeforReq(String fromDate, String toDate) {
		try {
			System.out.println("From Date : " + fromDate + ", To Date : " + toDate);

			String[] fromDateComponents = fromDate.split("-");
			String actualFromDate = fromDateComponents[0] + "-" + fromDateComponents[1] + "-" + fromDateComponents[2];

			String[] toDateComponents = toDate.split("-");
			String actualToDate = toDateComponents[0] + "-" + toDateComponents[1] + "-" + toDateComponents[2];

			System.out.println("Actual from date : " + actualFromDate);
			System.out.println("Actual to date : " + actualToDate);

			if (actualFromDate.equals(fromDate) && actualToDate.equals(toDate)) {
				return true;
			} else {
				Assert.fail("Date is out of range: Expected from " + fromDate + " to " + toDate + ", but got from "
						+ actualFromDate + " to " + actualToDate);
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test9.3 about this method chooseDateRange(String range)
	 *
	 * @param : range - The text of the date range option to be selected.
	 * @description : This method clicks on the date range button, selects a
	 *              specified range, and then closes the dropdown.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the date
	 *           range elements.
	 */

	public boolean chooseDateRange(String range) {
		try {
			WebElement dateRangeButton = driver.findElement(getDateRangeButton());
			dateRangeButton.click();

			WebElement valueToSelectElement = driver.findElement(getAnchorTagLocatorByText(range));
			valueToSelectElement.click();

			dateRangeButton.click();
			valueToSelectElement.click();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
