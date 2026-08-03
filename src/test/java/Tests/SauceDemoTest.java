package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SauceDemoTest extends BaseTest {

    @Test
    public void testLogin() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong_user");
        loginPage.clearUsername();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Assert.assertEquals(inventoryPage.getTitleText(), "Products");
    }

    @Test
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        inventoryPage.setAddToCartBackpack();
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1");

        inventoryPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");

        cartPage.clickContinueShopping();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isCheckoutButtonEnabled());
    }

    @Test
    public void testFullPurchase() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.setAddToCartBackpack();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInfo("Dana", "Ibrayeva", "44012");

        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
        stepTwoPage.clickFinish();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(completePage.getTitleText(), "Checkout: Complete!");
    }
}