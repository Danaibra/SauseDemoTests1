package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import java.time.Duration;

    public class BaseTest {
        protected static final Logger logger = LogManager.getLogger(BaseTest.class);
        protected WebDriver driver;
        private static final String BASE_URL = System.getProperty("app.url", "https://www.saucedemo.com/");

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser");
        logger.info("Starting browser setup (browser property: {})", browser);
        driver = DriverFactory.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        driver.manage().window().maximize();
        logger.info("navigating to base url: {}", BASE_URL);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser and tearing down driver");
            driver.quit();
        }
    }
        public WebDriver getDriver() {
            return driver;
        }
}