package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoggedInHomePage;
import pages.LoginPage;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class LoginSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LoggedInHomePage loggedInHomePage = new LoggedInHomePage();


    @Given("User navigates to home page")
    public void navigateToHomePage() {

        homePage.navigateToHomePage();
    }

    @Given("User clicks on the my account drop-down button")
    public void clickOnMyAccountButtonHomePage() {

        homePage.waitAndClick(homePage.myAccountDropdown, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    @Given("User clicks on the login button on home page")
    public void clickOnLoginButtonHomePage() {

        homePage.waitAndClick(homePage.loginButton, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    @Given("User enters valid username")
    public void enterValidUsername() {

        loginPage.waitForPage();
        loginPage.username.sendKeys(getConfigProp("username"));
    }

    @Given("User enters valid password")
    public void userEntersValidPassword() {

        loginPage.password.sendKeys(getConfigProp("password"));
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {

        loginPage.waitAndClick(loginPage.submitLogin, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    @Then("User is successfully logged in")
    public void userSuccessfullyLoggedIn() {

        loggedInHomePage.waitForPage();
        Assert.assertTrue(loggedInHomePage.leftMenu.isDisplayed());
    }
}
