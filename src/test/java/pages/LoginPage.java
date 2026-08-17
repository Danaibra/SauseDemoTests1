package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import models.User;
import utils.LoggedElement;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        new LoggedElement(usernameInput)
                .sendKeys(username, "Username Field");
    }

    public void enterPassword(String password) {
        new LoggedElement(passwordInput)
                .sendKeys(password, "Password Field");
    }

    public void clickLogin() {
        new LoggedElement(loginButton)
                .click("Login Button");
    }

    public void login(User user) {
        logger.info("Logging in user: {}", user.username());

        enterUsername(user.username());
        enterPassword(user.password());
        clickLogin();
    }
}