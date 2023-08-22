package StepDefinitions;

import com.pages.BasePOM;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.EmailGenerator;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;


public class RegistrationPageSteps {

    private String generatedEmail;
    String registrationPageTitle;
    RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
    BasePOM pom = new BasePOM(DriverFactory.getDriver());

    private String generateValidEmail() {
        return EmailGenerator.generateValidEmail();
    }

    //Registration Page Title
    @When("User click create account Button")
    public void userClickCreateAccountButton() {
        registrationPage.clickCreateAnAccountButton();
    }

    @When("User gets the title of the registration page")
    public void userGetsTheTitleOfTheRegistrationPage() {
        registrationPageTitle = registrationPage.getRegistrationPageTitle();
    }

    @Then("Registration Page title should be {string}")
    public void registrationPageTitleShouldBe(String expectedTitle) {
        Assert.assertTrue(registrationPageTitle.contains(expectedTitle));
    }

    //Registration Invalid Email
    @Then("User enters first name with {string}")
    public void userEntersFirstNameWithString(String firstName) {
        registrationPage.fillRegistration_Inputs("firstName", firstName);
    }

    @And("User enters last name with {string}")
    public void userEntersLastNameWithString(String lastName) {
        registrationPage.fillRegistration_Inputs("lastName", lastName);
    }

//    @And("User enters invalid format of email with {string}")
//    public void userEntersInvalidFormatOfEmailWithString() {
//    }
    @And("User enters invalid format of email with {string}")
    public void userEntersInvalidFormatOfEmailWith(String invalidEmail) {
        registrationPage.fillRegistration_Inputs("email", invalidEmail);
    }

    @And("User enters valid format of random email")
    public void userEntersValidFormatOfEmailWith() {
        generatedEmail = generateValidEmail();
        registrationPage.fillRegistration_Inputs("email", generatedEmail);
    }

    @And("User enters password with {string}")
    public void userEntersPasswordWithString(String pass) {
        registrationPage.fillRegistration_Inputs("password", pass);
    }

    @And("User inputs confirm password with {string}")
    public void userInputsConfirmPasswordWithString(String pass) {
        registrationPage.fillRegistration_Inputs("confirmPassword", pass);
    }

    @When("User click create account confirmation Button")
    public void userClickCreateAccountConfirmationButton() {
        registrationPage.clickCreateAnAccount_ConfirmButton();
        pom.Wait(3000);
    }

    @Then("Invalid email error should be displayed")
    public void invalidEmailErrorShouldBeDisplayed() {
        registrationPage.isInvalidMailErrorExist();
    }

    @Then("Registration success message should be displayed")
    public void registrationSuccessMessageShouldBeDisplayed() {
        registrationPage.isSuccessRegistrationMSGExist();
    }

}
