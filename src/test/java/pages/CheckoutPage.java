package pages;

import models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggedElement;


public class CheckoutPage extends AuthorizedPage{

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
        firstNameInput.clear();
        new LoggedElement(firstNameInput).sendKeys(customer.firstName(), "First Name Field");

        lastNameInput.clear();
        new LoggedElement(lastNameInput).sendKeys(customer.lastName(), "Last Name Field");

        postalCodeInput.clear();
        new LoggedElement(postalCodeInput).sendKeys(customer.zipCode(), "Postal Code Field");

        new LoggedElement(continueButton).click("Continue Button");
    }
}