package com.automation.utility;

import com.automation.pojos.User;
import com.automation.tests.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName) {
        File csvFile = new File(System.getProperty("user.dir") + "/config/" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList = null;
        User userData;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();

            userList = new ArrayList<User>();

            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        catch (CsvValidationException | IOException e) {

            e.printStackTrace();
        }

        return userList.iterator();
    }

    public static class TestListener implements ITestListener {
        Logger logger = LoggerUtlity.getLogger(this.getClass());

        ExtentSparkReporter extentSparkReporter;
        ExtentReports extentReports;
        ExtentTest extentTest;

        public void onTestStart(ITestResult result) {
            logger.info(result.getMethod().getMethodName());
            logger.info(result.getMethod().getDescription());
            logger.info(Arrays.toString(result.getMethod().getGroups()));
            ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

        }

        public void onTestSuccess(ITestResult result) {
            logger.info(result.getMethod().getMethodName() + " " + "PASSED");
            ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
        }

        public void onTestFailure(ITestResult result) {
            logger.error(result.getMethod().getMethodName() + " " + "FAILED");
            logger.error(result.getThrowable().getMessage());
            ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
            ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

            Object testclass = result.getInstance();

            BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
            logger.info("Capturing Screenshot for the failed tests");

            String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
            logger.info("Attaching the Screenshot to the HTML File");

            ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
        }

        public void onTestSkipped(ITestResult result) {
            logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
            ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

        }

        public void onStart(ITestContext context) {
            logger.info("Test Suite Started");
            ExtentReporterUtility.setupSparkReporter("report.html");
        }

        public void onFinish(ITestContext context) {
            logger.info("Test Suite Completed");
            ExtentReporterUtility.flushReport();
        }
    }
}

