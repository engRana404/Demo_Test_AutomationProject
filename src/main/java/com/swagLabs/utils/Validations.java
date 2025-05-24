package com.swagLabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations(){
        // Prevent instantiation
    }

    // Validation methods
    @Step("Validate condition: {condition} with message: {message}")
    public static void validationTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }
    @Step("Validate condition: {condition} with message: {message}")
    public static void validationFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
    @Step("Validate actual: {actual} equals expected: {expected} with message: {message}")
    public static void validationEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
    @Step("Validate actual: {actual} not equals expected: {expected} with message: {message}")
    public static void validationNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }
    @Step("Validate actual: {actual} contains expected: {expected} with message: {message}")
    public static void validatePageURL(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expectedUrl, "URL does not match");
    }
    @Step("Validate actual: {actual} contains expected: {expected} with message: {message}")
    public static void validatePageTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expectedTitle, "Title does not match");
    }
}
