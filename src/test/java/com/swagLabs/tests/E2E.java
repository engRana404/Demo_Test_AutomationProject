package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManger;
import com.swagLabs.listeners.TestNGListeners;
import com.swagLabs.pages.CartPage;
import com.swagLabs.pages.HomePage;
import com.swagLabs.pages.LoginPage;

import com.swagLabs.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class E2E {
    JsonUtils testData;
    WebDriver driver;

    //Configurations
    @BeforeClass
    public void beforeClass() {
        testData = new JsonUtils("test-data");
        driver = DriverManger.createInstance();
        new LoginPage(driver).navigateToLoginPage();
    }

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSuccessfulLogin();
    }

    @Test(dependsOnMethods = "successfulLogin")
    public void AddProductToCart() {
        String productName = testData.getJsonData("products.item1.name");
        new HomePage(driver)
                .AddProductToCart(productName)
                .assertSuccessfulAddToCart(testData.getJsonData(productName));
    }

    @Test(dependsOnMethods = "AddProductToCart")
    public void navigateToCartAndCheckout() {
        String productName = testData.getJsonData("products.item1.name");
        String productPrice = testData.getJsonData("products.item1.price");
        new HomePage(driver)
                .clickCartIcon();
        new CartPage(driver)
                .assertCartItemDetails(productName, productPrice)
                .clickCheckoutButton();
    }

    @AfterSuite
    public void tearDown() {
        BrowserActions.closeBrowser(driver);
    }
}
