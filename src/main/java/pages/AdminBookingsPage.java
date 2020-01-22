package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class AdminBookingsPage extends BasePage {

    @FindBy(xpath = "//table[@class='xcrud-list table table-striped table-hover']")
    public WebElement bookingsTable;

    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement firstRowBookingId;

    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    public WebElement origin;

    @FindBy(xpath = "//tbody/tr[1]/td[7]")
    public WebElement destination;

    @FindBy(xpath = "//tbody/tr[1]/td[8]")
    public WebElement departureDate;

    @FindBy(xpath = "//tbody/tr[1]/td[9]")
    public WebElement arrivalDate;

    @FindBy(xpath = "//tbody/tr[1]/td[10]")
    public WebElement adults;

    @FindBy(xpath = "//tbody/tr[1]/td[11]")
    public WebElement children;

    @FindBy(xpath = "//tbody/tr[1]/td[12]")
    public WebElement infants;


    @Override
    public void waitForPage() {
        waitUntilVisible(bookingsTable, WaitTime.MEDIUM.getWaitTime());
    }
}
