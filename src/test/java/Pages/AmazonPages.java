package Pages;

import java.time.Duration;
import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class AmazonPages {

    static WebDriver driver;
    static ElementHelper elementHelper;

    static By accept = By.id("sp-cc-accept");
    static By search = By.cssSelector("#twotabsearchtextbox");
    static By searchButtonAgain = By.id("nav-search-submit-button");
    static By filterShipment = By.cssSelector("body > div:nth-child(1) > div:nth-child(25) > div:nth-child(10) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(6) > span:nth-child(1) > span:nth-child(1) > li:nth-child(1) > span:nth-child(1) > a:nth-child(1) > div:nth-child(1) > label:nth-child(1) > i:nth-child(2)");
    static By filterForApple = By.cssSelector("a[aria-label='Sonuçları daraltmak için Apple filtresini uygulayın'] i[class='a-icon a-icon-checkbox']");
    static By clickOnFirstProduct = By.cssSelector("h2[aria-label='Apple AirPods 4.Nesil ANC Kablosuz Kulaklık, Bluetooth Kulaklık, Aktif Gürültü Engelleme, Adaptif Ses, Şeffaf Mod, Kişiselleştirilmiş Uzamsal Ses, USB-C Şarj Kutusu, Kablosuz Şarj, H2 Çip'] span");
    static By addToTheCart = By.cssSelector("#add-to-cart-button");
    static By goToTheCart = By.cssSelector("div[id='nav-cart-text-container'] span[class='nav-line-2']");
    static By CheckOnTheShoppingCart = By.cssSelector("div[id='nav-cart-text-container'] span[class='nav-line-2']");
    static By productNameInCart = By.cssSelector("span.a-truncate-cut");




    public static void HomePage(WebDriver driverParam) {
        driver = driverParam;
        elementHelper = new ElementHelper(driver);
        driver.get("https://www.amazon.com.tr");
    }

    public static void AcceptCookies() {
        try {
            elementHelper.click(accept);
            System.out.println("Cookies accepted.");
        } catch (Exception e) {
            System.out.println("No cookie popup found. Test continues.");
        }
    }

    public static void SearchButton() {
        elementHelper.click(search);
    }

    public static void ProductName() {
        elementHelper.sendKey(search, "airpods");
    }

    public static void SearchButtonAgain() {
        elementHelper.click(searchButtonAgain);
    }

    public static void FilterShippment() {
        elementHelper.click(filterShipment);
    }

    public static void FilterForApple() {
        elementHelper.click(filterForApple);
    }

    public static void ClickOnTheFirstProduct() {
        elementHelper.click(clickOnFirstProduct);
    }

    public static void AddToTheCart() {
        elementHelper.click(addToTheCart);
        elementHelper.click(goToTheCart);
    }

    public static void CheckOnTheShoppingCart() {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(checkTheCart));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameInCart));
        String actualText = product.getText();
        Assert.assertTrue(actualText.contains("AirPods"), "Product not found in the cart!");

    }
}
