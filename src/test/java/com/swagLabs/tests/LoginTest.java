package com.swagLabs.tests;

import com.swagLabs.drivers.BrowserFactory;
import com.swagLabs.drivers.DriverManger;
import com.swagLabs.pages.LoginPage;
import com.swagLabs.utils.CustomSoftAssertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private final String url = "https://www.saucedemo.com/";
    private final String username = "standard_user";
    private final String password = "secret_sauce";

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(DriverManger.getDriver()).enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertSuccessfulLogin();
    }

    //Configurations
    @BeforeMethod
    public void setup() {
        DriverManger.createInstance(BrowserFactory.BrowserType.FIREFOX);
        new LoginPage(DriverManger.getDriver()).navigateToLoginPage(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverManger.getDriver().quit();
    }
}
