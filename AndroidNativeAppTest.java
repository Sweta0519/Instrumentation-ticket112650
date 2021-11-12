package com.realdevice.unifiedplatform;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidNativeAppTest {
    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };
    @Rule
    public SauceTestWatcher resultReportingTestWatcher = new SauceTestWatcher();
    public AppiumDriver<MobileElement> driver;

    private DesiredCapabilities caps;

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @Before
    public void setup(){
   
        caps = DesiredCapabilities.android();
        caps.setCapability("deviceName", ".*Galaxy.*");
        caps.setCapability("deviceOrientation", "potrait");
        caps.setCapability("app", "storage:310051cc-3059-4ba6-b80e-0bf190ce140d");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("platformName","Android");
        caps.setCapability("browserName", "");
        caps.setCapability("appPackage", "com.grabtaxi.passenger");
        caps.setCapability("resigningEnabled", "false");
        caps.setCapability("sauceLabsImageInjectionEnabled", "false");
        caps.setCapability("newCommandTimeout", "90");
       caps.setCapability("noReset", "false");
    }

    @Test
    public void shouldOpenApp() throws MalformedURLException {

        driver = new AndroidDriver<>(
                new URL("https://USERNAME:ACCESSKEY@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                caps);
      
        resultReportingTestWatcher.setDriver(driver);

   
        WebDriverWait wait = new WebDriverWait(getDriver(), 10000);
        By usernameLocator = MobileBy.AccessibilityId("test-Username");
   
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
    }
}

    
