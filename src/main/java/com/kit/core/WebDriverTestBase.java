package com.kit.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class WebDriverTestBase {
    protected WebDriver webDriver;

    @BeforeSuite
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        //close browser
        webDriver.close();
        //close browser's tab
        webDriver.quit();

    }
}
