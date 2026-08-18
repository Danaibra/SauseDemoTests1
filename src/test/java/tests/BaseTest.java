package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.time.Duration;

    public class BaseTest {
        protected WebDriver driver;
        private static final String BASE_URL = System.getProperty("app.url", "https://www.saucedemo.com/");

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser");
        driver = DriverFactory.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}