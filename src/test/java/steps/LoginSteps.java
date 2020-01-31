package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoggedInHomePage;
import pages.LoginPage;


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

        homePage.clickOnMyAccountDropDown();
    }

    @Given("User clicks on the login button on home page")
    public void clickOnLoginButtonHomePage() {

        homePage.clickOnLoginButton();
    }

    @Given("User enters valid username")
    public void enterValidUsername() {

        loginPage.waitForPage();
        loginPage.enterValidUsername();
    }

    @Given("User enters valid password")
    public void userEntersValidPassword() {

        loginPage.enterValidPassword();
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {

        loginPage.clickLoginButton();
    }

    @Then("User is successfully logged in")
    public void userSuccessfullyLoggedIn() {

        loggedInHomePage.waitForPage();
        loggedInHomePage.confirmUserWasLoggedIn();
    }
}
