Feature: Calculating the factorial numbers

  Background:
    Given User is on the specified web page

  Scenario: Verifying the Title
    When user is on the page
    Then user sees "Factorial" in the title


  Scenario: Find the factorial of 5 using the Calculate button
    When user enters "5" into the input box
    And user clicks Calculate
    Then user should be able to see "The factorial of 5 is: 120" displayed

  Scenario: Find the factorial of 5 using the Enter key
    When user enters "5" into the input box
    And user hits enter key on keyboard
    Then user should be able to see "The factorial of 5 is: 120" displayed


  Scenario: Error message should be displayed if anything other than integer is entered
    When user enters a character
    And user clicks Calculate
    Then user should be able to see the error message displayed


  Scenario: Find the factorial of four digit integers
    When user enters four digit integer
    And user clicks Calculate
    Then user should be able to see the result displayed


  Scenario: Open Privacy link
    When user clicks on Privacy link
    Then user should be taken to the Privacy page


  Scenario: Open Terms and Conditions page
    When user clicks on Terms and Conditions link
    Then user should be taken to the Terms and Conditions page

  Scenario: API post request
    When user sends a post request using Content type

