package com.swagLabs.drivers;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManger {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManger() {
        super();
    }

    public static WebDriver createInstance(BrowserFactory.BrowserType browser) {
        System.out.println("Launching browser: " + browser);
        WebDriver driver = BrowserFactory.getBrowser(browser);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("Driver is not set. Please initialize the driver before using it.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
