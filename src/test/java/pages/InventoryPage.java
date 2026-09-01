package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InventoryPage extends AuthorizedPage {
    @FindBy(className = "title")
    private WebElement pageTitle;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpack;
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        logger.debug("Fetching inventory page title text");
        String inventoryTitle = pageTitle.getText();
        logger.info("Inventory page title is: '{}'", inventoryTitle);
        return inventoryTitle;
    }

    public int getProductsCount() {
        logger.debug("Counting product items on page");
        int inventoryListCount = inventoryItems.size();
        logger.info("Found {} products on the page", inventoryListCount);
        return inventoryListCount;
    }

    public void addBackpackToCart() {
        logger.info("Clicking 'Add to Cart' button for Sauce Labs Backpack");
        addToCartBackpack.click();
    }

    public String getCartBadgeText() {
        logger.debug("Retrieving cart badge number");
        String badgeText = cartBadge.getText();
        logger.info("Cart badge count is: '{}'", badgeText);
        return badgeText;
    }

    public void goToCart() {
        logger.info("Clicking cart button");
        cartButton.click();
    }
}