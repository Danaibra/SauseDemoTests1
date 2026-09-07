package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;

import java.util.List;

public class LoggedElement implements WebElement{

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

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return "";
    }

    @Override
    public @Nullable String getAttribute(String name) {
        return "";
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public List<WebElement> findElements(By by) {
        return List.of();
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return "";
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}