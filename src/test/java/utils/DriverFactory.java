package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName.toLowerCase()) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                return new ChromeDriver(options);
        }
    }
}