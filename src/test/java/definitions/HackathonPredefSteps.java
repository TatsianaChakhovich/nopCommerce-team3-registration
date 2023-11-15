package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import support.TestContext;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class HackathonPredefSteps {

    //Background
    @Given("I open {string} web application")
    public void iOpenWebApplication(String url) {
        if (url.equals("nopCommerce")){
            getDriver().get("https://env-jam.portnov.com");
        } else {
            System.out.println("This site can't be reached");
        }
    }
    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }
    @When("I go to {string} page")
    public void iGoToPage(String headerBtn) {
        getDriver().findElement(By.linkText(headerBtn)).click();
    }


    //Verify First Name field behavior
    @When("I verify {string} field is required")
    public void iVerifyFieldIsRequired(String field) {
        assertThat(getDriver().findElement(By.xpath("//label[text()=\"" + field + ":\"]//..//span[@class='required']")).getText()).isEqualTo("*");
    }
    @Then("I click {string} btn")
    public void iClickBtn(String btn) {
        getDriver().findElement(By.id("register-button")).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Then("Error message {string} should be displayed next to First name field")
    public void errorMessageShouldBeDisplayedNextToFirstNameField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='FirstName-error']")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='FirstName-error']")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @When("I enter {string} into First name field")
    public void iEnterIntoFirstNameField(String firstName) {
        getDriver().findElement(By.id("FirstName")).sendKeys(firstName);
    }
    @Then("Error message {string} should  not be displayed next to First name field")
    public void errorMessageShouldNotBeDisplayedNextToFirstNameField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@data-valmsg-for='FirstName']")).getAttribute("class")).isEqualTo("field-validation-valid");
    }

    //Verify Last Name field behavior
    @Then("Error message {string} should be displayed next to Last name field")
    public void errorMessageShouldBeDisplayedNextToLastNameField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='LastName-error']")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='LastName-error']")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @Then("I enter {string} into Last name field")
    public void iEnterIntoLastNameField(String lastName) {
        getDriver().findElement(By.id("LastName")).sendKeys(lastName);
    }
    @Then("Error message {string} should  not be displayed next to Last name field")
    public void errorMessageShouldNotBeDisplayedNextToLastNameField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@data-valmsg-for='LastName']")).getAttribute("class")).isEqualTo("field-validation-valid");
    }

    //Verify Email field behavior
    @Then("Error message {string} should be displayed next to Email field")
    public void errorMessageShouldBeDisplayedNextToEmailField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='Email-error']")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='Email-error']")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @When("I enter {string} into Email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.id("Email")).sendKeys(email);
    }
    @When("I enter wrong format of email {string} into email field")
    public void iEnterWrongFormatOfEmailIntoEmailField(String wrongEmail) {
        getDriver().findElement(By.id("Email")).sendKeys(wrongEmail);
    }
    @When("I clear {string} field")
    public void iClearField(String field) {
        getDriver().findElement(By.id(field)).clear();
    }
    @Then("Error message {string} should  not be displayed next to Email field")
    public void errorMessageShouldNotBeDisplayedNextToEmailField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@data-valmsg-for='Email']")).getAttribute("class")).isEqualTo("field-validation-valid");
    }

    //Verify Password and Confirm Password fields behavior
    @Then("I enter {string} into Password field")
    public void iEnterIntoPasswordField(String password) {
        getDriver().findElement(By.id("Password")).sendKeys(password);
    }
    @Then("Error message {string} is displayed next to Password field")
    public void errorMessageIsDisplayedNextToPasswordField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='Password-error']//li")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='Password-error']//li")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @Then("Error message {string} should be displayed next to Password field")
    public void errorMessageShouldBeDisplayedNextToPasswordField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='Password-error']")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='Password-error']")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @Then("Error message {string} is not displayed next to Password field")
    public void errorMessageIsNotDisplayedNextToPasswordField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@data-valmsg-for='Password']")).getAttribute("class")).isEqualTo("field-validation-valid");
    }
    @Then("Error message {string} should be displayed next to Confirm password field")
    public void errorMessageShouldBeDisplayedNextToConfirmPasswordField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='ConfirmPassword-error']")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
    @When("I enter {string} into Confirm password field")
    public void iEnterIntoConfirmPasswordField(String confPassword) {
        getDriver().findElement(By.id("ConfirmPassword")).sendKeys(confPassword);
    }
    @Then("Error message {string} should  not be displayed next to Confirm password field")
    public void errorMessageShouldNotBeDisplayedNextToConfirmPasswordField(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//span[@data-valmsg-for='ConfirmPassword']")).getAttribute("class")).isEqualTo("field-validation-valid");
    }

    //Verify that user is able to register to the application by filling out all  required fields
    @When("I select the Gender as {string}")
    public void iSelectTheGenderAs(String gender) {
        getDriver().findElement(By.xpath("//input[@id='gender-" + gender + "']")).click();
    }
    @When("I select {int}, {string}, {int} for Date of birth")
    public void iSelectForDateOfBirth(int day, String month, int year) {
        getDriver().findElement(By.xpath("//select[@name='DateOfBirthDay']/*[@value='20']")).click();
        getDriver().findElement(By.xpath("//select[@name='DateOfBirthMonth']/*[contains(text(), \"June\")]")).click();
        getDriver().findElement(By.xpath("//select[@name='DateOfBirthYear']/*[@value='1985']")).click();
    }
    @And("I enter {string} into Company name field")
    public void iEnterIntoCompanyNameField(String companyName) {
        getDriver().findElement(By.id("Company")).sendKeys(companyName);
    }
    @When("I uncheck Newsletter checkbox")
    public void iUncheckNewsletterCheckbox() {
        getDriver().findElement(By.id("Newsletter")).click();
    }
    @Then("I verify that user is logged in")
    public void iVerifyThatUserIsLoggedIn() {
     String actualText=getDriver().findElement(By.xpath("//div[@class='result']")).getText();
     assertThat(actualText).isEqualToIgnoringCase("Your registration completed");
    }

    // Verify that user is not able to register twice using the same email
    @Then("Error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'validation')]//li")).isDisplayed()).isTrue();
        String actualText = getDriver().findElement(By.xpath("//div[contains(@class, 'validation')]//li")).getText();
        Assertions.assertThat(actualText).containsIgnoringCase(errorMessage);
    }
}
