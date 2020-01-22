package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AdminBookingsPage;
import pages.AdminLoggedInHomePage;
import utils.WaitTime;

import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;

public class AdminFlightsBookingsSteps {

    AdminLoggedInHomePage adminLoggedInHomePage = new AdminLoggedInHomePage();
    AdminBookingsPage adminBookingsPage = new AdminBookingsPage();


    @Given("User navigates to flights bookings")
    public void userNavigatesToFlightsBookings() throws InterruptedException {

        adminLoggedInHomePage.travelhopeFlighsDropDown.click();
        adminLoggedInHomePage.waitAndClick(adminLoggedInHomePage.travelhopeFlighsBookings, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    @Then("Booking id in admin page is the same as booking number in invoice page")
    public void bookingIdInAdminPageIsTheSameAsBookingNumberInInvoicePage() {

        adminBookingsPage.waitForPage();

        Assert.assertEquals(CheckoutSteps.bookingNumberInvoice,
                adminBookingsPage.firstRowBookingId.getText().replaceAll("[^\\d]", ""),
                "The booking number in admin table is not the same as the booking id from the invoice");
    }

    @Then("In Admin panel departure flight is {string} and arriving flight is {string}")
    public void inAdminPanelDepartureFlightIsAndArrivingFlightIs(String origin, String destination) {

        Assert.assertEquals(adminBookingsPage.origin.getText(), origin,
                "Wrong origin saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.destination.getText(), destination,
                "Wrong destination saved in Admin panel");
    }

    @Then("In admin panel the booking is for {int} adults and {int} children and {int} infants")
    public void inAdminPanelTheBookingIsForAdultAndChildrenAndInfants(int adults, int children, int infants) {

        Assert.assertEquals(adminBookingsPage.adults.getText(), String.valueOf(adults),
                "Wrong number of adults saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.children.getText(), String.valueOf(children),
                "Wrong number of children saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.infants.getText(), String.valueOf(infants),
                "Wrong number of infants saved in Admin panel");
    }

    @Then("In Admin panel the departure date is next Monday")
    public void inAdminPanelTheDepartureDateIsNextMonday() throws Exception {

        Assert.assertEquals(adminBookingsPage.departureDate.getText().substring(0, 10), getNextMonday(),
                "Not the same departure date");
    }

    @And("In admin panel the arriving date is next Sunday")
    public void inAdminPanelTheArrivingDateIsNextSunday() throws Exception {

        Assert.assertEquals(adminBookingsPage.arrivalDate.getText().substring(0, 10), getNextSunday(),
                "Not the same arrival date");
    }
}
