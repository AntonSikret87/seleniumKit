package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class StylusPage extends StylusBasePage {

    private WebElement searchField;
    By searchFieldLocator = By.name("q");

    public StylusPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillAndSubmitSearchData(String searchText) {
        searchField = webDriverUtil.waitForExpectedCondition(
                ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        //searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
