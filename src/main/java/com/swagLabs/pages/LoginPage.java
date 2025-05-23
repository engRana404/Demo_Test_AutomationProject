package com.swagLabs.pages;

import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.CustomSoftAssertions;
import com.swagLabs.utils.ElementActions;
import com.swagLabs.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;

    private final String url = "https://www.saucedemo.com/";
    private final String successfulUrl = "https://www.saucedemo.com/inventory.html";
    private final String title = "Swag Labs";

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
    public void navigateToLoginPage(String url) {
        BrowserActions.openUrl(driver, this.url);
    }

    //Actions > wait > scroll > find > sendKeys
    public LoginPage enterUsername(String username) {
        ElementActions.sendKeys(driver, this.username, username);
        return this;
    }
    public LoginPage enterPassword (String password) {
        ElementActions.sendKeys(driver, this.password, password);
        return this;
    }
    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    //Get Error Message
    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }

    //Validations
    public LoginPage assertLoginPageURL() {
        CustomSoftAssertions.softAssertions.assertEquals(BrowserActions.getCurrentUrl(driver), successfulUrl, "URL does not match");
        return this;
    }

    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertions.softAssertions.assertEquals(BrowserActions.getPageTitle(driver), title, "Title does not match");
        return this;
    }

    public LoginPage assertSuccessfulLoginSoftAssertions() {
        assertLoginPageURL()
                .assertLoginPageTitle();
        return this;
    }

    public LoginPage assertSuccessfulLogin() {
        Validations.validatePageURL(driver, successfulUrl);
        return this;
    }
    public LoginPage assertUnsuccessfulLogin() {
        Assert.assertEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Login Unsuccessful");
        return this;
    }

}
