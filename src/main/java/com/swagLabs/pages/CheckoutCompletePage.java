package com.swagLabs.pages;

import com.swagLabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    // Variables
    private WebDriver driver;

    String checkoutCompletePageURL = PropertiesUtils.getPropertyValue("CheckoutCompletePageURL");

    // Locators
    private final By completeHeader = By.className("complete-header");
    private final By backHomeButton = By.id("back-to-products");

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Navigate to Checkout Complete Page")
    public CheckoutCompletePage navigateToCheckoutCompletePage() {
        LogsUtil.info("Navigating to Checkout Complete Page: " + this.checkoutCompletePageURL);
        BrowserActions.openUrl(driver, this.checkoutCompletePageURL);
        return this;
    }

    @Step("Get Complete Text")
    public String getCompleteHeader() {
        return ElementActions.getText(driver, completeHeader);
    }

    @Step("Click Back Home Button")
    public HomePage clickBackHomeButton() {
        ElementActions.clickElement(driver, backHomeButton);
        return new HomePage(driver);
    }

    //Validation
    @Step("Validate Complete Text")
    public void ValidateCheckout(String expectedText) {
        String actualText = getCompleteHeader();
        Validations.validationEquals(actualText, expectedText,"Complete text does not match expected value: " + expectedText);

        LogsUtil.info("Validation successful: " + actualText);
    }
}
