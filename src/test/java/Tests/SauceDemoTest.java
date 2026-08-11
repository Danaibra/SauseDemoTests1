package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataReader;


public class SauceDemoTest extends BaseTest {
    private InventoryPage inventoryPage;
    @BeforeMethod
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        String validUser = TestDataReader.getProperty("user.valid.username");
        String validPass = TestDataReader.getProperty("user.valid.password");
        loginPage.login(validUser, validPass);
        inventoryPage = new InventoryPage(driver);
    }
    @Test
    public void testLogin() {
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Inventory page URL is incorrect."
        );
        Assert.assertEquals(
                inventoryPage.getTitleText(),
                "Products",
                "Products page title mismatch."
        );
        Assert.assertTrue(
                inventoryPage.getProductsCount() > 0,
                "Inventory list is empty!"
        );
    }

    @Test
    public void testAddToCart() {
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1");

        inventoryPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isCheckoutButtonEnabled());
    }

    @Test
    public void testFullPurchase() {
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterCheckoutInfo("Dana", "Ibrayeva", "44012");

        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
        stepTwoPage.clickFinish();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-complete.html"),
                "Order completion page URL is incorrect."
        );
        Assert.assertEquals(
                completePage.getHeaderText(),
                "Thank you for your order!",
                "Order complete header text mismatch."
        );
        Assert.assertTrue(
                completePage.isBackHomeButtonDisplayed(),
                "Back Home button is not displayed."
        );
    }
}