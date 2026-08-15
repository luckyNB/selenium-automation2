package com.automation.pages;

import com.automation.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    static final By USERNAME_ONMY_ACCOUNT_PAGE_LOCATOR = By.xpath("//span[contains(text(),'Laxman Patil Bhosle')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public String getUserNameOnMyAccountPage() {
        System.out.println("Retrieving user name on My Account Page...");
        return driver.findElement(USERNAME_ONMY_ACCOUNT_PAGE_LOCATOR).getText();
    }
}
