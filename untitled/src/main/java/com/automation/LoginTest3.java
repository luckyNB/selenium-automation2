package com.automation;

import static com.automation.constants.Browser.*;
import com.automation.pages.HomePage;
public class LoginTest3 {
    public static void main(String[] args) throws InterruptedException {
        HomePage homePage = new HomePage(CHROME);
        System.out.println("Browser launched and navigated to the website.");
        String userName = homePage.clickOnSignInLink().doLoginWithCredentials("laxmanbhosale@test.com", "Test@1234").getUserNameOnMyAccountPage();
        System.out.println("User Name on My Account Page: " + userName);
        homePage.closeBrowser();
    }
}