package steps;

import io.cucumber.java.en.Given;
import pages.FlightsSelectionPage;
import utils.WaitTime;

public class FlightsSelectionSteps {

    FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage();

    @Given("User selects flight with minimum amount of stops")
    public void filterByMinAmountOfStops() throws InterruptedException {

        flightsSelectionPage.waitAndClick(flightsSelectionPage.radioButtons.get(0), WaitTime.EXTRA_LARGE.getWaitTime());
        Thread.sleep(2000); //not ideal but necessary here to make sure the sorting was performed
        flightsSelectionPage.waitAndClick(flightsSelectionPage.bookFlightButton.get(0), WaitTime.SMALL.getWaitTime());
    }
}
