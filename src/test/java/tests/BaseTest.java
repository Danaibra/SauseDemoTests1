package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeMethod
    public void setup() {
        driver = configureDriver();
        driver.get(ConfigReader.getProperty("base.url"));
    }

    private WebDriver configureDriver() {
        return DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}