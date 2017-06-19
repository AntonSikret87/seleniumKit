package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class GoogleSearchResultPage extends GoogleBasePage{

    By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebElement firstLink;

    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextLink() {
        firstLink = webDriver.findElement(linkLocator);
        return firstLink.getText();
    }
}
