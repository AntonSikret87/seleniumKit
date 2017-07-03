package com.kit.util;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by AntonKa on 6/16/2017.
 */
public class WebDriverUtil {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    public Actions actions;
    private JavascriptExecutor JSexecutor;


    long waitExplicit = Long.parseLong(PropertiesCache.getProperty("wait.explicit"));


    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, waitExplicit);
        actions = new Actions(webDriver);
    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition){
        return (WebElement)webDriverWait.until(expectedCondition);
    }

    public void jsClickByElement(WebElement element) {
        JSexecutor = (JavascriptExecutor) webDriver;
        JSexecutor.executeScript("arguments[0].click();", element);
    }

    public void jsClickByIdOrName(String locator, String type) {
        JSexecutor = (JavascriptExecutor) webDriver;
        switch (type){
            case "id":{
                JSexecutor.executeScript("document.getElementById(\"" + locator + "\").click()");
                break;
            }
            case "name":{
                JSexecutor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()");
                break;
            }
        }
    }


    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String attachName) {
        try {
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }
        return new byte[0];
    }

 }
