package StepDefinitions;

import com.pages.BasePOM;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    String loginPageTitle;
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    MainPage mainPage = new MainPage(DriverFactory.getDriver());

    BasePOM pom = new BasePOM(DriverFactory.getDriver());

    //For Login Page Title Scenario
    @Given("User is on main page")
    public void user_is_on_login_page(){
        pom.isSearchButtonExist();
    }

    @When("User click SignIn Button")
    public void clickSignInButton(){
        loginPage.clickSignInButton();
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page(){
        loginPageTitle = loginPage.getLoginPageTitle();
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle){
        Assert.assertTrue(loginPageTitle.contains(expectedTitle));
    }

    //Verify Login Page Elements
    @Then("Search field should be visible")
    public void searchFieldShouldBeVisible() {
        pom.isSearchButtonExist();
    }
    @And("Cart button could be visible")
    public void cartButtonCouldBeVisible() {
        pom.isCartButtonExist();
    }
    @Then("Navigation section should be visible")
    public void navigationSectionShouldBeVisible() {
        pom.isNavigationSectionExist();
    }
    @Then("Email field should be visible")
    public void emailFieldShouldBeVisible() {
        loginPage.isEmailInputExist();
    }
    @And("Password field should be visible")
    public void passwordFieldShouldBeVisible() {
        loginPage.isPasswordInputExist();
    }

    @And("Sign In Account button should be visible")
    public void signInAccountButtonShouldBeVisible() {
        loginPage.isSignInTheAccountButtonExist();
    }

    @And("Forgot your password button should be visible")
    public void forgotYourPasswordButtonShouldBeVisible() {
        loginPage.isForgotPwdButtonExist();
    }

    @And("Create an account button should be visible")
    public void createAnAccountButtonShouldBeVisible() {
        loginPage.isCreateAccountButtonExist();
    }

    //For Verify Login Page Required Fields
    @And("Email field error should be visible")
    public void emailFieldErrorShouldBeVisible() {
        String errorMsg = loginPage.getEmptyEmailInputError();
        Assert.assertTrue(errorMsg.contains("This is a required field"));
    }

    @And("Password field error should be visible")
    public void passwordFieldErrorShouldBeVisible() {
        String errorMsg = loginPage.getEmptyPassInputError();
        Assert.assertTrue(errorMsg.contains("This is a required field"));
    }

    @Then("Clear email field")
    public void clearEmailField() {
        loginPage.clearEmailInput();
    }

    //For Login With Wrong Account Scenario
    @Then("User enters email input with wrong email: {string}")
    public void user_enters_email_input_with_wrong_email(String wrongEmail){
        loginPage.fillEmail_Input(wrongEmail);
    }

    @Then("User enters password input with wrong password: {string}")
    public void user_enters_password_input_with_wrong_password(String wrongPassword){
        loginPage.fillPassword_Input(wrongPassword);
    }

    @When("User click SignIn Account Button")
    public void user_click_signin_account_button(){
        loginPage.clickSignInTheAccountButton();
        pom.Wait(2000);
    }

    @Then("Error message should be visible")
    public void error_msg_should_be_visible(){
        pom.Wait(2000);
        loginPage.isLoginErrorMessageExist();
        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMsg.contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
    }


    @Then("Welcome Rick Sanchez message should be visible")
    public void welcomeRickSanchezMessageShouldBeVisible() {
        loginPage.isWelcomeRickSanchezMSGExist();
    }

    @Then("User enters email input with active email: {string}")
    public void userEntersEmailInputWithActiveEmail(String activeEmail) {
        loginPage.fillEmail_Input(activeEmail);
    }

    @Then("User enters password input with active password: {string}")
    public void userEntersPasswordInputWithActivePassword(String activePass) {
        loginPage.fillPassword_Input(activePass);
    }
}
