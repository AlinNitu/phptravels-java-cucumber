package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import utils.DriverFactory;

public class Hooks {


    @Before()
    public void setup() {

        DriverFactory.getDriver().manage().window().setSize(new Dimension(1400, 1200));
    }

    @After()
    public void tearDown() {

        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().quit();
    }
}
