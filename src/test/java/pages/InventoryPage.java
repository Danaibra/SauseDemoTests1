package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {
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
        return pageTitle.getText();
    }

    public int getProductsCount() {
        return inventoryItems.size();
    }

    public void addBackpackToCart() {
        addToCartBackpack.click();
    }

    public String getCartBadgeText() {
        return cartBadge.getText();
    }

    public void goToCart() {
        cartButton.click();
    }
}