package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((tests.BaseTest) result.getInstance()).getDriver();

        if (driver != null) {
            String screenshotDir = getScreenshotDir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = result.getName() + "_" + timeStamp + ".png";

            File directory = new File(screenshotDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destFile = new File(directory, screenshotName);
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                logger.error("Test failed: {}", result.getName());
                logger.error("Screenshot saved at: {}", destFile.getAbsolutePath());
            } catch (IOException e) {
                logger.error("Failed to save screenshot: {}", e.getMessage(), e);
            }
        }
    }

    private String getScreenshotDir() {
        Properties properties = new Properties();
        try (var stream = TestListener.class.getClassLoader().getResourceAsStream ("framework.properties")) {
            properties.load(stream);
            return properties.getProperty("screenshots.folder", "target/screenshots");
        } catch (IOException e) {
            logger.warn("Could not read framework.properties, using default path target/screenshots");
            return "target/screenshots";
        }
    }
}