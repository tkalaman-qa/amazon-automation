package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private static Properties properties;

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            properties = ConfigReader.getProperties();

            // Tarayıcıyı önce System property'den oku, yoksa config'den al
            String browser = System.getProperty("browser");

            if (browser == null || browser.isEmpty()) {
                browser = properties.getProperty("browser", "chrome"); // config'te de yoksa default "chrome"
            }

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            String url = properties.getProperty("url");
            int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeOut"));
            int impWait = Integer.parseInt(properties.getProperty("implicityWait"));

            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
            driver.get(url);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
