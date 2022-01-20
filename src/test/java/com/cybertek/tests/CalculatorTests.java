package com.cybertek.tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CalculatorTests {
    @Test
    public void calculatorTest() throws Exception{
        //
        //=> To specify test setting and required info about device and app under the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");



        //=> this is address of appium server
        // localhost means that appium server is running on your computer
        //if appium server launched on some other computer
        // specify IP/DNS address instead of localhost
        //4723 - default port number of appium server. Can be changed.
        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver<AndroidElement> driver = new AndroidDriver<>(url,desiredCapabilities);

        AndroidElement btn2 = driver.findElement(MobileBy.id("com.android.calculator2:id/digit_2"));
        AndroidElement plusBtn = driver.findElement(MobileBy.AccessibilityId("plus"));
        AndroidElement equalsBtn = driver.findElement(MobileBy.AccessibilityId("equals"));
        AndroidElement resultElement = driver.findElementById("com.android.calculator2:id/result");

        btn2.click();
        plusBtn.click();
        btn2.click();
        equalsBtn.click();


        int expectedResult = 4;
        int actualResult = Integer.parseInt(resultElement.getText());
        Assert.assertEquals(expectedResult,actualResult);

        driver.closeApp();

    }

}
