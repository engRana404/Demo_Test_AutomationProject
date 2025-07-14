package com.swagLabs.pages;
import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.ElementActions;
import com.swagLabs.utils.LogsUtil;
import com.swagLabs.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    // Variables
    private final WebDriver driver;
    String overviewPageURL = PropertiesUtils.getPropertyValue("OverviewPageURL");

    // Locators
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    // Constructor
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Navigate to Overview Page")
    public OverviewPage navigateToOverviewPage() {
        LogsUtil.info("Navigating to Overview Page: " + this.overviewPageURL);
        BrowserActions.openUrl(driver, this.overviewPageURL);
        return this;
    }

    @Step("Click on Finish button")
    public OverviewPage clickFinishButton() {
        LogsUtil.info("Clicking on Finish button");
        ElementActions.clickElement(driver, finishButton);
        return this;
    }

    @Step("Click on Cancel button")
    public OverviewPage clickCancelButton() {
        LogsUtil.info("Clicking on Cancel button");
        ElementActions.clickElement(driver, cancelButton);
        return this;
    }
}
