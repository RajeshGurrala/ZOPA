@GetQuote
Feature: getQuote

  Scenario: User should be able to provide all the valid details before getting a quote
    Given The user is on the home page
    When He navigates to the get_loan page and provides the amount and term time
    Then He should be directed to a secured link where he would be able to provide his personal details
