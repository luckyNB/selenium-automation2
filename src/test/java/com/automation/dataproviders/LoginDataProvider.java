package com.automation.dataproviders;

import com.automation.pojos.TestData;
import com.automation.pojos.User;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginDataProvider {
    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider() {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "/testData/loginTestData.json");

        try (FileReader fileReader = new FileReader(testDataFile)) {

            TestData testData = gson.fromJson(fileReader, TestData.class);

            if (testData == null || testData.getUsers() == null) {
                throw new RuntimeException("User list is NULL → JSON does not match TestData POJO");
            }

            List<Object[]> dataToReturn = new ArrayList<>();
            for (User user : testData.getUsers()) {
                dataToReturn.add(new Object[]{user});
            }

            return dataToReturn.iterator();
        } catch (Exception e) {
            throw new RuntimeException("Error loading JSON Test Data → " + e);
        }
    }

}