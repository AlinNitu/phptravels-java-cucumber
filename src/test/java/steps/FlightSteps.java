package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.FlightsPage;
import pages.FlightsSelectionPage;
import pages.HomePage;
import pages.LoggedInHomePage;

public class FlightSteps {

    LoggedInHomePage loggedInHomePage = new LoggedInHomePage();
    FlightsPage flightsPage = new FlightsPage();
    FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage();
    HomePage homePage = new HomePage();


    @Given("User clicks on the home button on top menu")
    public void goToHomePageFromTopMenu() {

        loggedInHomePage.clickOnHomeButtonTopMenu();
    }

    @Given("User clicks on the flights button")
    public void navigateToFlightsSearch() {

        homePage.clickOnFlightsButton();
        flightsPage.waitForPage();
    }

    @Given("User selects return flight option")
    public void userSelectsReturnFlightOption() {

        flightsPage.selectReturnFlightOption();
    }


    @Given("User selects a flight departing from {string} and arriving at {string}")
    public void userSelectsFlightDepartingFrom(String from, String destination) {

        flightsPage.selectFlightDepartingFrom(from);
        flightsPage.selectFlightArrivingAt(destination);
    }


    @Given("Set departure date as next Monday")
    public void setNextMondayDepartingDate() throws Exception {

        flightsPage.setDepartingDateAsNextMonday();
    }

    @Given("Set arriving date as next Sunday")
    public void setNextSundayArrivingDate() throws Exception {

        flightsPage.setArrivingDateAsNextSunday();
    }

    @When("Click the Search flights button to navigate to flights selection")
    public void clickTheSearchButton() {

        flightsPage.clickSearchFlightsButton();
        flightsSelectionPage.waitForPage();
    }

    @Given("The booking is for {int} adults and {int} children and {int} infants")
    public void theBookingIsForAdultsAndChildrenAndInfants(int adults, int children, int infants) {

        flightsPage.setAdultsNumber(adults);
        flightsPage.setChildrenNumber(children);
        flightsPage.setInfantsNumber(infants);
    }
}
