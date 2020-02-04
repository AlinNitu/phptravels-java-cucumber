package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.InvoicePage;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();
    InvoicePage invoicePage = new InvoicePage();
    public static String bookingNumberInvoice;

    @Given("User fills required personal information")
    public void userFillsPersonalInformation() {

        checkoutPage.waitForPage();
        checkoutPage.fillUserPersonalInformation();
    }

    @Given("User fills credit card information")
    public void userFillCreditCardInformation() {

        checkoutPage.fillUserCreditCardInformation();
    }


    @When("User accepts terms and successfully submits checkout form")
    public void userAcceptsTermsAndSubmitsCheckoutForm() {


        checkoutPage.acceptTermsAndConditions();
        checkoutPage.submitCheckoutForm();

        invoicePage.waitForPage();

        bookingNumberInvoice = invoicePage.getBookingNumberInvoicePage();
    }
}
