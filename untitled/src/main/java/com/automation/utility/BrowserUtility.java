package com.automation.utility;

import com.automation.constants.Browser;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

@Getter
public abstract class BrowserUtility {
    protected final WebDriver driver;

    public BrowserUtility(Browser browser) {
        if (browser == Browser.CHROME) {
            this.driver = new ChromeDriver();
        }
        else if (browser == Browser.SAFARI) {
            this.driver = new SafariDriver();
        }
        else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

    }

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void goToWebsite(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void typeText(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
        // Implement the logic to type text into an input field
    }

    public void clickOnButton(By locator) {
        driver.findElement(locator).click();
        // Implement the logic to click on a button
    }

    public void getVisibleText(By locator) {
        String visibleText = driver.findElement(locator).getText();
        System.out.println("Visible Text: " + visibleText);
    }
}
