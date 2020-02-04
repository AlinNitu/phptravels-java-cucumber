package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AdminBookingsPage;
import pages.AdminLoggedInHomePage;

import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;

public class AdminFlightsBookingsSteps {

    AdminLoggedInHomePage adminLoggedInHomePage = new AdminLoggedInHomePage();
    AdminBookingsPage adminBookingsPage = new AdminBookingsPage();


    @Given("User navigates to flights bookings")
    public void userNavigatesToFlightsBookings() {

        adminLoggedInHomePage.navigateToTravelFlightsBookings();
    }

    @Then("Booking id in admin page is the same as booking number in invoice page")
    public void bookingIdInAdminPageIsTheSameAsBookingNumberInInvoicePage() throws InterruptedException {

        adminBookingsPage.waitForPage();

        Thread.sleep(2000); //for some reason the test fails without this, I guess the text is not loaded at the same time as the element;
        //I could create a function to wait for a specific text

        Assert.assertEquals(CheckoutSteps.bookingNumberInvoice,
                adminBookingsPage.getBookingId(),
                "The booking number in admin table is not the same as the booking id from the invoice");
    }

    @Then("In Admin panel departure flight is {string} and arriving flight is {string}")
    public void inAdminPanelDepartureFlightIsAndArrivingFlightIs(String origin, String destination) {

        Assert.assertEquals(adminBookingsPage.getOrigin(), origin,
                "Wrong origin saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.getDestination(), destination,
                "Wrong destination saved in Admin panel");
    }

    @Then("In admin panel the booking is for {int} adults and {int} children and {int} infants")
    public void inAdminPanelTheBookingIsForAdultAndChildrenAndInfants(int adults, int children, int infants) {

        Assert.assertEquals(adminBookingsPage.getAdults(), String.valueOf(adults),
                "Wrong number of adults saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.getChildren(), String.valueOf(children),
                "Wrong number of children saved in Admin panel");
        Assert.assertEquals(adminBookingsPage.getInfants(), String.valueOf(infants),
                "Wrong number of infants saved in Admin panel");
    }

    @Then("In Admin panel the departure date is next Monday")
    public void inAdminPanelTheDepartureDateIsNextMonday() {

        Assert.assertEquals(adminBookingsPage.getDepartureDate(), getNextMonday(),
                "Not the same departure date");
    }

    @And("In admin panel the arriving date is next Sunday")
    public void inAdminPanelTheArrivingDateIsNextSunday() {

        Assert.assertEquals(adminBookingsPage.getArrivalDate(), getNextSunday(),
                "Not the same arrival date");
    }
}
