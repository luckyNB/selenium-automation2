package com.automation.pages;

import com.automation.constants.Browser;
import com.automation.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

    public HomePage(Browser browser) {
        super(browser);
        goToWebsite("https://automationpractice.techwithjatin.com/");
    }

    public LoginPage clickOnSignInLink() {
        System.out.println("Clicking on Sign In link...");
        clickOnButton(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(this.driver);
        System.out.println("Navigated to Login Page.");
        return  loginPage;
    }
}
