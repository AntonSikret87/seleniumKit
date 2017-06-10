package com.kit.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/10/2017.
 */
public class GmailLoginPage {
    private WebDriver webDriver;
    By myIconLocator = By.xpath("//*[@class='gb_b gb_db gb_R']");
    private WebElement myNameOnThePage;

    By incomingMailsLocator = By.xpath(".//*[@class='J-Ke n0' and @tabindex='0']");
    private WebElement incomingLink;

    public GmailLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTitleIcon() {
        myNameOnThePage = webDriver.findElement(myIconLocator);
        return myNameOnThePage.getAttribute("title");
    }

    public boolean checkIncomingLinkIsDisplayed() {
        incomingLink = webDriver.findElement(incomingMailsLocator);
        return incomingLink.isDisplayed();
    }

}
