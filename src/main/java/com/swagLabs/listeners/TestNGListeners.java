package com.swagLabs.listeners;

import com.swagLabs.utils.FilesUtils;
import com.swagLabs.utils.LogsUtil;
import com.swagLabs.utils.PropertiesUtils;
import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGListener;

import java.io.File;

public class TestNGListeners implements IExecutionListener, ITestNGListener, IInvokedMethodListener {
    File allureResultsDir = new File("test-outputs/allure-results");
    File LogsDir = new File("test-outputs/Logs");
    File screenshotsDir = new File("test-outputs/screenshots");

    @Override
    public void onExecutionStart() {
        // Code to execute before the test execution starts
        LogsUtil.info("Test execution started.");
        PropertiesUtils.loadProperties();
        // For Log4j 2
        org.apache.logging.log4j.LogManager.shutdown();
        FilesUtils.deleteFiles(allureResultsDir);
        FilesUtils.cleanDirectory(LogsDir);
        FilesUtils.cleanDirectory(screenshotsDir);
    }


}
