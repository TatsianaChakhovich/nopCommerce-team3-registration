@practice
  Feature: Exercise

    @practice1
    Scenario: Register new user
      Given I go to the "http://automationexercise.com"
      Then I should see page title
      Then I Click on Signup&Login button
      Then New User Signup! should be present
      When Enter name and email address
      Then I click Signup button
      When I verify that ENTER ACCOUNT INFORMATION is visible
      Then I fill out all the details
      Then I select checkbox Sign up for our newsletter!
      Then Select checkbox Receive special offers from our partners!
      Then I fill address information
      Then I click Create Account button
      Then I verify that ACCOUNT CREATED! is visible
      Then Click Continue button
      And I wait for 3 sec
      Then I verify that Logged in as Team2 is visible
      Then Click on Delete Account button
      Then Verify that ACCOUNT DELETED! is visible and click on Continue button

