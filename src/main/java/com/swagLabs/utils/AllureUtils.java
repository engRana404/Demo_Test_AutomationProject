package com.swagLabs.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    private AllureUtils() {
        // Prevent instantiation
        super();
    }

    public static void attachLogsToAllureReport() {
        try {
            File latestLogFile = FilesUtils.getLatestFileFromDir(LogsUtil.LOGS_PATH);
            if (!latestLogFile.exists()) {
                LogsUtil.warn("No log files found in the specified directory: " + LogsUtil.LOGS_PATH);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(latestLogFile.toPath()));
            LogsUtil.info("Attached log file to Allure report: " + latestLogFile.getName());
        } catch (IOException e) {
            LogsUtil.error("Failed to attach log file to Allure report: " + e.getMessage());
        }
    }

    public static void attachScreenshotToAllureReport(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
            LogsUtil.info("Attached screenshot to Allure report: " + screenshotName);
        } catch (IOException e) {
            LogsUtil.error("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }
}
