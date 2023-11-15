@webDriver
Feature: WebDriver Methods

  @webDriver1
  Scenario: Method - Navigate
    Given I go to "google"
    Then I print page details
    When I go to "yahoo"
    Then I print page details
    And I go back, forward and refresh
    And I wait for 2 sec

  @webDriver2
  Scenario: URL - concatination
    Given I open "google", "yahoo" and "bing"

  @webDriver3
  Scenario: Sample Page - Email
    Given I go to "sample"
    When I type "incorrect" into email field
    And I submit the form
    And I wait for 1 sec
    Then email error message is displayed
    Then email error "Please enter a valid email address." is displayed
    And I clear email field
    Then email error "This field is required." is displayed
    When I type "abc@xyz.com" into email field
    And I wait for 1 sec
    Then email error message is not displayed

#  @webDriver4
#  Scenario Outline: Sample Page - Email OUTLINE
#    Given I go to "sample"
#    When I type <email> into email field
#    And I submit the form
#    And I wait for 1 sec
#    Then email error message is displayed
#    Then email error <expectedError> is displayed
#    Examples:
#      | email | expectedError                         |
#      | "abc" | "Please enter a valid email address." |
#      | ""    | "This field is required."             |

  @webDriver5
  Scenario: Sample Page - Username
    Given I go to "sample"
    When I type "a" into username field
    And I submit the form
    Then username error message is displayed
    Then username error "Please enter at least 2 characters." is displayed
    And I wait for 1 sec
    And I clear username field
    And I wait for 1 sec
    Then username error "This field is required." is displayed
    When I type "anna" into username field
    Then username error message is not displayed

  @webDriver6
  Scenario: Sample Page - Password, Confirm Password
    Given I go to "sample"
    Then confirm password field should be disabled
    When I type "12" into password field
    And I submit the form
    Then password error message is displayed
    Then password error "Please enter at least 5 characters." is displayed
    When I clear password field
    Then password error "This field is required." is displayed
    When I type "12345" into password field
    Then password error message is not displayed
    And password is masked
    When I type "12" into confirm password field
    And I submit the form
    Then confirm password error message is displayed
    Then confirm password error "Please enter at least 5 characters." is displayed
    When I clear confirm password field
    Then confirm password error "This field is required." is displayed
    When I type "54321" into confirm password field
    Then confirm password error "Passwords do not match!" is displayed
    When I clear confirm password field
    When I type "12345" into confirm password field
    And confirm password is masked
    Then confirm password error message is not displayed

  @webDiver7
  Scenario: Sample Page - Name
    Given I go to "sample"
    When I submit the form
    Then name error message is displayed
    Then name error "This field is required." is displayed
    When I click on name field
    And I type "Anna" into first name field
    When I type "Maria" into middle name field
    And I type "Smith" into last name field
    When I click save button
    And name "Anna Maria Smith" is displayed
    When I submit the form
    Then name error message is not displayed


  @webDriver8
  Scenario: Sample Page - Privacy Policy
    Given I go to "sample"
    When I submit the form
    And I wait for 2 sec
    Then checkbox error message is displayed
    And checkbox error "- Must check!" is displayed
    And I wait for 2 sec
    When I accept Privacy Policy
    Then checkbox error message is not displayed

  @webDriver9
  Scenario: Sample Page - Submit
    Given I go to "sample"
    When I type "anna" into username field
    And I type "ams@gmail.com" into email field
    When I type "12345" into password field
    And I type "12345" into confirm password field
    When I click on name field
    And I type "Anna" into first name field
    When I type "Maria" into middle name field
    And I type "Smith" into last name field
    When I click save button
    And I accept Privacy Policy
    When I submit the form
    Then "Submitted sample form data" title is displayed
    And username "anna" is displayed on submitted page
    Then email "ams@gmail.com" is displayed on submitted page
    And name "Anna Maria Smith" is displayed on submitted page
    Then password is masked on submitted page
    And Agreed to Privacy Policy is "true"
    And I wait for 2 sec





