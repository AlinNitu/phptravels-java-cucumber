package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import static utils.ReadConfigFile.getConfigProp;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        try {

            String browser = getConfigProp("browser");

            switch (browser) {

                case BrowserType.CHROME: {

                    if (null == driver) {

                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                }

                case BrowserType.FIREFOX: {

                    if (null == driver) {

                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                }
            }
        } catch (Exception e) {

            System.out.println("Failed to load driver: " + e.getMessage());
        }

        return driver;
    }
}
