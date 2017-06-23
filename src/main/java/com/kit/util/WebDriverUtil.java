package com.kit.util;

import com.google.common.base.Function;
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


    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 15);
        actions = new Actions(webDriver);
    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition){
        return (WebElement)webDriverWait.until(expectedCondition);
    }

    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 40);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
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
