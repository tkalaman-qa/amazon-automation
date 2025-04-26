package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"file:src/test/resources/features"},   // ✅ BURAYA DİKKAT
        glue = {"StepDefinitions", "Util"},
        tags = "",
        plugin = {
                "summary", "pretty", "html:Reports/CucumberReport/Reports.html"
        },
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
        // WebDriver çağırmaya gerek yok burada
}
