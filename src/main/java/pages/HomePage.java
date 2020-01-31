package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class HomePage extends BasePage {


    @FindBy(xpath = ".//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")
    protected WebElement myAccountDropdown;

    @FindBy(xpath = ".//a[@class='dropdown-item active tr']")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[@data-name='flights']")
    protected WebElement flightsSearchButton;


    @Override
    public void waitForPage() {

        waitUntilVisible(myAccountDropdown, WaitTime.MEDIUM.getWaitTime());
    }

    public void navigateToHomePage() {

        driver.navigate().to(getConfigProp("url"));
        waitForPage();
    }

    public void clickOnMyAccountDropDown() {

        waitAndClick(myAccountDropdown, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    public void clickOnLoginButton() {

        waitAndClick(loginButton, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    public void clickOnFlightsButton() {

        waitAndClick(flightsSearchButton, WaitTime.MEDIUM.getWaitTime());
    }

}
