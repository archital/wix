package com.wix.autotestapp.core;

/**
 * Created by archi on 5/9/2018.
 * PropertiesLoader is to load /resources/config.properties
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesLoader {

    private PropertiesLoader() {
    }

    public static Properties uploadPropertiesFile(String filename) throws ClassNotFoundException {
        Properties property = new Properties();
        ClassLoader loader = Class.forName(PropertiesLoader.class.getName()).getClassLoader();
        try (InputStream fileInputStreamWithConfigFile = loader.getResourceAsStream(filename)) {
            property.load(fileInputStreamWithConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}

