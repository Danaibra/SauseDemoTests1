package tests;

import pages.*;
import models.Customer;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    private InventoryPage inventoryPage;

    @BeforeMethod(dependsOnMethods = "setup")
    protected void loginBeforeTest() {
        logger.info("Executing @BeforeMethod: Logging in with standard user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(User.getStandardUser());
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testLogin() {
        logger.info("Starting testLogin execution");
        Assert.assertTrue(
                inventoryPage.getCurrentUrl().contains("inventory.html"),
                "Inventory page URL is incorrect."
        );
        logger.info("URL assertion passed: Inventory page loaded correctly");
        Assert.assertEquals(
                inventoryPage.getTitleText(),
                "Products",
                "Products page title mismatch."
        );
        logger.info("Title assertion passed: Page title is 'Products'");
        Assert.assertTrue(
                inventoryPage.getProductsCount() > 0,
                "Inventory list is empty!"
        );
        logger.info("Products count assertion passed: Product list is not empty");
    }

    @Test
    public void testAddToCart() {
        logger.info("Starting testAddToCart execution");

        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1");
        logger.info("Cart badge count verified: 1 item added");

        inventoryPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.getCurrentUrl().contains("cart.html"));
        logger.info("Navigated to Cart page successfully");

        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
        logger.info("Verified item in cart: 'Sauce Labs Backpack'");
    }

    @Test
    public void testFullPurchase() {
        logger.info("Starting testFullPurchase execution");
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInfo(Customer.getStandardCustomer());

        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
        stepTwoPage.clickFinish();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);

        Assert.assertTrue(
                completePage.getCurrentUrl().contains("checkout-complete.html"),
                "Order completion page URL is incorrect."
        );
        logger.info("URL assertion passed: Checkout complete page loaded");

        Assert.assertEquals(
                completePage.getHeaderText(),
                "Thank you for your order!",
                "Order complete header text mismatch."
        );
        logger.info("Header assertion passed: 'Thank you for your order!' verified");

        Assert.assertTrue(
                completePage.isBackHomeButtonDisplayed(),
                "Back Home button is not displayed."
        );
        logger.info("Assertion passed: Back Home button is visible");
    }

    @Test
    public void testFailedScenarioForScreenshot() {
        logger.info("Starting testFailedScenarioForScreenshot execution (intended to fail)");

        String actualTitle = inventoryPage.getTitleText();
        logger.info("Current title is: '{}', expecting wrong title for screenshot test", actualTitle);

        Assert.assertEquals(
                actualTitle,
                "Non Existing Page Title",
                "Intentional failure to trigger screenshot capture!"
        );
    }
}