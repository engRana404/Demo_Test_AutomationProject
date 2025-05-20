package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Scrolling {
    private Scrolling() {
        // Prevent instantiation
    }

    //scroll to the element
    public static void scrollToElement(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
}
