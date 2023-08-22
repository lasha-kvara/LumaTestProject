package com.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.qa.factory.DriverFactory;
import com.thoughtworks.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }
    BasePOM pom = new BasePOM(DriverFactory.getDriver());

    public void chooseSize(String size){
        switch (size) {
            case "XS" -> driver.findElement(size_XS).click();
            case "S" -> driver.findElement(size_S).click();
            case "M" -> driver.findElement(size_M).click();
            case "L" -> driver.findElement(size_L).click();
            case "XL" -> driver.findElement(size_XL).click();
            default -> driver.findElement(anyFirstSize).click();
        }
    }

    public void chooseAnyFirstColor(){
        driver.findElement(anyFirstColor).click();
    }

    public void clickAddToCart(){
        driver.findElement(addToCart_Button).click();
        pom.Wait(3000);
    }

    public void chooseAnyFirstProductFromSearchResult(){
        driver.findElement(anyFirstProductFromSearchResult).click();
        pom.Wait(3000);
    }

    public String getPriceFromDetailPage(){
        return driver.findElement(productPrice).getText();
    }

    public boolean isAddCartSuccessMSGExist(){
        return driver.findElement(addCartSuccessMSG).isDisplayed();
    }

    public String getProductPriceFromCartPopup(){
        return driver.findElement(productPriceInCartPopup).getText();
    }







    private By size_XS = By.xpath("//*[@option-label='XS']");
    private By size_S = By.xpath("//*[@option-label='S']");
    private By size_M = By.xpath("//*[@option-label='M']");
    private By size_L = By.xpath("//*[@option-label='L']");
    private By size_XL = By.xpath("//*[@option-label='XL']");
    private By anyFirstProductFromSearchResult = By.xpath("(//*[@class='item product product-item'])[1]//*[@class='product-item-link']");
    private By anyFirstSize = By.xpath("//*[@id='option-label-size-143-item-166']");
    private By anyFirstColor = By.xpath("//*[@class='swatch-option color'][1]");
    private By addToCart_Button = By.id("product-addtocart-button");
    private By productPrice = By.xpath("(//*[@class='normal-price']//span[2]//*[@class='price'])[1]");

    private By addCartSuccessMSG = By.xpath("//*[@class='page messages']//div[contains(text(),'You added')]");

    private By productPriceInCartPopup = By.className("minicart-price");
}
