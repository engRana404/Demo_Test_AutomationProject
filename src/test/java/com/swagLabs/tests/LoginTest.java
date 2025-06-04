package com.swagLabs.tests;

import com.swagLabs.drivers.BrowserFactory;
import com.swagLabs.drivers.DriverManger;
import com.swagLabs.pages.LoginPage;

import com.swagLabs.utils.*;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {
    File allureResultsDir = new File("test-outputs/allure-results");
    File LogsDir = new File("test-outputs/Logs");
    JsonUtils testData;

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(DriverManger.getDriver()).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSuccessfulLogin();
        ScreenshotsUtils.takeScreenshot("successfulLogin");
    }

    //Configurations
    @BeforeSuite
    public void beforeSuite() {
        PropertiesUtils.loadProperties();
        // For Log4j 2
        org.apache.logging.log4j.LogManager.shutdown();
        FilesUtils.deleteFiles(allureResultsDir);
        FilesUtils.deleteFiles(LogsDir);
        testData = new JsonUtils("test-data");
    }

    @BeforeMethod
    public void setup() {
        DriverManger.createInstance();
        new LoginPage(DriverManger.getDriver()).navigateToLoginPage();
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
