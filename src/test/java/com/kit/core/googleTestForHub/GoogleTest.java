package com.kit.core.googleTestForHub;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

    private WebDriver driver;

    @Parameters({ "platform","browser"})
    @BeforeTest(alwaysRun=true)
    public void setup(String platform, String browser) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        if(platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(Platform.WIN8_1);
            caps.setBrowserName(browser);
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test(description="Test Google")
    public void testGoogle() throws InterruptedException {
        driver.get("https://www.google.com.ua");
    }
}
