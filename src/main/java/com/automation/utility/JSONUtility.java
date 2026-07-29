package com.automation.utility;

import com.automation.pojos.Config;
import com.automation.pojos.Environment;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {
    public static String readJSON() {
        Gson gson = new Gson();

        BufferedReader jsonFile = null;
        try {
            jsonFile = new BufferedReader(
                    new FileReader(System.getProperty("user.dir") + "/config/config.json")
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Config config = gson.fromJson(jsonFile, Config.class);

        System.out.println("Config object: " + config.getEnvironments());

        Environment environment = config.getEnvironments().get("DEV");
        return environment.getUrl();
    }
}
