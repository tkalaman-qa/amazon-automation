package StepDefinitions;

import Pages.AmazonPages;
import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class AmazonStepsDef {

    @Given("User is on Homepage")
    public void userIsOnHomepage() {
        AmazonPages.HomePage(DriverFactory.getDriver());

    }

    @When("Click on the accept cookies")
    public void clickOnTheAcceptCookies() {
        AmazonPages.AcceptCookies();
    }

    @When("Click on the Search Button")
    public void clickOnTheSearchButton() {
        AmazonPages.SearchButton();

    }

    @When("Write Product Name")
    public void writeProductName() {
        AmazonPages.ProductName();
    }
    @When("Click on the Search Button Again")
    public void clickOnTheSearchButtonAgain() {
        AmazonPages.SearchButtonAgain();
    }

    @When("Filter for Shipped by Amazon")
    public void filterForShippedByAmazon() {
        AmazonPages.FilterShippment();
    }

    @When("Filter for Apple")
    public void filterForApple() {
        AmazonPages.FilterForApple();

    }

    @When("Click on the First Product")
    public void clickOnTheFirstProduct() {
        AmazonPages.ClickOnTheFirstProduct();
    }

    @When("Add to the Cart")
    public void addToTheCart() {
        AmazonPages.AddToTheCart();
    }

    @When("Check on the Shopping Cart")
    public void checkOnTheShoppingCart() {

        AmazonPages.CheckOnTheShoppingCart();

    }


}
