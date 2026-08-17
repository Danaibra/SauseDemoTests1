package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggedElement;

public abstract class AuthorizedPage extends BasePage {

    @FindBy(className = "shopping_cart_badge")
    protected WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    protected WebElement cartButton;

    public AuthorizedPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        new LoggedElement(cartButton).click("Cart Link");
    }

    public String getCartBadgeText() {
        return new LoggedElement(cartBadge).getText("Cart Badge Counter");
    }
}