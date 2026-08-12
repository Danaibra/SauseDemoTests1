package Pages;

import models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public void enterCheckoutInfo(Customer customer) {
        logger.info("Entering customer details: First Name='{}', Last Name='{}', Zip='{}'",
                customer.firstName(), customer.lastName(), customer.zipCode());

        firstNameInput.clear();
        firstNameInput.sendKeys(customer.firstName());

        lastNameInput.clear();
        lastNameInput.sendKeys(customer.lastName());

        postalCodeInput.clear();
        postalCodeInput.sendKeys(customer.zipCode());

        logger.info("Clicking Continue button");
        continueButton.click();
    }
}