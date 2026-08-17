package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggedElement;

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

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("inventory.html");
    }

    public String getTitleText() {
        return new LoggedElement(pageTitle).getText("Inventory Page Title");
    }

    public int getProductsCount() {
        logger.debug("Counting product items on page");
        int inventoryListCount = inventoryItems.size();
        logger.info("Found {} products on the page", inventoryListCount);
        return inventoryListCount;
    }

    public void addBackpackToCart() {
        new LoggedElement(addToCartBackpack).click("Add Backpack To Cart Button");
    }

    public String getCartBadgeText() {
        return new LoggedElement(cartBadge).getText("Cart Badge Counter");
    }

    public void goToCart() {
        new LoggedElement(cartButton).click("Cart Link");
    }
}