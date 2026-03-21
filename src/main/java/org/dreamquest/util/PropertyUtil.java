package org.dreamquest.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static final Properties properties = new Properties();

    private PropertyUtil() {
        // prevent object creation
    }

    static {
        loadProperties(); // called once when class is first loaded
    }

    private static void loadProperties() {
        try (InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IllegalStateException("application.properties not found in classpath");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load application.properties", e);
        }
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
