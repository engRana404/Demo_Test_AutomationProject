package com.swagLabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class BrowserFactory {
    public enum BrowserType { CHROME, FIREFOX, EDGE }

    private static void addCommonArguments(ChromeOptions options) {
        options.addArguments("start-maximized", "disable-infobars", "--disable-extensions", "--disable-notifications", "--remote-allow-origins=*");
    }

    private static void addCommonArguments(FirefoxOptions options) {
        options.setAcceptInsecureCerts(true);
    }

    private static void addCommonArguments(EdgeOptions options) {
        options.addArguments("start-maximized", "disable-infobars", "--disable-extensions", "--disable-notifications", "--remote-allow-origins=*");
    }

    public static WebDriver getBrowser(BrowserType browserType) {
        WebDriver driver = null;
        switch (browserType) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                addCommonArguments(options);
                Map<String, Object> prefs = Map.of("profile.default_content_setting_values.notifications", 2,
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false,
                    "autofill.profile_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                addCommonArguments(firefoxOptions);
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.setAcceptInsecureCerts(true);
                //firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                addCommonArguments(edgeOptions);
                Map<String, Object> edgePrefs = Map.of("profile.default_content_setting_values.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);
                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        return driver;
    }
}
