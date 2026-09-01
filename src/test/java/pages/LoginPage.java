package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import models.User;

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
        logger.info("Entering username: {}", username);
        usernameInput.click();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking login button");
        loginButton.click();
    }

    public void login(User user) {
        logger.info("Logging in user: {}", user.username());
        enterUsername(user.username());
        enterPassword(user.password());
        clickLogin();
    }
}