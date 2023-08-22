package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    BasePOM pom = new BasePOM(DriverFactory.getDriver());
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public String getEmptyEmailInputError(){return driver.findElement(emptyEmailInput_ErrMsg).getText();}
    public String getEmptyPassInputError(){return driver.findElement(emptyPassInput_ErrMsg).getText();}
    public String getLoginErrorMessage(){return driver.findElement(loginFailed_Error_MSG).getText();}

    public boolean isForgotPwdButtonExist(){
        return driver.findElement(forgotPassword_Button).isDisplayed();
    }

    public boolean isLoginErrorMessageExist(){return driver.findElement(loginFailed_Error_MSG).isDisplayed(); }


    public void clearEmailInput(){
        driver.findElement(email_Input).clear();
    }
    public void clearPasswordInput(){
        driver.findElement(password_Input).clear();
    }
    public void clickSignInButton(){
        driver.findElement(pom.signIn_Button).click();
    }
    public void clickSignInTheAccountButton(){
        driver.findElement(signInTheAccount_Button).click();
    }

    public void fillEmail_Input(String email){
        driver.findElement(email_Input).sendKeys(email);
    }

    public void fillPassword_Input(String password){
        driver.findElement(password_Input).sendKeys(password);
    }
    public boolean isEmailInputExist(){
        return driver.findElement(email_Input).isDisplayed();
    }
    public boolean isPasswordInputExist(){
        return driver.findElement(password_Input).isDisplayed();
    }
    public boolean isSignInTheAccountButtonExist(){
        return driver.findElement(signInTheAccount_Button).isDisplayed();
    }
    public boolean isCreateAccountButtonExist(){
        return driver.findElement(createAccount_Button_InLoginPage).isDisplayed();
    }
    public boolean isWelcomeRickSanchezMSGExist(){
        return driver.findElement(welcomeMSG_ForRickSanchez).isDisplayed();
    }





    private By email_Input = By.id("email");
    private By password_Input = By.xpath("(//*[@id='pass'])[1]");
    private By signInTheAccount_Button = By.xpath("(//*[@id='send2'])[1]");
    private By forgotPassword_Button = By.xpath("//*[@class='action remind']");
    private By loginFailed_Error_MSG = By.xpath("//*[@class='page messages']/div[2]/div/div/div");
    private By emptyEmailInput_ErrMsg = By.id("email-error");
    private By emptyPassInput_ErrMsg = By.id("pass-error");
    private By createAccount_Button_InLoginPage = By.xpath("//*[@class='action create primary']");
    private By welcomeMSG_ForRickSanchez = By.xpath("(//*[@class='greet welcome'])[1]//span[contains(text(), 'Welcome, Rick Sanchez')]");

}
