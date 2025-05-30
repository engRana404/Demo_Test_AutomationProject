package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private static final int DEFAULT_TIMEOUT = 10;

    private Waits() {
        // Prevent instantiation
    }

    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be present: " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be visible: " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be clickable: " + locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
