package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * Created by AntonKa on 6/14/2017.
 */
public class SearchResultDefaultPage extends ThomasCookBasePage {

    By firstPaginationLocator = By.id("firstPage");
    private WebElement firstPagePagination;


    public SearchResultDefaultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkPaginationIsDisplayed() {
        firstPagePagination = webDriver.findElement(firstPaginationLocator);
        return firstPagePagination.isDisplayed();
    }
}
