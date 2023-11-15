@Cucumber
Feature: Practice Writing Cucumber Scenarios

  Background:
    Given I open url "https://skryabin.com/webdriver/html/sample.html"
    Then I should see page title as "Sample Page"

  @cucumber1
  Scenario: Verify Responsive UI Behavior
    And I wait for 1 sec
    When I resize window to 1680 and 1050
    Then element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    When I resize window to 1024 and 768
    Then element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    When I resize window to 375 and 667
    Then element with xpath "//b[@id='currentDate']" should not be displayed
    And element with xpath "//b[@id='location']" should not be displayed
    Then element with xpath "//b[@id='currentTime']" should not be displayed
    And I wait for 2 sec

  @cucumber2
  Scenario:  Verify Username Input Field Behavior
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "at least 2 characters."
    When I clear element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should contain text "This field is required."
    When I type "ann" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed
    And I wait for 2 sec

  @cucumber3
  Scenario: Verify Email Input Field Behavior
    When I type "@" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    Then element with xpath "//label[@id='email-error']" should contain text "enter a valid email address."
    When I clear element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should contain text "This field is required."
    When I type "am@gmail.com" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed
    And I wait for 2 sec

  @cucumber4
  Scenario: Verify Password and Confirm Password Input Fields Behavior
    Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"
    When I type "12" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='password-error']" should be displayed
    Then element with xpath "//label[@id='password-error']" should contain text "at least 5 characters."
    When I clear element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='password-error']" should contain text "This field is required."
    When I type "12345" into element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='password-error']" should not be displayed
    And I wait for 1 sec
    When I type "12" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed
    Then element with xpath "//label[@id='confirmPassword-error']" should contain text "at least 5 characters."
    When I clear element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should contain text "This field is required."
    When I type "54321" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should contain text "Passwords do not match!"
    When I clear element with xpath "//input[@id='confirmPassword']"
    When I type "12345" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed
    And I wait for 2 sec

  @cucumber5
  Scenario: Verify Name Input Field Behavior
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='name-error']" should be displayed
    Then element with xpath "//label[@id='name-error']" should contain text "This field is required."
    When I click on element with xpath "//input[@id='name']"
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    When I type "Maria" into element with xpath "//input[@id='middleName']"
    When I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']/.."
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Anna Maria Smith"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='name-error']" should not be displayed
    And I wait for 2 sec

  @cucumber6
  Scenario: Verify Checkbox Input Field Behavior
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check!"
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed
    And I wait for 2 sec
    
  @cucumber7
  Scenario: Verify Page After Submission
    When I type "ann" into element with xpath "//input[@name='username']"
    And I type "am@gmail.com" into element with xpath "//input[@name='email']"
    When I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//input[@id='name']"
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    When I type "Maria" into element with xpath "//input[@id='middleName']"
    When I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']/.."
    When I type "9259259292" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    When I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Belarus']"
    And I click on element with xpath "//input[@name='gender' and @value='female']"
    When I click on element with xpath "//input[@name='allowedToContact']"
    When I type "1000 Street, Palo Alto, 94000, CA" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    When I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    When I type "01/01/1990" into element with xpath "//input[@id='dateOfBirth']"
    Then I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Ivan Ivanov" into element with xpath "//input[@id='contactPersonName']"
    When I type "9259250000" into element with xpath "//input[@id='contactPersonPhone']"
    Then I switch to default content
    And I wait for 2 sec
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then I wait for element with xpath "//*[@id='samplePageResult']/fieldset/legend" to be present
    And element with xpath "//*[@id='samplePageResult']/fieldset/legend" should contain text "Submitted sample form data"
    Then element with xpath "//b[@name='firstName']" should be displayed
    And element with xpath "//b[@name='firstName']" should have text as "Anna"
    Then element with xpath "//b[@name='middleName']" should be displayed
    And element with xpath "//b[@name='middleName']" should have text as "Maria"
    Then element with xpath "//b[@name='lastName']" should be displayed
    And element with xpath "//b[@name='lastName']" should have text as "Smith"
    Then element with xpath "//b[@name='name']" should be displayed
    And element with xpath "//b[@name='name']" should have text as "Anna Maria Smith"
    Then element with xpath "//b[@name='username']" should be displayed
    And element with xpath "//b[@name='username']" should have text as "ann"
    Then element with xpath "//b[@name='email']" should be displayed
    And element with xpath "//b[@name='email']" should have text as "am@gmail.com"
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should be displayed
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    Then element with xpath "//b[@name='password']" should be displayed
    And element with xpath "//b[@name='password']" should have text as "[entered]"
    Then element with xpath "//b[@name='allowedToContact']" should have text as "true"
    Then element with xpath "//b[@name='thirdPartyAgreement']" should have text as "accepted"
    And I wait for 2 sec


