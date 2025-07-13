package com.swagLabs.pages;

import com.swagLabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    //Variables
    private WebDriver driver;
    String HomePageURL = PropertiesUtils.getPropertyValue("HomePageURL");

    //Locators
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public HomePage navigateToHomePage() {
        LogsUtil.info("Navigating to Home Page: " + this.HomePageURL);
        BrowserActions.openUrl(driver, this.HomePageURL);
        return this;
    }

    public HomePage AddProductToCart(String productName) {
        LogsUtil.info("Adding product to cart: " + productName);
        // Locate the "Add to Cart" button relative to the product name
        By AddToCartButton = RelativeLocator.with(By.tagName("button"))
                .below(By.xpath("//div[.='" + productName + "']"));
        ElementActions.clickElement(driver, AddToCartButton);
        return this;
    }

    public HomePage clickCartIcon() {
        LogsUtil.info("Clicking on cart icon");
        ElementActions.clickElement(driver, cartIcon);
        return this;
    }

    //validations
    public HomePage assertSuccessfulAddToCart(String productName) {
        LogsUtil.info("Asserting successful addition of product to cart: " + productName);
        String badgeText = ElementActions.getText(driver, cartBadge);
        if (badgeText.equals("1")) {
            LogsUtil.info("Product added to cart successfully: " + productName);
        } else {
            throw new AssertionError("Product not added to cart: " + productName);
        }
        return this;
    }

}
