package com.swagLabs.utils;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssertions extends SoftAssert {
    public static CustomSoftAssertions softAssertions = new CustomSoftAssertions();

    public static void customAssertAll() {
        try{
            softAssertions.assertAll("Soft assertions");
        } catch (Exception e) {
            // Handle the exception as needed
            System.out.println("Soft assertions failed: " + e.getMessage());
        }
    }
}
