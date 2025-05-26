package com.swagLabs.tests;

import com.swagLabs.drivers.BrowserFactory;
import com.swagLabs.drivers.DriverManger;
import com.swagLabs.pages.LoginPage;

import com.swagLabs.utils.AllureUtils;
import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.FilesUtils;
import com.swagLabs.utils.ScreenshotsUtils;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {
    private final String url = "https://www.saucedemo.com/";
    private final String username = "standard_user";
    private final String password = "secret_sauce";

    File allureResultsDir = new File("test-outputs/allure-results");
    File LogsDir = new File("test-outputs/Logs");

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(DriverManger.getDriver()).enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertSuccessfulLogin();
        ScreenshotsUtils.takeScreenshot("successfulLogin");
    }

    @BeforeSuite
    public void beforeSuite() {
        FilesUtils.deleteFiles(allureResultsDir);
        FilesUtils.deleteFiles(LogsDir);
    }

    //Configurations
    @BeforeMethod
    public void setup() {
        DriverManger.createInstance(BrowserFactory.BrowserType.FIREFOX);
        new LoginPage(DriverManger.getDriver()).navigateToLoginPage(url);
    }

    @AfterMethod
    public void tearDown() {
        BrowserActions.closeBrowser(DriverManger.getDriver());
    }

    @AfterClass
    public void afterClass() {
        AllureUtils.attachLogsToAllureReport();
    }
}
