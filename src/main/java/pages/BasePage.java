package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public abstract class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver = DriverFactory.getDriver();

    protected BasePage() {

        PageFactory.initElements(driver, this);
    }


    public abstract void waitForPage();

    protected void waitUntilVisible(WebElement element, int timeout) {

        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAndClick(WebElement element, int timeout) {

        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clearAndSendKeys(WebElement element, String key) {

        element.clear();
        element.sendKeys(key);
    }



}
