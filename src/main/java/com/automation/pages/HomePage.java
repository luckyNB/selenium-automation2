package com.automation.pages;

import com.automation.constants.Browser;
import static com.automation.constants.Env.*;
import static java.sql.DriverManager.getDriver;

import com.automation.utility.BrowserUtility;
import com.automation.utility.JSONUtility;
import com.automation.utility.LoggerUtlity;
import com.automation.utility.PropertiesUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    Logger logger = LoggerUtlity.getLogger(this.getClass());

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

    public HomePage(Browser browser, boolean isHeadless) {
        super(browser, isHeadless); // To Call the Parent Class constructor from the child constructor
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver); // To Call the Parent Class constructor from the child constructor
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage() { // Page Functions------> cannot use void!!!
        logger.info("Trying to performing click to go to Sign in Page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
