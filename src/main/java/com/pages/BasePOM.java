package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class BasePOM {
    private WebDriver driver;
    public BasePOM(WebDriver driver){
        this.driver = driver;
    }
    public void Wait(int miliSec){
        try{
            Thread.sleep(miliSec);
        }
        catch(InterruptedException ie){
        }
    }

    public String removeChars(String someString) {
        String[] charsToRemove = { "@", "$", "#", "%", "+", ";", "'", " " };
        for (String c : charsToRemove) {
            someString = someString.replace(c, "");
        }
        return someString;
    }

    public double convertStringToDouble(String strNumber) {
        double number1Double;
        Locale locale;
        if (strNumber.contains(".")) {
            locale = Locale.US;
        } else {
            locale = Locale.FRANCE;
        }

        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        try {
            Number parsedNumber = numberFormat.parse(strNumber);
            number1Double = parsedNumber.doubleValue();
        } catch (ParseException e) {
            System.out.println("Unable to parse the string as a double.");
            number1Double = 0.0; // You might want to set a default value here
        }

        return number1Double;
    }

    public boolean isSearchButtonExist(){
        return driver.findElement(search_Input).isDisplayed();
    }
    public boolean isCartButtonExist(){
        return driver.findElement(cartButton).isDisplayed();
    }
    public boolean isNavigationSectionExist(){
        return driver.findElement(navigationSection).isDisplayed();
    }

    public void clickSignInButton(){
        driver.findElement(signIn_Button).click();
    }

    public void searchProduct(String searchName){
        driver.findElement(search_Input).sendKeys(searchName);
        driver.findElement(search_Input).sendKeys(Keys.ENTER);
        Wait(2000);
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }


    public By search_Input = By.id("search");
    public By signIn_Button = By.xpath("(//*[@class='authorization-link'])[1]");
    public By cartButton = By.xpath("//*[@class='action showcart']");
    public By navigationSection = By.id("store.menu");


}
