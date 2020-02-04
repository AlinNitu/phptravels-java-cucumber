package steps;

import io.cucumber.java.en.Given;
import pages.FlightsSelectionPage;

public class FlightsSelectionSteps {

    FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage();

    @Given("User selects flight with minimum amount of stops")
    public void filterByMinAmountOfStops() throws InterruptedException {

        flightsSelectionPage.filterByMinimumStops();
    }
}
