package com.swagLabs.drivers;

import com.swagLabs.utils.LogsUtil;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManger {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManger() {
        super();
    }

    public static WebDriver createInstance(BrowserFactory.BrowserType browser) {
        LogsUtil.info("Launching browser: " + browser);
        WebDriver driver = BrowserFactory.getBrowser(browser);
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
