package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/report.html" - for html report
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber"},
        features = "src/test/features/",
        glue = {"steps"}
)

public class MainRunner extends AbstractTestNGCucumberTests {

}
