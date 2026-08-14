package com.automation.tests;

import com.automation.constants.Browser;
import com.automation.pages.HomePage;
import com.automation.utility.BrowserUtility;
import com.automation.utility.LambdaTestUtlity;
import com.automation.utility.LoggerUtlity;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {


    protected HomePage homePage;
    Logger logger = LoggerUtlity.getLogger(this.getClass());
    private boolean isLambdaTest;

    @BeforeMethod(description = "Load the Homepage of the website")
    @Parameters({ "browser", "isLambdaTest", "isHeadless" })

    public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
                      @Optional("false") boolean isHeadless, ITestResult result) {

        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver;
        if (isLambdaTest) {

            lambdaDriver = LambdaTestUtlity.intializeLambdaTestSession("chrome", result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);

        } else {
            // Running the test on local machine!!!
            logger.info("Load the Homepage of the website");
            homePage = new HomePage(Browser.valueOf("chrome".toUpperCase()), isHeadless);

        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {

        if (isLambdaTest) {
            LambdaTestUtlity.quitSession(); // quit or close the browsersession on LT
        } else {
            homePage.quit(); // local
        }
    }

}
