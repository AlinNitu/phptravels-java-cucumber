package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber"},
        features = "src/test/features/",
        glue = {"steps"},
        tags = {"@flight"}
)

public class FlightRunner extends AbstractTestNGCucumberTests {

}
