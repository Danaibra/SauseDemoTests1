package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(className = "inventory_item_name")
    private WebElement cartItem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        logger.debug("Retrieving cart item name"); // Technical/debug log
        String itemName = cartItem.getText();
        logger.info("Cart item name is: {}", itemName); // Action/result log
        return itemName;
    }

    public boolean isCheckoutButtonEnabled() {
        logger.debug("Checking if checkout button is enabled");
        boolean isEnabledCheckoutButton = checkoutButton.isEnabled();
        logger.info("Checkout button is enabled status: {}", isEnabledCheckoutButton);
        return isEnabledCheckoutButton;
    }

    public void goToCheckOut() {
        logger.info("Clicking checkout button"); // Action log
        checkoutButton.click();
    }
}