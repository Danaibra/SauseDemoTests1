package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggedElement;

import java.time.Duration;

public class CheckoutCompletePage extends BasePage{

    @FindBy(css = ("[data-test='title']"))
    private WebElement completeTitle;

    @FindBy(css = "#checkout_complete_container > h2")
    private WebElement completeHeader;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public String getTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(completeTitle));

        return new LoggedElement(completeTitle).getText("Complete Title");
    }

    public String getHeaderText() {
        return new LoggedElement(completeHeader).getText("Checkout Complete Header");
    }

    public boolean isBackHomeButtonDisplayed() {
        return new LoggedElement(backHomeButton).isDisplayed("Back Home Button");
    }
}