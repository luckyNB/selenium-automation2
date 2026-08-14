package com.automation.listerners;


import com.automation.constants.Env;
import com.automation.utility.PropertiesUtil;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements org.testng.IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.QA,"MAX_NUMBER_OF_ATTEMPTS")); // Set the maximum number of attempts
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
            currentAttempt++;
            return true; // Retry the test
        }
        return false;
    }
}
