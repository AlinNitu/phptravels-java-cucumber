package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.CheckoutPage;
import pages.InvoicePage;
import utils.DriverFactory;
import utils.WaitTime;

import static utils.DateHandler.getAdultBirthday;
import static utils.DateHandler.getValidExpirationDate;
import static utils.ClientDetailsGenerator.*;

public class CheckoutSteps {

    private WebDriver driver = DriverFactory.getDriver();
    CheckoutPage checkoutPage = new CheckoutPage();
    InvoicePage invoicePage = new InvoicePage();

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    public static String bookingNumberInvoice;

    @Given("User fills required personal information")
    public void userFillsPersonalInformation() {

        checkoutPage.waitForPage();

        checkoutPage.clearAndSendKeys(checkoutPage.name, getClientName());
        checkoutPage.clearAndSendKeys(checkoutPage.surname, getClientSurname());
        checkoutPage.clearAndSendKeys(checkoutPage.email, getClientEmail());
        checkoutPage.clearAndSendKeys(checkoutPage.phone, getClientPhone());
        checkoutPage.clearAndSendKeys(checkoutPage.passportNumber, getClientPassportNumber());
        checkoutPage.clearAndSendKeys(checkoutPage.birthday, getAdultBirthday());
        checkoutPage.clearAndSendKeys(checkoutPage.expirationDate, getValidExpirationDate());
        checkoutPage.nationalityDropdown.click();
        checkoutPage.clearAndSendKeys(checkoutPage.nationality, getClientNationality());
        checkoutPage.nationality.sendKeys(Keys.TAB);
    }

    @Given("User fills credit card information")
    public void userFillCreditCardInformation() {

        Select cardTypeSelect = new Select(checkoutPage.cardTypeDropdown);
        Select expirationMonthSelect = new Select(checkoutPage.expirationMonthDropDown);
        Select expirationYearSelect = new Select(checkoutPage.expirationYearDropDown);

        checkoutPage.clearAndSendKeys(checkoutPage.cardNumber, getCardNumber());
        checkoutPage.clearAndSendKeys(checkoutPage.cardCvv, getCardCvv());
        cardTypeSelect.selectByVisibleText("Visa");
        expirationMonthSelect.selectByVisibleText("Dec (12)");
        expirationYearSelect.selectByVisibleText("2023");
    }


    @When("User accepts terms and successfully submits checkout form")
    public void userAcceptsTermsAndSubmitsCheckoutForm() {

        jsExecutor.executeScript("arguments[0].click();", checkoutPage.acceptTerms);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", checkoutPage.completeBookingButton);
        jsExecutor.executeScript("window.scrollBy(0,-200)");

        checkoutPage.waitAndClick(checkoutPage.completeBookingButton, WaitTime.MEDIUM.getWaitTime());
        invoicePage.waitForPage();
        bookingNumberInvoice = invoicePage.bookingNumber.getText().replaceAll("[^\\d]", "");
    }
}
