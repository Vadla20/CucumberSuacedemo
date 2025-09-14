Feature: Verification Module

  Background: User Signup
    When Login in the healthapp application

  @TC_1
  Scenario: Verify to filter the records by Select active drop down from Requisition Status
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Choose the date from Jan 2020 to March 2024
    And Click on OK button
    And Choose "active" option from requistion status dropdown
    Then Verify that the choosen option is 'active'

  @TC_2
  Scenario: Verify the presence of view button
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on the "all" Radio button from List by Verification Status
    And Choose "active" option from requistion status dropdown
    And Choose the date from Jan 2020 to March 2024
    And Click on OK button
    And Fetch the requisition Id & Click on View button from the first row of requisition data
    Then Verify the requisition Id

  @TC_3
  Scenario: Verify Record Count Matches in Purchase Request
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Purchase Request" under "Inventory"
    And Choose the date from Jan 2020 to March 2024
    And Click on the "all" Radio button from List by Verification Status
    And Click on OK button
    Then Fetch the total count and check if it matches with total items displayed

  @TC_4
  Scenario: Verify scrolling of page
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Purchase Request" under "Inventory"
    Then Verify Pending radio button is visible
    And Scroll all the way to the bottom of the page
    Then Verify Previous button is visible
    And Scroll all the way to the top of the page
    Then Verify Pending radio button is visible

  @TC_5
  Scenario: Verify the required "Item" field in the Purchase Request section under the Inventory module.
    Given Scroll & click till "Verification" menu on the side bar.
    Given Navigate to the Internal section under Inventory
    And Click on Purchase Request
    And Click on the Create Purchase Request button
    And Click on the Request button
    Then Verify error message as "Item is required" is displayed
