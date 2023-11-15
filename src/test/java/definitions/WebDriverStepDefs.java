package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class WebDriverStepDefs {
    @Given("I go to {string}")
    public void iGoTo(String url) {
        if (url.contains("google")) {
            getDriver().get("http://google.com");
        }else if(url.contains("yahoo")){
            getDriver().get("http://yahoo.com");
        }else if(url.contains("sample")){
            getDriver().get("https://skryabin.com/webdriver/html/sample.html");
        }else{
            System.out.println("The url for the site " + url + " is not supported");
        }
    }

    @Then("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
        }

    @And("I go back, forward and refresh")
    public void iGoBackForwardAndRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Given("I open {string}, {string} and {string}")
    public void iOpenURL(String arg0, String arg1, String arg2) {
        String[] urls = {arg0, arg1, arg2};
        for (String url:urls             ) {
            getDriver().get("http://www." + url + ".com");
        }
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.name("email")).sendKeys(email);
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.id("formSubmit")).click();
    }

    @Then("email error message is displayed")
    public void emailErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("email-error")).isDisplayed()).isTrue();
    }

    @Then("email error {string} is displayed")
    public void emailErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.id("email-error")).getText();
        //System.out.println(actualError);
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @And("I clear email field")
    public void iClearEmailField() {
        getDriver().findElement(By.name("email")).clear();
    }

    @Then("email error message is not displayed")
    public void emailErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("email-error")).isDisplayed()).isFalse();
    }

    @When("I type {string} into username field")
    public void iTypeIntoUsernameField(String username) {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }

    @Then("username error message is displayed")
    public void usernameErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("username-error")).isDisplayed()).isTrue();
    }

    @Then("username error {string} is displayed")
    public void usernameErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.id("username-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @And("I clear username field")
    public void iClearUsernameField() {
        getDriver().findElement(By.xpath("//input[@name='username']")).clear();
    }

    @Then("username error message is not displayed")
    public void usernameErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("username-error")).isDisplayed()).isFalse();
    }

    @Then("confirm password field should be disabled")
    public void confirmPasswordFieldShouldBeDisabled() {
        String attribute = getDriver().findElement(By.id("confirmPassword")).getAttribute("disabled");
        assertThat(attribute.equals("true")).isTrue();
    }

    @When("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.id("password")).sendKeys(password);
    }

    @Then("password error message is displayed")
    public void passwordErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("password-error")).isDisplayed()).isTrue();
    }

    @Then("password error {string} is displayed")
    public void passwordErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.id("password-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @When("I clear password field")
    public void iClearPasswordField() {
        getDriver().findElement(By.id("password")).clear();
    }

    @Then("password error message is not displayed")
    public void passwordErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("password-error")).isDisplayed()).isFalse();
    }

    @When("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
    }

    @Then("confirm password error message is displayed")
    public void confirmPasswordErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("confirmPassword-error")).isDisplayed()).isTrue();
    }

    @Then("confirm password error {string} is displayed")
    public void confirmPasswordErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.id("confirmPassword-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @When("I clear confirm password field")
    public void iClearConfirmPasswordField() {
        getDriver().findElement(By.id("confirmPassword")).clear();
    }

    @Then("confirm password error message is not displayed")
    public void confirmPasswordErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("confirmPassword-error")).isDisplayed()).isFalse();
    }

    @And("password is masked")
    public void passwordIsMasked() {
        String type = getDriver().findElement(By.id("password")).getAttribute("type");
        assertThat(type.equals("password")).isTrue();
    }

    @And("confirm password is masked")
    public void confirmPasswordIsMasked() {
        String type = getDriver().findElement(By.id("confirmPassword")).getAttribute("type");
        assertThat(type.equals("password")).isTrue();
    }


    @Then("name error message is displayed")
    public void nameErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("name-error")).isDisplayed()).isTrue();
    }

    @Then("name error {string} is displayed")
    public void nameErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.id("name-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @When("I click on name field")
    public void iClickOnNameField() {
        getDriver().findElement(By.id("name")).click();
    }

    @And("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.id("firstName")).sendKeys(firstName);
    }

    @When("I type {string} into middle name field")
    public void iTypeIntoMiddleNameField(String middleName) {
        getDriver().findElement(By.id("middleName")).sendKeys(middleName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.id("lastName")).sendKeys(lastName);
    }

    @When("I click save button")
    public void iClickSaveButton() {
        getDriver().findElement(By.xpath("//*[text()='Save']/..")).click();
    }

    @Then("name error message is not displayed")
    public void nameErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("name-error")).isDisplayed()).isFalse();
    }

    @And("name {string} is displayed")
    public void nameIsDisplayed(String fullName) {
        assertThat(getDriver().findElement(By.id("name")).getAttribute("value").equals(fullName)).isTrue();
    }

    @Then("checkbox error message is displayed")
    public void checkboxErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.id("agreedToPrivacyPolicy-error")).isDisplayed()).isTrue();
    }

    @And("checkbox error {string} is displayed")
    public void checkboxErrorIsDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//*[@id='agreedToPrivacyPolicy-error']")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @When("I accept Privacy Policy")
    public void iAcceptPrivacyPolicy() {
        getDriver().findElement(By.name("agreedToPrivacyPolicy")).click();
    }

    @Then("checkbox error message is not displayed")
    public void checkboxErrorMessageIsNotDisplayed() {
        assertThat(getDriver().findElement(By.id("agreedToPrivacyPolicy-error")).isDisplayed()).isFalse();
    }

    @Then("{string} title is displayed")
    public void titleIsDisplayed(String expectedTitle) {
        assertThat(getDriver().findElement(By.xpath("//*[@id='samplePageResult']/fieldset/legend")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.xpath("//*[@id='samplePageResult']/fieldset/legend")).getText();
        assertThat(actualTitle.equals(expectedTitle)).isTrue();
    }

    @And("username {string} is displayed on submitted page")
    public void usernameIsDisplayedOnSubmittedPage(String username) {
        assertThat(getDriver().findElement(By.name("username")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.name("username")).getText();
        assertThat(actualTitle.equals(username)).isTrue();
    }

    @Then("email {string} is displayed on submitted page")
    public void emailIsDisplayedOnSubmittedPage(String email) {
        assertThat(getDriver().findElement(By.name("email")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.name("email")).getText();
        assertThat(actualTitle.equals(email)).isTrue();
    }

    @And("name {string} is displayed on submitted page")
    public void nameIsDisplayedOnSubmittedPage(String name) {
        assertThat(getDriver().findElement(By.name("name")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.name("name")).getText();
        assertThat(actualTitle.equals(name)).isTrue();
    }

    @Then("password is masked on submitted page")
    public void passwordIsMaskedOnSubmittedPage() {
        assertThat(getDriver().findElement(By.name("password")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.name("password")).getText();
        assertThat(actualTitle.equals("[entered]")).isTrue();
    }

    @And("Agreed to Privacy Policy is {string}")
    public void agreedToPrivacyPolicyIs(String acceptState) {
        assertThat(getDriver().findElement(By.name("agreedToPrivacyPolicy")).isDisplayed()).isTrue();
        String actualTitle = getDriver().findElement(By.name("agreedToPrivacyPolicy")).getText();
        assertThat(actualTitle.equals(acceptState)).isTrue();
    }
}
