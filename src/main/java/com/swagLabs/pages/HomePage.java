package com.swagLabs.pages;

import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.ElementActions;
import com.swagLabs.utils.LogsUtil;
import com.swagLabs.utils.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    //Variables
    private WebDriver driver;
    String HomePageURL = PropertiesUtils.getPropertyValue("HomePageURL");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators

    //Actions
    public HomePage navigateToHomePage() {
        LogsUtil.info("Navigating to Home Page: " + this.HomePageURL);
        BrowserActions.openUrl(driver, this.HomePageURL);
        return this;
    }
    public HomePage AddProductToCart(String productName) {
        LogsUtil.info("Adding product to cart: " + productName);
        By AddToCartButton = RelativeLocator.with(By.tagName("button"))
                .below(By.xpath("//div[.='" + productName + "']"));
        ElementActions.clickElement(driver, AddToCartButton);
        return this;
    }

}
