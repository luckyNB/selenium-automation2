package com.automation.pages;

import com.automation.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {
    static final By EMAIL_INPUT_LOCATOR = By.id("email");
    static final By PASSWORD_INPUT_LOCATOR = By.id("passwd");
    static final By LOGIN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public MyAccountPage doLoginWithCredentials(String testuser, String testpassword) throws InterruptedException {
        System.out.println("Entering credentials and clicking on Login button...");
        Thread.sleep(5000);
        typeText(testuser, EMAIL_INPUT_LOCATOR);
        System.out.println("Entered username: " + testuser);
        typeText(testpassword, PASSWORD_INPUT_LOCATOR);
        System.out.println("Entered password: " + testpassword);
        clickOnButton(LOGIN_IN_BUTTON_LOCATOR);
        System.out.println("Clicked on Login button.");
        System.out.println("Login successful. Navigated to My Account Page.");
        return new MyAccountPage(this.driver);
    }
}
