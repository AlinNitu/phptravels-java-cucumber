package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.WaitTime;

import static utils.ClientDetailsGenerator.*;
import static utils.ClientDetailsGenerator.getClientNationality;
import static utils.DateHandler.getAdultBirthday;
import static utils.DateHandler.getValidExpirationDate;

public class CheckoutPage extends BasePage {

    // PERSONAL INFORMATION
    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='surname']")
    public WebElement surname;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='birthday']")
    public WebElement birthday;

    @FindBy(xpath = "//input[@id='cardno']")
    public WebElement passportNumber;

    @FindBy(xpath = "//input[@id='expiration']")
    public WebElement expirationDate;

    @FindBy(xpath = "//div[@id='s2id_nationality']")
    public WebElement nationalityDropdown;

    @FindBy(xpath = "//div[@class='select2-search']/input[@type='text']")
    public WebElement nationality;

    // CREDIT CARD INFORMATION
    @FindBy(xpath = "//input[@id='card-number']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@id='cvv']")
    public WebElement cardCvv;

    @FindBy(xpath = "//select[@id='cardtype']")
    public WebElement cardTypeDropdown;

    @FindBy(xpath = "//select[@id='expiry-month']")
    public WebElement expirationMonthDropDown;

    @FindBy(xpath = "//select[@id='expiry-year']")
    public WebElement expirationYearDropDown;

    @FindBy(xpath = "//input[@id='acceptTerm']")
    public WebElement acceptTerms;

    @FindBy(xpath = "//button[@id='confirmBooking']")
    public WebElement completeBookingButton;


    @Override
    public void waitForPage() {

        waitUntilVisible(name, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void fillUserPersonalInformation() {

        clearAndSendKeys(name, getClientName());
        clearAndSendKeys(surname, getClientSurname());
        clearAndSendKeys(email, getClientEmail());
        clearAndSendKeys(phone, getClientPhone());
        clearAndSendKeys(passportNumber, getClientPassportNumber());
        clearAndSendKeys(birthday, getAdultBirthday());
        clearAndSendKeys(expirationDate, getValidExpirationDate());
        nationalityDropdown.click();
        clearAndSendKeys(nationality, getClientNationality());
        nationality.sendKeys(Keys.TAB);
    }

    public void fillUserCreditCardInformation() {

        Select cardTypeSelect = new Select(cardTypeDropdown);
        Select expirationMonthSelect = new Select(expirationMonthDropDown);
        Select expirationYearSelect = new Select(expirationYearDropDown);

        clearAndSendKeys(cardNumber, getCardNumber());
        clearAndSendKeys(cardCvv, getCardCvv());
        cardTypeSelect.selectByVisibleText("Visa");
        expirationMonthSelect.selectByVisibleText("Dec (12)");
        expirationYearSelect.selectByVisibleText("2023");
    }

    public void acceptTermsAndConditions() {

        jsExecutor.executeScript("arguments[0].click();", acceptTerms);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", completeBookingButton);
        jsExecutor.executeScript("window.scrollBy(0,-200)");
    }

    public void submitCheckoutForm() {

        waitAndClick(completeBookingButton, WaitTime.MEDIUM.getWaitTime());
    }

}
