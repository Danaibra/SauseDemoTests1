package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggedElement;

import java.time.Duration;

public class CheckoutStepTwoPage extends AuthorizedPage {

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
        return new LoggedElement(itemName).getText("Overview Item Name");
    }

    public String getTaxText() {
        return new LoggedElement(taxLabel).getText("Tax Label");
    }

    public String getTotalText() {
        return new LoggedElement(totalLabel).getText("Total Label");
    }

    public void clickFinish() {
        logger.debug("Waiting up to 5 seconds for Finish button to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)); //Explicit wait

        new LoggedElement(finishButton).click("Finish Button");
    }
}