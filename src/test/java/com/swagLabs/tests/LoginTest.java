package com.swagLabs.tests;

import com.swagLabs.pages.LoginPage;
import com.swagLabs.utils.CustomSoftAssertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    //Variable
    private WebDriver driver;
    private final String url = "https://www.saucedemo.com/";
    private final String username = "standard_user";
    private final String password = "secret_sauce";

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver).enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertSuccessfulLoginSoftAssertions();
    }

    //Configurations
    @BeforeMethod
    public void setup() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        driver = new EdgeDriver(edgeOptions);
        new LoginPage(driver).navigateToLoginPage(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        CustomSoftAssertions.customAssertAll();
    }


}
