package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TaskStepDefs {
    @Given("I navigate to {string} page TC")
    public void iNavigateToPageTC(String url) {
        getDriver().get("https://" + url + ".com/");
    }

    @Then("I should see page title as {string} TC")
    public void iShouldSeePageTitleAsTC(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }


    @When("I click on {string} button TC")
    public void iClickOnButtonTC(String btn) {
        getDriver().findElement(By.xpath("//*[contains(text(), '" + btn + "')]")).click();
    }

    @Then("Element with text {string} should be displayed TC")
    public void elementWithTextShouldBeDisplayedTC(String text) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='signup-form']/h2")).getText()).containsIgnoringCase(text);
    }

    @When("I fill the form with name {string} and email address {string} TC")
    public void iFillTheFormWithNameAndEmailAddressTC(String name, String email) {
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
    }

    @And("I submit the form TC")
    public void iSubmitTheFormTC() {
        getDriver().findElement(By.xpath("//button[text()='Signup']")).click();
    }

    @Then("element with xpath {string} should have text as {string} TC")
    public void elementWithXpathShouldHaveTextAsTC(String xpath, String text) {
//        String actualtext = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(getDriver().findElement(By.xpath(xpath)).getText().equalsIgnoreCase(text)).isTrue();
    }


    @When("I fill the form with title {string}, password {string}, date of birth including day {string}, month {string}, year {string} TC")
    public void iFillTheFormWithTitlePasswordDateOfBirthIncludingDayMonthYearTC(String title, String password, String day, String month, String year) {
        getDriver().findElement(By.xpath("//input[@value='" + title + "']")).click();
        getDriver().findElement(By.id("password")).sendKeys(password);
        getDriver().findElement(By.xpath("//*[@id='days']/*[@value='" + day + "']")).click();
        getDriver().findElement(By.xpath("//*[@id='months']/option[text()='" + month + "']")).click();
        getDriver().findElement(By.xpath("//*[@id='years']/*[@value='" + year + "']")).click();
    }

    @When("I check {string} checkbox TC")
    public void iCheckCheckboxTC(String labelText) {
        getDriver().findElement(By.xpath("//label[contains(text(), '" + labelText + "')]/..//input")).click();
        }

    @And("I enter {string} into First name field TC")
    public void iEnterIntoFirstNameFieldTC(String firstName) {
        getDriver().findElement(By.id("first_name")).sendKeys(firstName);
    }

    @And("I enter {string} into Last name field TC")
    public void iEnterIntoLastNameFieldTC(String lastName) {
        getDriver().findElement(By.id("last_name")).sendKeys(lastName);
    }

    @And("I enter {string} into Company field TC")
    public void iEnterIntoCompanyFieldTC(String company) {
        getDriver().findElement(By.id("company")).sendKeys(company);
    }

    @When("I enter {string} into Address field TC")
    public void iEnterIntoAddressFieldTC(String address) {
        getDriver().findElement(By.id("address1")).sendKeys(address);
    }

    @And("I enter {string} into Country field TC")
    public void iEnterIntoCountryFieldTC(String country) {
        getDriver().findElement(By.xpath("//select[@id='country']/*[@value='" + country + "']")).click();
    }

    @When("I enter {string} into State field TC")
    public void iEnterIntoStateFieldTC(String state) {
        getDriver().findElement(By.id("state")).sendKeys(state);
    }

    @When("I enter {string} into City field TC")
    public void iEnterIntoCityFieldTC(String city) {
        getDriver().findElement(By.id("city")).sendKeys(city);
    }

    @When("I enter {string} into Zip code field TC")
    public void iEnterIntoZipCodeFieldTC(String zipCode) {
        getDriver().findElement(By.id("zipcode")).sendKeys(zipCode);
    }

    @And("I enter {string} into Mobile Number field TC")
    public void iEnterIntoMobileNumberFieldTC(String mobileNumber) {
        getDriver().findElement(By.id("mobile_number")).sendKeys(mobileNumber);
    }


    @Then("I verify that I'm logged in as {string} TC")
    public void iVerifyThatIMLoggedInAsTC(String userName) {
        String actualText = getDriver().findElement(By.xpath("//a[contains(text(), 'Logged in as')]/..//b")).getText();
        assertThat(actualText.equals(userName)).isTrue();
    }

    @And("I verify that account was {string} TC")
    public void iVerifyThatAccountWasTC(String accountStatus) {
        String actualtext = getDriver().findElement(By.xpath("//h2[@data-qa='account-" + accountStatus + "']/b")).getText();
        assertThat(actualtext.equalsIgnoreCase("Account " + accountStatus + "!")).isTrue();
    }

    @When("I refresh the page")
    public void iRefreshThePage() {
        getDriver().navigate().refresh();
    }
}
