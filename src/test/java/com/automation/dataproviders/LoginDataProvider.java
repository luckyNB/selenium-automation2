package com.automation.dataproviders;

import com.automation.pojos.TestData;
import com.automation.pojos.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {
    @da
    public Iterator<Object[]> LoginDataProvider() {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "/testData/loginTestData.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(testDataFile);
            TestData testData = gson.fromJson(fileReader, TestData.class);
            List<Object[]> dataToReturn = new ArrayList<Object[]>();
            for (User user : testData.getUsers()) {
                dataToReturn.add(new Object[]{user});
            }

            return dataToReturn.iterator();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
