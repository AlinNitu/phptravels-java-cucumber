package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;

public class FlightsPage extends BasePage {


    @FindBy(xpath = "//label[@for='flightSearchRadio-1']")
    protected WebElement returnFlightCheckBox;

    @FindBy(xpath = "//div[@id='s2id_location_from']")
    protected WebElement flightFromDefault;

    @FindBy(xpath = "//div[@id='s2id_location_to']")
    protected WebElement flightToDefault;

    @FindBy(css = "#select2-drop > div > input")
    protected WebElement flightDestinationsTextBox;

    @FindBy(xpath = "//ul[@class='select2-results']/li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    protected WebElement resultLabel;

    @FindBy(id = "FlightsDateStart")
    protected WebElement flightDateDepart;

    @FindBy(id = "FlightsDateEnd")
    protected WebElement flightDateReturn;

    @FindBy(css = "#flights > div > div > form > div > div.row.no-gutters.mb-15.align-items-end.row-reverse > div.col-xs-12.col-md-1 > button")
    protected WebElement searchButton;


    @FindBy(name = "fadults")
    protected WebElement adultsNumber;

    @FindBy(name = "fchildren")
    protected WebElement childrenNumber;

    @FindBy(name = "finfant")
    protected WebElement infantsNumber;



    @Override
    public void waitForPage() {

        waitUntilVisible(flightFromDefault, WaitTime.LARGE.getWaitTime());
    }

    public void selectReturnFlightOption() {

        waitAndClick(returnFlightCheckBox, WaitTime.SMALL.getWaitTime());
    }

    public void selectFlightDepartingFrom(String from) {

        waitAndClick(flightFromDefault, WaitTime.MEDIUM.getWaitTime());
        flightDestinationsTextBox.sendKeys(from);
        waitAndClick(resultLabel, WaitTime.LARGE.getWaitTime());
    }

    public void selectFlightArrivingAt(String destination) {

        waitAndClick(flightToDefault, WaitTime.MEDIUM.getWaitTime());
        flightDestinationsTextBox.sendKeys(destination);
        waitAndClick(resultLabel, WaitTime.LARGE.getWaitTime());
    }

    public void setDepartingDateAsNextMonday() {

        jsExecutor.executeScript
                ("document.getElementById('FlightsDateStart').removeAttribute('readonly', 0)");

        flightDateDepart.sendKeys(getNextMonday());
        flightDateDepart.sendKeys(Keys.TAB);

    }

    public void setArrivingDateAsNextSunday() {

        jsExecutor.executeScript
                ("document.getElementById('FlightsDateEnd').removeAttribute('readonly', 0)");

        flightDateReturn.sendKeys(getNextSunday());
        flightDateReturn.sendKeys(Keys.TAB);
    }

    public void clickSearchFlightsButton() {

        searchButton.click();
    }

    public void setAdultsNumber(int adults) {

        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", adultsNumber);

        clearAndSendKeys(adultsNumber, String.valueOf(adults));
    }

    public void setChildrenNumber(int children) {

        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", childrenNumber);

        clearAndSendKeys(childrenNumber, String.valueOf(children));
    }

    public void setInfantsNumber(int infants) {

        jsExecutor.executeScript
                ("arguments[0].removeAttribute('readonly')", infantsNumber);

        clearAndSendKeys(infantsNumber, String.valueOf(infants));
    }
}
