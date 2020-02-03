package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import java.util.List;

public class FlightsSelectionPage extends BasePage {

    @FindBy(xpath = "//div[@class='custom-control custom-radio']/div/label")
    protected List<WebElement> radioButtons;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block theme-search-results-item-price-btn']")
    protected List<WebElement> bookFlightButton;

    @FindBy(xpath = "//div[@class='sidebar-title bg-primary']")
    protected WebElement sideMenu;



    @Override
    public void waitForPage() {
        waitUntilVisible(sideMenu, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void filterByMinimumStops() throws InterruptedException {

        //Thread.sleep(5000);
        waitAndClick(radioButtons.get(0), WaitTime.EXTRA_LARGE.getWaitTime());
        Thread.sleep(2000); //not ideal but necessary here to make sure the sorting was performed
        waitAndClick(bookFlightButton.get(0), WaitTime.SMALL.getWaitTime());
    }
}
