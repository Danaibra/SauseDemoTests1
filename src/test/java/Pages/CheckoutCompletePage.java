package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    private final WebDriver driver;

    @FindBy(css = ("[data-test='title']"))
    private WebElement completeTitle;

    @FindBy(css = "#checkout_complete_container > h2")
    private WebElement completeHeader;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getHeaderText() {
        return completeHeader.getText();
    }
    public boolean isBackHomeButtonDisplayed() {
        return backHomeButton.isDisplayed();
    }

    public String getTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(completeTitle)); // explicit waiting

        return completeTitle.getText();
    }
}