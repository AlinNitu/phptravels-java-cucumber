package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AdminLoggedInHomePage;
import pages.AdminLoginPage;
import utils.WaitTime;

import static utils.ReadConfigFile.getConfigProp;

public class AdminLoginSteps {

    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminLoggedInHomePage adminLoggedInHomePage = new AdminLoggedInHomePage();

    @Given("User navigates to Admin login page")
    public void navigateToAdminLoginPage() {

        adminLoginPage.navigateToAdminLoginPage();
    }

    @Given("User enters valid Admin username")
    public void userEntersValidAdminUsername() {

        adminLoginPage.adminEmail.sendKeys(getConfigProp("adminUsername"));
    }

    @Given("User enters valid Admin password")
    public void userEntersValidAdminPassword() {

        adminLoginPage.adminPassword.sendKeys(getConfigProp("adminPassword"));
    }

    @When("User clicks on the Admin login button")
    public void userClicksOnTheAdminLoginButton() {

        adminLoginPage.waitAndClick(adminLoginPage.adminLoginButton, WaitTime.EXTRA_SMALL.getWaitTime());
    }

    @Then("User is successfully logged in Admin home page")
    public void userIsSuccessfullyLoggedInAdminHomePage() {

        adminLoggedInHomePage.waitForPage();
        Assert.assertTrue(adminLoggedInHomePage.sidebarMenu.isDisplayed(), "Successfully logged in the Admin home page");
    }
}
