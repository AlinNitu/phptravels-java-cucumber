package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WaitTime;

public class AdminLoggedInHomePage extends BasePage {

    @FindBy(xpath = "//ul[@id='social-sidebar-menu']")
    protected WebElement sidebarMenu;

    @FindBy(xpath = "//a[@href='#TravelhopeFlights']")
    protected WebElement travelhopeFlighsDropDown;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/thflight/bookings']")
    protected WebElement travelhopeFlighsBookings;


    @Override
    public void waitForPage() {

        waitUntilVisible(sidebarMenu, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void adminIsSuccessfullyLoggedIn() {

        Assert.assertTrue(sidebarMenu.isDisplayed(), "Successfully logged in the Admin home page");
    }

    public void navigateToTravelFlightsBookings() {

        travelhopeFlighsDropDown.click();
        waitAndClick(travelhopeFlighsBookings, WaitTime.EXTRA_SMALL.getWaitTime());
    }
}
