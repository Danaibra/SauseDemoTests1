package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggedElement;

public class CartPage extends AuthorizedPage{

    @FindBy(className = "inventory_item_name")
    private WebElement cartItem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("cart.html");
    }

    public String getItemName() {
        return new LoggedElement(cartItem).getText("Cart Item Name");
    }

    public boolean isCheckoutButtonEnabled() {
        return new LoggedElement(checkoutButton).isEnabled("CheckoutButton");
    }

    public void goToCheckOut() {
        new LoggedElement(checkoutButton).click("Checkout Button");
    }
}