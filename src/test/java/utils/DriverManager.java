package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver == null){
            String browser = ConfigReader.getProperty("browser");
            driver = DriverFactory.createDriver(browser);
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
