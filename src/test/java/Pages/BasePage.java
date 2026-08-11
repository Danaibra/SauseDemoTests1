package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;

    @FindBy(className = "shopping_cart_badge")
    protected WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    protected WebElement cartButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}