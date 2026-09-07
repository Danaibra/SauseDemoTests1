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

    public String getTitleText() {
        return new LoggedElement(pageTitle).getText("Inventory Page Title");
    }

    public int getProductsCount() {
        logger.debug("Counting product items on page");
        int count = inventoryItems.size();
        logger.info("Found {} products on the page", count);
        return count;
    }

    public void addBackpackToCart() {
        new LoggedElement(addToCartBackpack).click("Sauce Labs Backpack 'Add to Cart' Button");
    }

    public String getCartBadgeText() {
        return new LoggedElement(cartBadge).getText("Cart Badge");
    }

    public void goToCart() {
        new LoggedElement(cartButton).click("Cart Button");
    }
}