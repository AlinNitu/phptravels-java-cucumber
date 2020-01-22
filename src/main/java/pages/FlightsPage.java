package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//label[@for='flightSearchRadio-1']")
    public WebElement returnFlightCheckBox;

    @FindBy(xpath = "//div[@id='s2id_location_from']")
    public WebElement flightFromDefault;

    @FindBy(xpath = "//div[@id='s2id_location_to']")
    public WebElement flightToDefault;

    @FindBy(css = "#select2-drop > div > input")
    public WebElement flightDestinationsTextBox;

    @FindBy(xpath = "//ul[@class='select2-results']/li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement resultLabel;

    @FindBy(id = "FlightsDateStart")
    public WebElement flightDateDepart;

    @FindBy(id = "FlightsDateEnd")
    public WebElement flightDateReturn;

    @FindBy(css = "#flights > div > div > form > div > div.row.gap-10.mb-15.align-items-end.row-reverse > div.col-xs-12.col-md-1 > button")
    public WebElement searchButton;

    @FindBy(name = "fadults")
    public WebElement adultsNumber;

    @FindBy(name = "fchildren")
    public WebElement childrenNumber;

    @FindBy(name = "finfant")
    public WebElement infantsNumber;



    @Override
    public void waitForPage() {

        waitUntilVisible(flightFromDefault, WaitTime.LARGE.getWaitTime());
    }
}
