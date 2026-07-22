package com.automation;

import com.automation.constants.Browser;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(Browser.SAFARI);
        homePage.clickOnSignInLink();
        LoginPage loginPage = homePage.clickOnSignInLink();
        loginPage.doLoginWithCredentials("laxmanbhosale@test.com", "Test@1234");
        Thread.sleep(5000);
        driver.close();


    }
}