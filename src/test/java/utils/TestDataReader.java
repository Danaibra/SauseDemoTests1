package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties = new Properties();

    static {
        try {
            InputStream file= TestDataReader.class.getClassLoader().getResourceAsStream("testdata.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}