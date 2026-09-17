package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import utils.ConfigReader;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("User navigates to login page")
    public void openLoginPage() {
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));
    }

    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("User should see {string} status")
    public void verifyStatus(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));

        if ("SUCCESS".equalsIgnoreCase(expectedResult)) {
            boolean isUrlCorrect = wait.until(ExpectedConditions.urlContains("inventory.html"));
            Assert.assertTrue(isUrlCorrect, "Expected navigation to inventory page was unsuccessful.");
        } else {
            boolean isErrorDisplayed = wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage())).isDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message should be displayed upon failed login.");
        }
    }
}