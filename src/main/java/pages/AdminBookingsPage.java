package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class AdminBookingsPage extends BasePage {

    @FindBy(xpath = "//table[@class='xcrud-list table table-striped table-hover']")
    protected WebElement bookingsTable;

    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    protected WebElement firstRowBookingId;

    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    protected WebElement origin;

    @FindBy(xpath = "//tbody/tr[1]/td[7]")
    protected WebElement destination;

    @FindBy(xpath = "//tbody/tr[1]/td[8]")
    protected WebElement departureDate;

    @FindBy(xpath = "//tbody/tr[1]/td[9]")
    protected WebElement arrivalDate;

    @FindBy(xpath = "//tbody/tr[1]/td[10]")
    protected WebElement adults;

    @FindBy(xpath = "//tbody/tr[1]/td[11]")
    protected WebElement children;

    @FindBy(xpath = "//tbody/tr[1]/td[12]")
    protected WebElement infants;

    @FindBy(xpath = "//div[@class='panel-heading']")
    protected WebElement panelHeading;


    @Override
    public void waitForPage() {
        waitUntilVisible(panelHeading, WaitTime.MEDIUM.getWaitTime());
    }

    public String getBookingId() {

        return firstRowBookingId.getText();
    }

    public String getOrigin() {

        return origin.getText();
    }

    public String getDestination() {

        return destination.getText();
    }

    public String getAdults() {

        return adults.getText();
    }

    public String getChildren() {

        return children.getText();
    }

    public String getInfants() {

        return infants.getText();
    }

    public String getDepartureDate() {

        return departureDate.getText().substring(0, 10);
    }

    public String getArrivalDate() {

        return arrivalDate.getText().substring(0, 10);
    }
}
