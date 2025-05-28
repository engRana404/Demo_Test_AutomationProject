package com.swagLabs.drivers;

import com.swagLabs.utils.LogsUtil;
import com.swagLabs.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManger {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static String BrowserType = PropertiesUtils.getPropertyValue("browserType");

    private DriverManger() {
        super();
    }

    @Step("Create driver instance for THE browser")
    public static WebDriver createInstance() {
        if (BrowserType == null) {
            LogsUtil.error("browserType property is not set. Please check your properties files.");
            fail("browserType property is missing. Cannot create WebDriver instance.");
        }
        LogsUtil.info("Launching browser: " + BrowserType);
        WebDriver driver = BrowserFactory.getBrowser(BrowserType);
        LogsUtil.info("Driver created successfully: " + driver);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtil.error("Driver is not initialized. Please call createInstance() before using getDriver().");
            fail("Driver is not set. Please initialize the driver before using it.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
