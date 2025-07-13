package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManger;
import com.swagLabs.listeners.TestNGListeners;
import com.swagLabs.pages.LoginPage;

import com.swagLabs.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class LoginTest {
    JsonUtils testData;
    WebDriver driver;
    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSuccessfulLogin();
    }

    //Configurations
    @BeforeClass
    public void beforeClass() {
        testData = new JsonUtils("test-data");
    }

    @BeforeMethod
    public void setup() {
        driver = DriverManger.createInstance();
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        BrowserActions.closeBrowser(driver);
    }
}
