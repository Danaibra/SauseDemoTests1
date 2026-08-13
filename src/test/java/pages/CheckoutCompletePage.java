package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        logger.debug("Waiting up to 5 seconds for complete title visibility");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(completeTitle)); // explicit waiting

        String titleText = completeTitle.getText();
        logger.info("Complete title text received: '{}'", titleText);
        return titleText;
    }
    public String getHeaderText() {
        logger.debug("Fetching checkout complete header text");
        String headerText = completeHeader.getText();
        logger.info("Checkout header complete text is: {}", headerText);
        return headerText;
    }
    public boolean isBackHomeButtonDisplayed() {
        logger.debug("Checking visibility of back home button");
        boolean isBackHomeButtonVisible = backHomeButton.isDisplayed();
        logger.info("'Back Home' button displayed status: {}", isBackHomeButtonVisible);
        return isBackHomeButtonVisible;
    }


}