package com.automation.tests;

import static org.testng.Assert.assertEquals;

import com.automation.pojos.User;
import com.automation.utility.LoggerUtlity;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTestWithDataDriven extends TestBase{

    Logger logger = LoggerUtlity.getLogger(this.getClass());

    @Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
                "Laxman Patil Bhosle");
    }

    @Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
                "Laxman Patil Bhosle");
    }

    @Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.automation.listerners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user) {

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
                "Laxman Patil Bhosle");
        homePage.quit();

    }
}