package definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
public class TestTaskStepDefs {
    @Given("I go to the {string}")
    public void iGoToThe(String url) {
        getDriver().get(url);
    }

    @Then("I should see page title")
    public void iShouldSeePageTitle() {
        assertThat(getDriver().getTitle()).isEqualTo("Automation Exercise");
    }

    @Then("I Click on Signup&Login button")
    public void clickOnSignupLoginButton() {
        getDriver().findElement(By.xpath("//*[contains(text(), ' Signup / Login')]")).click();
    }

    @Then("New User Signup! should be present")
    public void newUserSignupShouldBePresent() {
        String actualText = getDriver().findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).getText();
        assertThat(actualText).containsIgnoringCase(actualText);
    }

    @When("Enter name and email address")
    public void enterNameAndEmailAddress() {

        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Team2");
        getDriver().findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']")).sendKeys("Team2@abkck.com");
    }

    @Then("I click Signup button")
    public void clickSignupButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
    }

    @When("I verify that ENTER ACCOUNT INFORMATION is visible")
    public void iVerifyThatENTERACCOUNTINFORMATIONIsVisible() {
        String actualText = getDriver().findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).getText();
        assertThat(actualText).containsIgnoringCase(actualText);
    }

    @Then("I fill out all the details")
    public void iFillDetails() {
        getDriver().findElement(By.xpath("//input[@id='id_gender1']")).click();
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("Team2password");
        getDriver().findElement(By.xpath("//*[@value='17']")).click();
        getDriver().findElement(By.xpath("//*[@value='4']")).click();
        getDriver().findElement(By.xpath("//*[@value='2001']")).click();
    }

    @Then("I select checkbox Sign up for our newsletter!")
    public void iSelectCheckboxSignUpForOurNewsletter() {
        getDriver().findElement(By.xpath("//input[@id='newsletter']")).click();
    }

    @Then("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        getDriver().findElement(By.xpath("//input[@id='optin']")).click();
    }

    @Then("I fill address information")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {

        getDriver().findElement(By.xpath("//*[@id='first_name']")).sendKeys("Tony");

        getDriver().findElement(By.xpath("//*[@id='last_name']")).sendKeys("Stark");

        getDriver().findElement(By.xpath("//input[@id='company']")).sendKeys("Stark Industries");

        getDriver().findElement(By.xpath("//input[@id='address1']")).sendKeys("1337 Paper St");

        getDriver().findElement(By.xpath("//input[@id='address2']")).sendKeys("Apt 418");

        getDriver().findElement(By.xpath("//*[@value='United States']")).click();

        getDriver().findElement(By.xpath("//input[@id='state']")).sendKeys("NY");

        getDriver().findElement(By.xpath("//input[@id='city']")).sendKeys("New-York");

        getDriver().findElement(By.xpath("//input[@id='zipcode']")).sendKeys("10005");

        getDriver().findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("13372281488");
    }

    @Then("I click Create Account button")
    public void iClickCreateAccountButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
    }

    @Then("I verify that ACCOUNT CREATED! is visible")
    public void iVerifyThatACCOUNTCREATEDIsVisible() {
        String actualText = getDriver().findElement(By.xpath("//b[contains(text(),'Account Created!')]")).getText();
        assertThat(actualText).containsIgnoringCase(actualText);
    }
//    @Then("Verify that {string} is visible")
//    public void verifyThatACCOUNTDELETEDIsVisible(String text) {
//        String actualText =
//                getDriver().findElement(By.xpath("//b[contains(text(),'Account
//                        Created!')]")).getText();
//        assertThat(actualText).containsIgnoringCase(text);

    @Then("Click on Delete Account button")
    public void clickOnDeleteAccountButton() {
        getDriver().findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();
    }

    @Then("Click Continue button")
    public void clickContinueButton() {
        getDriver().findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }

    @Then("I verify that Logged in as Team2 is visible")
    public void iVerifyThatLoggedInAsUsernameIsVisible() {
        String actualText = getDriver().findElement(By.xpath("//*[contains(text(), ' Logged in as ')]")).getText();
        assertThat(actualText).containsIgnoringCase("Logged in as");
        String actualText2 = getDriver().findElement(By.xpath("//b[contains(text(),'Team2')]")).getText();
        assertThat(actualText2).containsIgnoringCase("Team2");
    }


    @Then("Verify that ACCOUNT DELETED! is visible and click on Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        String actualText = getDriver().findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText();
        assertThat(actualText).containsIgnoringCase(actualText);

        getDriver().findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }
}
