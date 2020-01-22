package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import java.util.List;

public class FlightsSelectionPage extends BasePage {

    @FindBy(xpath = "//div[@class='custom-control custom-radio']/div/label")
    public List<WebElement> radioButtons;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block theme-search-results-item-price-btn']")
    public List<WebElement> bookFlightButton;

    @FindBy(xpath = "//div[@class='sidebar-title bg-primary']")
    public WebElement sideMenu;



    @Override
    public void waitForPage() {
        waitUntilVisible(sideMenu, WaitTime.EXTRA_LARGE.getWaitTime());
    }
}
