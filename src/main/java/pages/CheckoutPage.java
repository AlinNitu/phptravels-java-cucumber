package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

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
}
