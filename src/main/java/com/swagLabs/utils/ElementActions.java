package com.swagLabs.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions () {
        // Prevent instantiation
    }

    //sendKeys
    public static void sendKeys(WebDriver driver, By locator, String text) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(text);
    }

    //click
    public static void clickElement(WebDriver driver, By locator){
        WebElement element = Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
    }

    //Get text
    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }

    //Find element
    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
}
