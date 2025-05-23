package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
        // Prevent instantiation
    }

    // Method to open a URL
    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    //Get current URL
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //Get page title
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    //Refresh page
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

}
