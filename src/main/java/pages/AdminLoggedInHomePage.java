package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WaitTime;

public class AdminLoggedInHomePage extends BasePage {

    @FindBy(xpath = "//ul[@id='social-sidebar-menu']")
    public WebElement sidebarMenu;

    @FindBy(xpath = "//a[@href='#TravelhopeFlights']")
    public WebElement travelhopeFlighsDropDown;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/thflight/bookings']")
    public WebElement travelhopeFlighsBookings;


    @Override
    public void waitForPage() {

        waitUntilVisible(sidebarMenu, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void adminIsSuccessfullyLoggedIn() {

        Assert.assertTrue(sidebarMenu.isDisplayed(), "Successfully logged in the Admin home page");
    }
}
