package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    private By pageTitle = By.className("title");
    private By addToCartBackpack = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    public void setAddToCartBackpack() {
        driver.findElement(addToCartBackpack).click();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}