package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
        // Prevent instantiation
    }

    // Method to open a URL
    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
        LogsUtil.info("Opened URL: " + url);
    }

    //Get current URL
    public static String getCurrentUrl(WebDriver driver) {
        LogsUtil.info("Getting current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //Get page title
    public static String getPageTitle(WebDriver driver) {
        LogsUtil.info("Getting page title: ", driver.getTitle());
        return driver.getTitle();
    }

    //Refresh page
    public static void refreshPage(WebDriver driver) {
        LogsUtil.info("Refreshing the page");
        driver.navigate().refresh();
    }

    //Close browser
    public static void closeBrowser(WebDriver driver) {
        LogsUtil.info("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }

}
