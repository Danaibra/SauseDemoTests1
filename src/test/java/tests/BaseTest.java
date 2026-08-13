package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import java.time.Duration;

    public class BaseTest {
        protected static final Logger logger = LogManager.getLogger(BaseTest.class);
        protected WebDriver driver;

    @BeforeMethod
    protected void setup() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()){
            browser = ConfigReader.getProperty("browser", "chrome");
        }

        String baseUrl = ConfigReader.getProperty("base.url");

        logger.info("Starting browser setup (browser property: {})", browser);
        driver = DriverFactory.createDriver(browser);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        driver.manage().window().maximize();

        logger.info("navigating to base url: {}", baseUrl);
        driver.get(baseUrl);
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            logger.info("Closing browser and tearing down driver");
            driver.quit();
        }
    }
        public WebDriver getDriver() {
            return driver;
        }
}