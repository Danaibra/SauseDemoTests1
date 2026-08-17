package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.debug("Page object initialized: {}", this.getClass().getSimpleName());
    }
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        logger.debug("Current page URL is: '{}'", currentUrl);
        return currentUrl;
    }
}