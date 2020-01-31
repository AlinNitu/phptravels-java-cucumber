package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class LoggedInHomePage extends BasePage {

    @FindBy(xpath = "//ul[@class='menu-vertical-01']")
    public WebElement leftMenu;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/m-flights   ']")
    public WebElement flightsButtonTopMenu;

    @FindBy(xpath = "//a[@title='home']")
    public WebElement homeTopMenu;


    @Override
    public void waitForPage() {

        waitUntilVisible(leftMenu, WaitTime.MEDIUM.getWaitTime());
    }
}
