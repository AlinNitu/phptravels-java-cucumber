package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class InvoicePage extends BasePage {

    @FindBy(xpath = "//button[@onclick='saveAndSendInvoice(0)']")
    public WebElement downloadInvoiceButton;

    @FindBy(xpath = "/html/body/div[2]/div[1]/center/div[2]/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td/div[2]")
    public WebElement bookingNumber;


    @Override
    public void waitForPage() {

        waitUntilVisible(downloadInvoiceButton, WaitTime.EXTRA_LARGE.getWaitTime());
    }
}
