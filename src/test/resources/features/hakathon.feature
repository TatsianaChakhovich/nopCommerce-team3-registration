@nopCommerce
  Feature: Registration

    Background:
      Given I open "nopCommerce" web application
      Then I should see the page title as "Your store. Home page title"
      When I go to "Register" page


    @nopCommerce1
    Scenario: Verify First Name field behavior
      When I verify "First name" field is required
      When I click "Register" btn
      Then Error message "First name is required" should be displayed next to First name field
      When I enter "John" into First name field
      And I click "Register" btn
      Then Error message "First name is required" should  not be displayed next to First name field

    @nopCommerce2
    Scenario: Verify Last Name field behavior
      When I verify "Last name" field is required
      When I click "Register" btn
      Then Error message "Last name is required" should be displayed next to Last name field
      When I enter "Doe" into Last name field
      And I click "Register" btn
      Then Error message "Last name is required" should  not be displayed next to Last name field

    @nopCommerce3
    Scenario Outline: Verify Email field behavior
      When I verify "Email" field is required
      When I click "Register" btn
      Then Error message "Email is required" should be displayed next to Email field
      When I enter wrong format of email <wrongEmail> into email field
      Then Error message "Wrong email" should be displayed next to Email field
      When I clear "Email" field
      When I enter "test@gmail.com" into Email field
      And I click "Register" btn
      Then Error message "Email is required" should  not be displayed next to Email field
      Examples:
        | wrongEmail      |
        | "@gmail.com"    |
        | "test.com"      |
        | "test@.com"     |
        | "test@gmailcom" |
        | "test@gmail."   |

      @nopCommerce4
      Scenario: Verify Password and Confirm Password fields behavior
        When I verify "Password" field is required
        And I verify "Confirm password" field is required
        When I enter "11" into Password field
        And I click "Register" btn
        Then Error message "Must have at least 6 characters" is displayed next to Password field
        When I clear "Password" field
        Then Error message "Password is required" should be displayed next to Password field
        When I enter "123456" into Password field
        Then Error message "Must have at least 6 characters" is not displayed next to Password field
        When I click "Register" btn
        Then Error message "Password is required" should be displayed next to Confirm password field
        When I enter "12" into Confirm password field
        Then Error message "The password and confirmation password do not match" should be displayed next to Confirm password field
        And I clear "ConfirmPassword" field
        When I enter "654321" into Confirm password field
        Then Error message "The password and confirmation password do not match" should be displayed next to Confirm password field
        And I clear "ConfirmPassword" field
        When I enter "123456" into Confirm password field
        Then Error message "The password and confirmation password do not match" should  not be displayed next to Confirm password field

    @nopCommerce5
    Scenario Outline: Verify that user is able to register to the application
      When I select the Gender as <gender>
      When I enter <firstName> into First name field
      And I enter <lastName> into Last name field
      When I select <day>, <month>, <year> for Date of birth
      When I enter <email> into Email field
      And I enter <companyName> into Company name field
      When I uncheck Newsletter checkbox
      And I enter <password> into Password field
      When I enter <confPassword> into Confirm password field
      And I click "Register" btn
      Then I verify that user is logged in
      Examples:
        | gender   | firstName | lastName | day | month     | year | email                      | companyName | password   | confPassword |
        | "male"   | "Ivan"    | "Ivanov" | 20  | "June"    | 1985 | "ivanov@gmail.com"    | "Apple"     | "123456"   | "123456"     |
        | "female" | "Hanna"   | "Smith"  | 1   | "January" | 2001 | "hs-24745@yahoo.com"  | "Td&55"     | "Gg56*$@!" | "Gg56*$@!"   |

    @nopCommerce6
    Scenario: Verify that user is not able to register twice using the same email
      When I enter "Ben" into First name field
      And I enter "Jonson" into Last name field
      When I enter "ivanov@gmail.com" into Email field
      And I enter "Aa111222" into Password field
      When I enter "Aa111222" into Confirm password field
      And I click "Register" btn
      Then Error message "The specified email already exists" is displayed


