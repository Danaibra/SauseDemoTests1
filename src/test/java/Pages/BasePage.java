package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @FindBy(className = "shopping_cart_badge")
    protected WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    protected WebElement cartButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.debug("Page object initialized: {}", this.getClass().getSimpleName());
    }
}