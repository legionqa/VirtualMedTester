package com.legion.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    static Properties properties = new Properties();

    public void loadProperties() {
        try {
            // Load the properties file
            InputStream inputStream = Properties.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties.isEmpty()) {
            new PropertiesUtil().loadProperties();
        }
        return properties.getProperty(key);
    }


}
