package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.FlightsPage;
import pages.FlightsSelectionPage;
import pages.HomePage;
import pages.LoggedInHomePage;
import utils.DriverFactory;
import utils.WaitTime;

import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;

public class FlightSteps {

    private WebDriver driver = DriverFactory.getDriver();
    JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    LoggedInHomePage loggedInHomePage = new LoggedInHomePage();
    FlightsPage flightsPage = new FlightsPage();
    FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage();
    HomePage homePage = new HomePage();


    @Given("User clicks on the home button on top menu")
    public void navigateToHomePage() {

        loggedInHomePage.waitAndClick(loggedInHomePage.homeTopMenu, WaitTime.MEDIUM.getWaitTime());
        //flightsPage.waitForPage();
    }

    @Given("User clicks on the flights button")
    public void navigateToFlightsSearch() {

        loggedInHomePage.waitAndClick(homePage.flightsSearchButton, WaitTime.MEDIUM.getWaitTime());
        flightsPage.waitForPage();
    }

    @Given("User selects return flight option")
    public void userSelectsReturnFlightOption() {

        flightsPage.waitAndClick(flightsPage.returnFlightCheckBox, WaitTime.SMALL.getWaitTime());
    }


    @Given("User selects a flight departing from {string} and arriving at {string}")
    public void userSelectsFlightDepartingFrom(String from, String destination) {

        flightsPage.waitAndClick(flightsPage.flightFromDefault, WaitTime.MEDIUM.getWaitTime());
        flightsPage.flightDestinationsTextBox.sendKeys(from);
        flightsPage.waitAndClick(flightsPage.resultLabel, WaitTime.LARGE.getWaitTime());

        flightsPage.waitAndClick(flightsPage.flightToDefault, WaitTime.MEDIUM.getWaitTime());
        flightsPage.flightDestinationsTextBox.sendKeys(destination);
        flightsPage.waitAndClick(flightsPage.resultLabel, WaitTime.LARGE.getWaitTime());
    }


    @Given("Set departure date as next Monday")
    public void setDepartureDateAsNextMonday() throws Exception {

        jsExecutor.executeScript
                ("document.getElementById('FlightsDateStart').removeAttribute('readonly', 0)");

        flightsPage.flightDateDepart.sendKeys(getNextMonday());
        flightsPage.flightDateDepart.sendKeys(Keys.TAB);
    }

    @Given("Set departure date as next Sunday")
    public void setDepartureDateAsNextSunday() throws Exception {

        jsExecutor.executeScript
                ("document.getElementById('FlightsDateEnd').removeAttribute('readonly', 0)");

        flightsPage.flightDateReturn.sendKeys(getNextSunday());
        flightsPage.flightDateReturn.sendKeys(Keys.TAB);
    }

    @When("Click the Search flights button to navigate to flights selection")
    public void clickTheSearchButton() {

        flightsPage.searchButton.click();
        flightsSelectionPage.waitForPage();
    }

    @And("The booking is for {int} adults and {int} children and {int} infants")
    public void theBookingIsForAdultsAndChildrenAndInfants(int adults, int children, int infants) {

        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", flightsPage.adultsNumber);
        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", flightsPage.childrenNumber);
        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", flightsPage.infantsNumber);

        flightsPage.clearAndSendKeys(flightsPage.adultsNumber, String.valueOf(adults));
        flightsPage.clearAndSendKeys(flightsPage.childrenNumber, String.valueOf(children));
        flightsPage.clearAndSendKeys(flightsPage.infantsNumber, String.valueOf(infants));
    }
}
