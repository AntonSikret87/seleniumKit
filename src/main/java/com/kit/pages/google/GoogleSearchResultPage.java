package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class GoogleSearchResultPage extends GoogleBasePage{

    By linkLocator = By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a");
    private WebElement firstLink;

//    By clickIconUserLocator = By.id("gbw");
//    private WebElement iconUserElement;
//
//    //.//*[@id='']/div/div/div[2]/div[4]/div[1]/a/span


    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextLink() {
        firstLink = webDriver.findElement(linkLocator);
        return firstLink.getText();
    }

    public  void clickLink(){
        webDriverUtil.jsClickByIdOrName("gb_70", "id");
    }
}
