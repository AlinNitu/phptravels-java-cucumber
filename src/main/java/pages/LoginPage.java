package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTime;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn']")
    public WebElement submitLogin;


    @Override
    public void waitForPage() {
        waitUntilVisible(username, WaitTime.MEDIUM.getWaitTime());
    }
}
