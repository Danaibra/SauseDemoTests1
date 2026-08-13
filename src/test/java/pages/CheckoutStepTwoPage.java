package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutStepTwoPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    private WebElement itemName;

    @FindBy(className = "summary_tax_label")
    private WebElement taxLabel;

    @FindBy(className = "summary_total_label")
    private WebElement totalLabel;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        logger.debug("Retrieving item name from overview page");
        String productName = itemName.getText();
        logger.info("Overview item name: '{}'", productName);
        return productName;
    }

    public String getTaxText() {
        logger.debug("Retrieving tax amount");
        String tax = taxLabel.getText();
        logger.info("Tax label text: '{}'", tax);
        return tax;
    }

    public String getTotalText() {
        logger.debug("Retrieving total amount");
        String totalPrice = totalLabel.getText();
        logger.info("Total label text: '{}'", totalPrice);
        return totalPrice;
    }

    public void clickFinish() {
        logger.debug("Waiting up to 5 seconds for Finish button to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)); //Explicit wait

        logger.info("Clicking Finish button");
        finishButton.click();
    }
}