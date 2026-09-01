package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream file = TestDataReader.class.getClassLoader().getResourceAsStream("testdata.properties")) {
            if (file == null) {
                throw new RuntimeException("testdata.properties not found on classpath.");
            }
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testdata.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}