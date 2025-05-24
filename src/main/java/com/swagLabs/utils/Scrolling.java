package com.swagLabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Scrolling {
    private Scrolling() {
        // Prevent instantiation
    }

    //scroll to the element
    @Step("Scroll to element: {locator}")
    public static void scrollToElement(WebDriver driver, By locator) {
        LogsUtil.info("Scrolling to element: " + locator.toString());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ElementActions.findElement(driver, locator));
    }
}
