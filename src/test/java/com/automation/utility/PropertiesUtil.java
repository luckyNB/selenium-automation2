package com.automation.utility;

import com.automation.constants.Env;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static String readProperties(Env env, String propertyName) {

        File profFile = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(profFile);
            Properties properties = new Properties();
            properties.load(fileReader);
            System.out.println("Reading property: " + propertyName + " from " + env + ".properties file.");
            System.out.println("Property value: " + properties.getProperty(propertyName));
            return (properties.getProperty(propertyName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
