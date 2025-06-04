package com.swagLabs.pages;

import com.swagLabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;
    String url = PropertiesUtils.getPropertyValue("baseUrl");
    String successfulUrl = PropertiesUtils.getPropertyValue("successfulUrl");
    String title = PropertiesUtils.getPropertyValue("appTitle");

    //Locators
    private final By username = By.name("user-name");
    private final By password = By.name("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=\"error\"]");
    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Navigation
    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        BrowserActions.openUrl(driver, this.url);
    }

    //Actions > wait > scroll > find > sendKeys
    @Step("Enter username: {username}")
    public LoginPage enterUsername(String username) {
        ElementActions.sendKeys(driver, this.username, username);
        return this;
    }
    @Step("Enter password: {password}")
    public LoginPage enterPassword (String password) {
        ElementActions.sendKeys(driver, this.password, password);
        return this;
    }
    @Step("Click on login button")
    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    //Get Error Message
    @Step("Get error message")
    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }

    //Validations
    @Step("Assert login page URL")
    public LoginPage assertLoginPageURL() {
        CustomSoftAssertions.softAssertions.assertEquals(BrowserActions.getCurrentUrl(driver), successfulUrl, "URL does not match");
        return this;
    }

    @Step("Assert login page title")
    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertions.softAssertions.assertEquals(BrowserActions.getPageTitle(driver), title, "Title does not match");
        return this;
    }

    @Step("Assert login page URL and title")
    public LoginPage assertSuccessfulLoginSoftAssertions() {
        assertLoginPageURL()
                .assertLoginPageTitle();
        return this;
    }

    @Step("Assert successful login")
    public LoginPage assertSuccessfulLogin() {
        Validations.validatePageURL(driver, successfulUrl);
        return this;
    }

    @Step("Assert unsuccessful login")
    public LoginPage assertUnsuccessfulLogin() {
        Assert.assertEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Login Unsuccessful");
        return this;
    }
}
