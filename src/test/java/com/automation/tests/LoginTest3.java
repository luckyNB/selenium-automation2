package com.automation.tests;

import static com.automation.constants.Browser.*;

import com.automation.pages.HomePage;
import com.automation.pojos.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest3 {
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "Login Test with username and password", dataProvider = "LoginDataProvider", dataProviderClass = com.automation.dataproviders.LoginDataProvider.class)
    public void loginTest(User user) throws InterruptedException {
        Assert.assertEquals(homePage.clickOnSignInLink()
                .doLoginWithCredentials(user.getEmailAddress(), user.getPassword())
                .getUserNameOnMyAccountPage(), "Laxman Patil Bhosale");
        homePage.closeBrowser();
    }
}