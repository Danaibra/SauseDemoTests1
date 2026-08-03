# SauceDemo Test Automation Framework

Automated UI tests for [SauceDemo](https://www.saucedemo.com/) using Java, Selenium WebDriver, and TestNG.

## Project Structure
- **Pages**: Page Object Model classes (`LoginPage`, `InventoryPage`, `CartPage`, `CheckoutPage`, `CheckoutStepTwoPage`, `CheckoutCompletePage`).
- **Tests**: Test suites and setup (`BaseTest`, `SauceDemoTest`).

## Test Scenarios (8-10 Steps Each)

### 1. Test Login (`testLogin`)
1. Open SauceDemo login page.
2. Verify page URL matches `https://www.saucedemo.com/`.
3. Verify page title equals `Swag Labs`.
4. Enter invalid username.
5. Clear username field using `.clear()`.
6. Enter valid username (`standard_user`).
7. Enter password (`secret_sauce`).
8. Click Login button.
9. Verify redirected URL contains `/inventory.html`.
10. Assert page heading equals `Products`.

### 2. Test Add to Cart (`testAddToCart`)
1. Log in with valid credentials.
2. Verify user is on `/inventory.html`.
3. Add Backpack item to cart.
4. Verify cart badge displays `1`.
5. Click cart button to navigate to cart.
6. Verify URL contains `/cart.html`.
7. Verify item name in cart is `Sauce Labs Backpack`.
8. Click Continue Shopping button.
9. Verify redirected back to `/inventory.html`.
10. Re-enter cart and verify Checkout button is enabled.

### 3. Test Full Purchase (`testFullPurchase`)
1. Log in with valid credentials.
2. Add Backpack to cart and navigate to cart.
3. Click Checkout button.
4. Enter First Name (`Dana`).
5. Enter Last Name (`Ibrayeva`).
6. Enter Zip Code (`44012`).
7. Click Continue button.
8. Verify overview page.
9. Click Finish button.
10. Assert final page heading equals `Checkout: Complete!`.