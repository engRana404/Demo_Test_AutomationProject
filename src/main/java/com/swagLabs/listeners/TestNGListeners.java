package com.swagLabs.listeners;

import com.swagLabs.utils.*;
import org.apache.commons.io.FileUtils;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestNGListeners implements IExecutionListener, ITestNGListener, IInvokedMethodListener, ITestListener {
    private final File allureResultsDir = new File("test-outputs/allure-results");
    private final File logsDir = new File("test-outputs/Logs");
    private final File screenshotsDir = new File("test-outputs/screenshots");

    @Override
    public void onExecutionStart() {
        LogsUtil.info("Test execution started.");

        // Load properties early
        PropertiesUtils.loadProperties();

        // 🔐 Properly shut down logging to release file locks
        org.apache.logging.log4j.LogManager.shutdown();

        // Now safe to delete and clean folders
        try {
            if (allureResultsDir.exists()) {
                FileUtils.deleteDirectory(allureResultsDir);
                LogsUtil.info("Deleted allure-results directory.");
            }
        } catch (IOException e) {
            LogsUtil.error("Could not delete allure-results directory: " + e.getMessage());
        }

        FilesUtils.cleanDirectory(logsDir);
        FilesUtils.cleanDirectory(screenshotsDir);
    }


    @Override
    public void onExecutionFinish() {
        LogsUtil.info("Test execution finished.");
        // Shutdown logging after everything
        org.apache.logging.log4j.LogManager.shutdown();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (method.isTestMethod()) {
            try {
                CustomSoftAssertions.customAssertAll();
            } catch (AssertionError e) {
                LogsUtil.error("Soft assertions failed: " + e.getMessage());
                result.setStatus(ITestResult.FAILURE);
                result.setThrowable(e);
            }

            switch (result.getStatus()) {
                case ITestResult.SUCCESS:
                    ScreenshotsUtils.takeScreenshot("passed-" + result.getName());
                    break;
                case ITestResult.FAILURE:
                    ScreenshotsUtils.takeScreenshot("failed-" + result.getName());
                    break;
                case ITestResult.SKIP:
                    ScreenshotsUtils.takeScreenshot("skipped-" + result.getName());
                    break;
                default:
                    LogsUtil.warn("Test method " + result.getName() + " finished with status: " + result.getStatus());
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtil.info("Test method " + result.getName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtil.error("Test method " + result.getMethod().getMethodName() + " failed with exception: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ScreenshotsUtils.takeScreenshot("skipped-" + result.getName());
    }
}
