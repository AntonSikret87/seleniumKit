package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class StylusSearchResultPage extends StylusBasePage {

    By linkLocator = By.xpath(".//*[@id='search-list']//span[text() ='Смартфон Sony Xperia Z2 Black']");
    private WebElement firstLink;

    public StylusSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextLink() {
        firstLink = webDriver.findElement(linkLocator);
        return firstLink.getText();
    }

    public void clickLink(){
        firstLink.click();
    }
    public String getActualUrl() {
        String actualURL = webDriver.getCurrentUrl();
        return actualURL;
    }
}
