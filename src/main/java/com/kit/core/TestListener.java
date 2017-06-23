package com.kit.core;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by AntonKa on 6/23/2017.
 */
public class TestListener implements ITestListener {
    private WebDriver webDriver;
    private WebDriverUtil webDriverUtil;
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        webDriver = ((WebDriverTestBase) iTestResult.getInstance()).webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
        webDriverUtil.saveScreenshot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
