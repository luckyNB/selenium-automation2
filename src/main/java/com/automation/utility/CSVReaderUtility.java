package com.automation.utility;

import com.automation.pojos.User;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSV() {
        File csvFile = new File(System.getProperty("user.dir") + "/config/config.json");
        FileReader fileReader = null;
        List<User> userArrayList = new ArrayList<>();
        String[] line;
        User userData = null;
        try {
            fileReader = new FileReader(csvFile);
            CSVReader csvReader = new CSVReader(fileReader);
            while ((line = csvReader.readNext()) != null) {
                userData = new User();
                userData.setEmailAddress(line[0]);
                userData.setPassword(line[1]);
                userArrayList.add(userData);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return userArrayList.iterator();
    }
}

