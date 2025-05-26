package com.swagLabs.utils;

import com.swagLabs.drivers.DriverManger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotsUtils {
    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots";

    private ScreenshotsUtils() {
        // Prevent instantiation
        super();
    }

    public static void takeScreenshot(String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) DriverManger.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + ".png");
            FilesUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenshotToAllureReport(screenshotName, screenshotFile.getAbsolutePath());
            LogsUtil.info("Screenshot taken: " + screenshotName);
        }
        catch (Exception e) {
            LogsUtil.error("Failed to take screenshot: " + e.getMessage());
        }
    }
}
