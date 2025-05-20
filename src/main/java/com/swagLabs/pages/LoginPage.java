package com.swagLabs.pages;
import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    //URL
    private final String url = "https://www.saucedemo.com/";
    //Locators
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.id("login-button");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Navigation
    public void navigateToLoginPage(String url) {
        BrowserActions.openUrl(driver, this.url);
    }

    //Actions > wait > scroll > find > sendKeys
    public void enterUsername(String username) {
        ElementActions.sendKeys(driver, this.username, username);
    }
    public void enterPassword (String password) {
        ElementActions.sendKeys(driver, this.password, password);
    }
    public void clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
    }

    //Validations


}
