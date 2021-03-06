package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class AdminLoginPage extends BasePage {

    @FindBy(xpath = "//label/input[@name='email']")
    protected WebElement adminEmail;

    @FindBy(xpath = "//label/input[@name='password']")
    protected WebElement adminPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ladda-button fadeIn animated btn-lg']")
    protected WebElement adminLoginButton;


    @Override
    public void waitForPage() {

        waitUntilVisible(adminEmail, WaitTime.EXTRA_LARGE.getWaitTime());
    }

    public void navigateToAdminLoginPage() {

        driver.navigate().to(getConfigProp("adminUrl"));
        waitForPage();
    }

    public void enterValidAdminUsername() {

        adminEmail.sendKeys(getConfigProp("adminUsername"));
    }

    public void enterValidAdminPassword() {

        adminPassword.sendKeys(getConfigProp("adminPassword"));
    }

    public void clickAdminLoginButton() {

        waitAndClick(adminLoginButton, WaitTime.EXTRA_SMALL.getWaitTime());
    }
}
