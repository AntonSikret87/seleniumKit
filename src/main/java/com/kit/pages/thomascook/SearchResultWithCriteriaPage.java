package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/15/2017.
 */
public class SearchResultWithCriteriaPage extends ThomasCookBasePage{

    By destinationLocator =  By.id("SearchbarReadonly-goingTo");
    private WebElement destinatioElement;

    By departureAirportLocator =  By.id("SearchbarReadonly-origin");
    private WebElement departureAirportElement;

    By durationLocator =  By.id("SearchbarReadonly-duration");
    private WebElement durationElement;

    By withLocator =  By.cssSelector(".SearchbarReadonly-col.col-xs-5.col-sm-6.hidden-xs");
    private WebElement withElement;


    public SearchResultWithCriteriaPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getDepartureAirportText() {
        departureAirportElement = webDriver.findElement(departureAirportLocator);
        return departureAirportElement.getText();
    }

    public String getDurationText() {
        durationElement = webDriver.findElement(durationLocator);
        return durationElement.getText();

    }

    public String getDestinationsText() {
        destinatioElement = webDriver.findElement(destinationLocator);
        return destinatioElement.getText();

    }

    public String getWithText() {
        withElement = webDriver.findElement(withLocator);
        return withElement.getText();
    }
//    public boolean istDestinationsTextPagePresent(String text) {
//        destinatioElement = webDriver.findElement(destinationLocator);
//        String departureText = destinatioElement.getText();
//        return departureText.contains(text);
//    }
}
