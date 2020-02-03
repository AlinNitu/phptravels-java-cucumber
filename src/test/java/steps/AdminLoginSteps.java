package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminLoggedInHomePage;
import pages.AdminLoginPage;


public class AdminLoginSteps {

    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminLoggedInHomePage adminLoggedInHomePage = new AdminLoggedInHomePage();

    @Given("User navigates to Admin login page")
    public void navigateToAdminLoginPage() {

        adminLoginPage.navigateToAdminLoginPage();
    }

    @Given("User enters valid Admin username")
    public void userEntersValidAdminUsername() {

        adminLoginPage.enterValidAdminUsername();
    }

    @Given("User enters valid Admin password")
    public void userEntersValidAdminPassword() {

        adminLoginPage.enterValidAdminPassword();
    }

    @When("User clicks on the Admin login button")
    public void userClicksOnTheAdminLoginButton() {

        adminLoginPage.clickAdminLoginButton();
    }

    @Then("User is successfully logged in Admin home page")
    public void userIsSuccessfullyLoggedInAdminHomePage() {

        adminLoggedInHomePage.waitForPage();
        adminLoggedInHomePage.adminIsSuccessfullyLoggedIn();
    }
}
