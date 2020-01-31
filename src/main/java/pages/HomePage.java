package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class HomePage extends BasePage {


    @FindBy(xpath = ".//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")
    public WebElement myAccountDropdown;

    @FindBy(xpath = ".//a[@class='dropdown-item active tr']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@data-name='flights']")
    public WebElement flightsSearchButton;


    @Override
    public void waitForPage() {

        waitUntilVisible(myAccountDropdown, WaitTime.MEDIUM.getWaitTime());
    }

    public void navigateToHomePage() {

        driver.navigate().to(getConfigProp("url"));
        waitForPage();
    }

    public WebElement getFlightsSearchButton() {
        return flightsSearchButton;
    }
}
