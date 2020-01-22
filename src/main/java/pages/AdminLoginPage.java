package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class AdminLoginPage extends BasePage {

    @FindBy(xpath = "//label/input[@name='email']")
    public WebElement adminEmail;

    @FindBy(xpath = "//label/input[@name='password']")
    public WebElement adminPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ladda-button fadeIn animated btn-lg']")
    public WebElement adminLoginButton;


    @Override
    public void waitForPage() {

        waitUntilVisible(adminEmail, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void navigateToAdminLoginPage() {

        driver.navigate().to(getConfigProp("adminUrl"));
        waitForPage();
    }
}
