package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {

    public static WebDriver driver;
    public static Properties properties;
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void before(Scenario scenario) {
        properties = ConfigReader.initialize_Properties();


        driver = DriverFactory.getDriver();

        extent = ExtentReportManager.getExtentReports();
        test = extent.createTest(scenario.getName());
    }


    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario Failed: " + scenario.getName());
        } else {
            test.pass("Scenario Passed: " + scenario.getName());
        }

        extent.flush();
        DriverFactory.quitDriver();

    }
}
