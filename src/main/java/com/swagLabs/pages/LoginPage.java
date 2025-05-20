package com.swagLabs.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Locators
    private final WebDriver driver;
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.id("login-button");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions > wait > scroll > find > sendKeys
    public void enterUsername(String username) {
        //wait for the element to be visible
        //scroll to the element
        driver.findElement(this.username).sendKeys(username);
    }

    //Validations

}
