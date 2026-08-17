package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;

import java.time.Duration;

    public class BaseTest {
        protected static final Logger logger = LogManager.getLogger(BaseTest.class);
        protected WebDriver driver;

        @BeforeMethod
        protected void setup() {
            String browser = getBrowserName();
            String baseUrl = ConfigReader.getProperty("base.url");

            logger.info("Starting browser setup (browser property: {})", browser);
            driver = DriverManager.getDriver();

            configureDriver();

            logger.info("Navigating to base url: {}", baseUrl);
            driver.get(baseUrl);
        }

        @AfterMethod
        protected void tearDown() {
            if (driver != null) {
                logger.info("Closing browser and tearing down driver");
                DriverManager.quitDriver();
                driver = null;
            }
        }

        public WebDriver getDriver() {
            return DriverManager.getDriver();
        }

        private String getBrowserName() {
            String browser = System.getProperty("browser");
            return (browser == null || browser.isEmpty()) ? ConfigReader.getProperty("browser", "chrome") : browser;
        }

        private void configureDriver() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }