package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AuthorizedPage extends BasePage {

    @FindBy(className = "shopping_cart_badge")
    protected WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    protected WebElement cartButton;

    public AuthorizedPage(WebDriver driver) {
        super(driver);
    }
}