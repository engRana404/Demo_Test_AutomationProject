package com.swagLabs.pages;
import com.swagLabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    // Variables
    private final WebDriver driver;
    String cartPageURL = PropertiesUtils.getPropertyValue("CartPageURL");

    // Locators
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By checkoutButton = By.id("checkout");
    private final By iteamName = By.cssSelector(".inventory_item_name");
    private final By iteamPrice = By.cssSelector(".inventory_item_price");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public CartPage navigateToCartPage() {
        LogsUtil.info("Navigating to Cart Page: " + this.cartPageURL);
        BrowserActions.openUrl(driver, this.cartPageURL);
        return this;
    }

    public CartPage clickCartIcon() {
        LogsUtil.info("Clicking on cart icon");
        ElementActions.clickElement(driver, cartIcon);
        return this;
    }

    public String getItemName() {
        LogsUtil.info("Getting item name from cart");
        return ElementActions.getText(driver, iteamName);
    }

    public String getItemPrice() {
        LogsUtil.info("Getting item price from cart");
        return ElementActions.getText(driver, iteamPrice);
    }

    public CartPage clickCheckoutButton() {
        LogsUtil.info("Clicking on checkout button");
        ElementActions.clickElement(driver, checkoutButton);
        return this;
    }

    // Validations
    public CartPage assertCartItemDetails(String expectedItemName, String expectedItemPrice) {
        LogsUtil.info("Asserting cart item details");
        String actualItemName = getItemName();
        String actualItemPrice = getItemPrice();

        CustomSoftAssertions.softAssertions.assertEquals(actualItemName, expectedItemName, "Item name does not match");
        CustomSoftAssertions.softAssertions.assertEquals(actualItemPrice, expectedItemPrice, "Item price does not match");
        return this;
    }
}
