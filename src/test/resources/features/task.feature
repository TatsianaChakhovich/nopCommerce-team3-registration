@task
Feature: Smoke test

  @task1
  Scenario: Registration page
    Given I navigate to "automationexercise" page TC
    Then I should see page title as "Automation Exercise" TC
    And I wait for element with xpath "//*[@id='header']" to be present
    When I click on "Signup" button TC
    Then Element with text "New user signup" should be displayed TC
    When I fill the form with name "Anna Smith" and email address "angvzxhvjbz@gmail.com" TC
    And I submit the form TC
    Then I wait for 2 sec
    Then element with xpath "//div[@class='login-form']/h2/b" should have text as "Enter Account Information" TC
    When I fill the form with title "Mrs", password "12345Aa!", date of birth including day "5", month "January", year "1990" TC
    And I check "Sign up for our newsletter" checkbox TC
    When I check "Receive special offers from our partners" checkbox TC
    And I enter "Anna" into First name field TC
    When I enter "Smith" into Last name field TC
    And I enter "Apple" into Company field TC
    When I enter "CA, 294000, Apple, b.1" into Address field TC
    And I enter "United States" into Country field TC
    When I enter "CA" into State field TC
    And I enter "Palo Alto" into City field TC
    When I enter "93444" into Zip code field TC
    And I enter "+9253333333" into Mobile Number field TC
    When I click on "Create Account" button TC
    And I verify that account was "created" TC
    When I click on "Continue" button TC
    And I wait for 2 sec
    When I refresh the page
    And I wait for 2 sec
    When I click on "Continue" button TC
    And I wait for 2 sec
    Then I verify that I'm logged in as "Anna Smith" TC
    When I click on "Delete Account" button TC
    Then I verify that account was "deleted" TC
    When I click on "Continue" button TC
    