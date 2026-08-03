package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;


    private By completeTitle = By.cssSelector("[data-test='title']");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitleText() {
        return driver.findElement(completeTitle).getText();
    }

}