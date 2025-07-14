package com.swagLabs.pages;

import com.swagLabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage {
    // Variables
    private final WebDriver driver;
    String infoPageURL = PropertiesUtils.getPropertyValue("InfoPageURL");

    // Locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    // Constructor
    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Navigate to Info Page")
    public InfoPage navigateToInfoPage() {
        LogsUtil.info("Navigating to Info Page: " + this.infoPageURL);
        BrowserActions.openUrl(driver, this.infoPageURL);
        return this;
    }

    @Step("Fill info form with first name: {firstName}, last name: {lastName}, postal code: {postalCode}")
    public InfoPage fillInfoForm(String firstName, String lastName, String postalCode) {
        ElementActions.sendKeys(driver, this.firstName, firstName);
        ElementActions.sendKeys(driver, this.lastName, lastName);
        ElementActions.sendKeys(driver, this.postalCode, postalCode);
        return this;
    }

    @Step("Click on continue button")
    public InfoPage clickContinueButton() {
        LogsUtil.info("Clicking on continue button");
        ElementActions.clickElement(driver, continueButton);
        return this;
    }

    // Validations
    @Step("Assert Information Form")
    public InfoPage assertInformationForm(String firstName, String lastName, String postalCode) {
        LogsUtil.info("Asserting Information Form");
        String actualFirstName = ElementActions.getValue(driver, this.firstName);
        String actualLastName = ElementActions.getValue(driver, this.lastName);
        String actualPostalCode = ElementActions.getValue(driver, this.postalCode);

        CustomSoftAssertions.softAssertions.assertEquals(actualFirstName, firstName, "First name does not match");
        CustomSoftAssertions.softAssertions.assertEquals(actualLastName, lastName, "Last name does not match");
        CustomSoftAssertions.softAssertions.assertEquals(actualPostalCode, postalCode, "Postal code does not match");

        return this;
    }


}
