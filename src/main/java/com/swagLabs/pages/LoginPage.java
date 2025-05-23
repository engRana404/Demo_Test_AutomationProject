package com.swagLabs.pages;

import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;
    //URL
    private final String url = "https://www.saucedemo.com/";
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
    public LoginPage assertSuccessfulLogin() {
       Assert.assertEquals(BrowserActions.getCurrentUrl(driver), "https://www.saucedemo.com/inventory.html", "Login Successful");
        return this;
    }
    public LoginPage assertUnsuccessfulLogin() {
        Assert.assertEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Login Unsuccessful");
        return this;
    }

}
