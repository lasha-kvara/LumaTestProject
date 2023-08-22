package StepDefinitions;

import com.pages.BasePOM;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.ProductDetailPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartPageSteps {

    String productPrice;
    Double productPrice_double;

    String productPriceFromCartPopup;
    Double productPriceFromCartPopup_double;
    ProductDetailPage prodDetailP = new ProductDetailPage(DriverFactory.getDriver());
    MainPage mainPage = new MainPage(DriverFactory.getDriver());

    BasePOM pom = new BasePOM(DriverFactory.getDriver());


    @Then("Search {string} Product")
    public void searchProduct(String productName){
        pom.searchProduct(productName);
    }

    @And("Choose the first product")
    public void chooseTheFirstProduct() {
        prodDetailP.chooseAnyFirstProductFromSearchResult();
    }

    @And("Get price from the product detail page")
    public void getPriceFromTheProductDetailPage() {
        productPrice = prodDetailP.getPriceFromDetailPage();
        System.out.println("Prod Price String = " + productPrice);
    }

    @Then("Remove chars from the price and convert to double")
    public void removeCharsFromThePriceAndConvertToDouble() {
        String RC = pom.removeChars(productPrice);
        productPrice_double = pom.convertStringToDouble(RC);
        System.out.println(productPrice_double);
    }

    @And("Choose size {string}")
    public void chooseSize(String size) {
        prodDetailP.chooseSize(size);
    }

    @And("Choose any color")
    public void chooseAnyColor() {
        prodDetailP.chooseAnyFirstColor();
    }

    @And("Add click to cart")
    public void addClickToCart() {
        prodDetailP.clickAddToCart();
    }


    @Then("Check add cart success message is displayed")
    public void checkAddCartSuccessMessageIsDisplayed() {
        prodDetailP.isAddCartSuccessMSGExist();
    }

    @When("Click cart button")
    public void clickCartButton() {
        pom.clickCartButton();
        pom.Wait(2000);
    }

    @Then("Get product price from cart popup")
    public void getProductPriceFromCartPopup() {
        productPriceFromCartPopup = prodDetailP.getProductPriceFromCartPopup();
        System.out.println("Prod Price From Cart Popup String = " + productPrice);
    }
    @Then("Remove chars from the cart price and convert to double")
    public void removeCharsFromTheCartPriceAndConvertToDouble() {
        String RC = pom.removeChars(productPriceFromCartPopup);
        productPriceFromCartPopup_double = pom.convertStringToDouble(RC);
        System.out.println(productPriceFromCartPopup_double);
    }

    @Then("Verify if the product price is correct in the cart")
    public void verifyIfTheProductPriceIsCorrectInTheCart() {
        Assert.assertEquals(productPrice_double, productPriceFromCartPopup_double);
    }


}
