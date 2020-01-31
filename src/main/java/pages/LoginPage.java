package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    protected WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    protected WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn']")
    protected WebElement submitLogin;


    @Override
    public void waitForPage() {
        waitUntilVisible(username, WaitTime.MEDIUM.getWaitTime());
    }

    public void enterValidUsername() {

        username.sendKeys(getConfigProp("username"));
    }

    public void enterValidPassword() {

        password.sendKeys(getConfigProp("password"));
    }

    public void clickLoginButton() {

        waitAndClick(submitLogin, WaitTime.EXTRA_SMALL.getWaitTime());
    }

}
