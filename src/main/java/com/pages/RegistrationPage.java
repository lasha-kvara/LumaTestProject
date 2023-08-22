package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public String getRegistrationPageTitle(){
        return driver.getTitle();
    }

    public void clickCreateAnAccountButton(){
        driver.findElement(createAnAccount_Button).click();
    }
    public void clickCreateAnAccount_ConfirmButton(){
        driver.findElement(createAnAccount_Confirm_Button).click();
    }
    public boolean isInvalidMailErrorExist(){
        return driver.findElement(invalidEmail_ErrMsg).isDisplayed();
    }
    public boolean isSuccessRegistrationMSGExist(){
        return driver.findElement(registrationSuccessMSG).isDisplayed();
    }

    public void fillRegistration_Inputs(String inputName, String str){
        switch (inputName) {
            case "firstName" -> driver.findElement(firstName_Input).sendKeys(str);
            case "lastName" -> driver.findElement(lastName_Input).sendKeys(str);
            case "email" -> driver.findElement(email_Input).sendKeys(str);
            case "password" -> driver.findElement(password_Input).sendKeys(str);
            case "confirmPassword" -> driver.findElement(confirmPassword_Input).sendKeys(str);
        }



    }





    private By firstName_Input = By.id("firstname");
    private By lastName_Input = By.id("lastname");
    private By email_Input = By.id("email_address");
    private By password_Input = By.id("password");
    private By confirmPassword_Input = By.id("password-confirmation");
    private By createAnAccount_Button = By.xpath("(//*[@class='header links']/li[3])[1]");
    private By createAnAccount_Confirm_Button = By.xpath("//*[@class='action submit primary']");
    private By invalidEmail_ErrMsg = By.id("email_address-error");
    private By registrationSuccessMSG = By.xpath("//*[@class='message-success success message']");
}
