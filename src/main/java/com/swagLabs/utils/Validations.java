package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations(){
        // Prevent instantiation
    }

    // Validation methods
    public static void validationTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }
    public static void validationFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
    public static void validationEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
    public static void validationNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }
    public static void validatePageURL(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expectedUrl, "URL does not match");
    }
    public static void validatePageTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expectedTitle, "Title does not match");
    }
}
