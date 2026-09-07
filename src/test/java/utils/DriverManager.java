package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    // each thread is having its own personal WebDriver
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver == null){
            String browser = ConfigReader.getProperty("browser");
            driverThreadLocal.set(DriverFactory.createDriver(browser));
        }
        return driverThreadLocal.get();
    }
    public static void quitDriver(){
        if(driverThreadLocal.get() != null){
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
