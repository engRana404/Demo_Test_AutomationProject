package com.swagLabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions () {
        // Prevent instantiation
    }

    //sendKeys
    @Step("Enter data: {text} in element: {locator}")
    public static void sendKeys(WebDriver driver, By locator, String text) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(text);
        LogsUtil.info("Data entered: " + text + " in element: " + locator.toString());
    }

    //click
    @Step("Click on element: {locator}")
    public static void clickElement(WebDriver driver, By locator){
        WebElement element = Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
        LogsUtil.info("Clicked on element: " + locator.toString());
    }

    //Get text
    @Step("Get text from element: {locator}")
    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtil.info("Getting text from element: " + locator.toString());
        return findElement(driver, locator).getText();
    }

    //Find element
    public static WebElement findElement(WebDriver driver, By locator) {
        LogsUtil.info("Finding element: " + locator.toString());
        return driver.findElement(locator);
    }
}