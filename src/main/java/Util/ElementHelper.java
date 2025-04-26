package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }

    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        return element;
    }

    public void click(By key) {
        WebElement element = findElement(key);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Hooks.test.info("Clicking on element: " + key);
        element.click();
    }


    public void sendKey(By key, String text) {
        WebElement element = findElement(key);
        Hooks.test.info("Sending keys '" + text + "' to element: " + key);
        element.sendKeys(text);
    }
}

