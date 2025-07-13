package com.swagLabs.pages;
import com.swagLabs.utils.*;
import io.qameta.allure.Step;
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
    @Step("Navigate to Cart Page")
    public CartPage navigateToCartPage() {
        LogsUtil.info("Navigating to Cart Page: " + this.cartPageURL);
        BrowserActions.openUrl(driver, this.cartPageURL);
        return this;
    }

    @Step("Get item name of the item from cart")
    private String getItemName() {
        LogsUtil.info("Getting item name from cart");
        return ElementActions.getText(driver, iteamName);
    }

    @Step("Get item price of the item from cart")
    private String getItemPrice() {
        LogsUtil.info("Getting item price from cart");
        return ElementActions.getText(driver, iteamPrice);
    }

    @Step("Click on checkout button")
    public CartPage clickCheckoutButton() {
        LogsUtil.info("Clicking on checkout button");
        ElementActions.clickElement(driver, checkoutButton);
        return this;
    }

    // Validations
    @Step("Assert successful cart item details")
    public CartPage assertCartItemDetails(String expectedItemName, String expectedItemPrice) {
        LogsUtil.info("Asserting cart item details");
        String actualItemName = getItemName();
        String actualItemPrice = getItemPrice();

        CustomSoftAssertions.softAssertions.assertEquals(actualItemName, expectedItemName, "Item name does not match");
        CustomSoftAssertions.softAssertions.assertEquals(actualItemPrice, expectedItemPrice, "Item price does not match");
        return this;
    }
}
