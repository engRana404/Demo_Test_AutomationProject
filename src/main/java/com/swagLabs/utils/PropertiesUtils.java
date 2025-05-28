package com.swagLabs.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtils {
    public static final String PROPERTIES_FILE_PATH = "src/main/resources";
    private static final Properties properties = new Properties();

    private PropertiesUtils() {
        // Prevent instantiation
    }

    public static String getPropertyValue(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        }
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsUtil.error("Failed to retrieve property: " + e.getMessage());
            return null;
        }
    }

    public static Properties loadProperties() {
        try {
            Collection<File> propertiesFilesList =
                    FileUtils.listFiles(new File(PROPERTIES_FILE_PATH), new String[]{"properties"}, true);

            if (propertiesFilesList.isEmpty()) {
                LogsUtil.info("No properties files found in: " + PROPERTIES_FILE_PATH);
            }

            for (File file : propertiesFilesList) {
                try (InputStream inputStream = new FileInputStream(file)) {
                    properties.load(inputStream);
                    LogsUtil.info("Loaded properties file: " + file.getName());
                } catch (IOException e) {
                    LogsUtil.error("Error reading file " + file.getName() + ": " + e.getMessage());
                }
            }

            return properties;

        } catch (Exception e) {
            LogsUtil.error("Failed to load properties: " + e.getMessage());
            return null;
        }
    }
}