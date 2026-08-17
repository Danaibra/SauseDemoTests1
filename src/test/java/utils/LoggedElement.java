package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LoggedElement {

    private final WebElement element;
    private static final Logger logger = LogManager.getLogger(LoggedElement.class);

    public LoggedElement(WebElement element) {
        this.element = element;
    }

    public void click(String elementName) {
        logger.info("Clicking on element: [{}]", elementName);
        element.click();
    }

    public void sendKeys(String text, String elementName) {
        logger.info("Typing text into field: [{}]", elementName);
        element.sendKeys(text);
    }

    public String getText(String elementName) {
        String text = element.getText();
        logger.info("Got text '{}' from element: [{}]", text, elementName);
        return text;
    }

    public boolean isEnabled(String elementName) {
        boolean isEnabled = element.isEnabled();
        logger.info("Element [{}] enabled status: {}", elementName, isEnabled);
        return isEnabled;
    }

    public boolean isDisplayed(String elementName) {
        boolean isDisplayed = element.isDisplayed();
        logger.info("Element [{}] displayed status: {}", elementName, isDisplayed);
        return isDisplayed;
    }
}