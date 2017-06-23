package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.openqa.selenium.Keys.ARROW_DOWN;

/**
 * Created by AntonKa on 6/14/2017.
 */
public class ThomasCookHomePage extends ThomasCookBasePage{
    private Actions actions;

    private String lableFromField = "Any Airport";
    private String lableToField = "Any destination";

    By searchLocator = By.id("SearchbarForm-submitBtn");
    private WebElement searchButton;
    By closePopUpLocator = By.className("deliver-component-CloseButton-times");
    private WebElement closePopup;
    By fieldsLocators = By.cssSelector(".FormField-text.FormField-text--iconRight.SearchbarForm-inputForm");//.FormField-text.FormField-text--iconRight.SearchbarForm-inputForm
    private List<WebElement> fieldsFromAndToList;
    By dropDownListHowLongLocator = By.id("SearchbarForm-duration");
    private WebElement dropDownDurationBtn;
    By addRoomLocator = By.cssSelector("#SearchbarRooms-add");
    private WebElement addRoomBtn;
    By closeCookiesLocator =  By.cssSelector("#accept-cookies");
    private WebElement closeCookiesBtn;
    By dropDownListAdultLocator = By.cssSelector("#SearchbarRooms-adults1");
    private WebElement dropDownAdultBtn;


    public ThomasCookHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSearchBtn() {
        searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
    }

    public void flyFrom(String fromValue) {
        actions= new Actions(webDriver);
        fieldsFromAndToList = webDriver.findElements(fieldsLocators);
        //WebElement fieldFrom = fieldsFromAndToList.get(1);
        for(WebElement fieldNeededFrom: fieldsFromAndToList) {
            System.out.println(fieldNeededFrom.getText());
            if (fieldNeededFrom.getText().contains(lableFromField)){
                actions.click(fieldNeededFrom).sendKeys(fromValue).perform();
            }
        }
        //System.out.println("Fromd field " + fieldFrom.getText());
       // actions.click(fieldFrom).sendKeys(fromValue).perform();
        String locator = "//li[contains(@class, 'list-item needsclick ng-binding ng-scope') and contains(., '%s')]";
        By firstItemInFromDropLocator = By.xpath(String.format(locator, fromValue));
        WebDriverWait w = new WebDriverWait(webDriver, 15);
        WebElement firstInlistItem = w.until(ExpectedConditions.elementToBeClickable(firstItemInFromDropLocator));
        firstInlistItem.click();
    }

    public void flyTo(String toValue) {
        actions= new Actions(webDriver);
        fieldsFromAndToList = webDriver.findElements(fieldsLocators);
        WebElement fieldTo = fieldsFromAndToList.get(0);
        //System.out.println("Fromd field " + fieldTo.getText());
        actions.click(fieldTo).sendKeys(toValue);
        actions.build().perform();
        By firstItemInToDropLocator = By.xpath("//li[contains(@class, 'list-item needsclick ng-binding ng-scope') and contains(., '"+toValue+"')]");
        WebDriverWait w = new WebDriverWait(webDriver, 20);
        WebElement firstInlistItem = w.until(ExpectedConditions.elementToBeClickable(firstItemInToDropLocator));
        firstInlistItem.click();
    }

    public void selectDuration(String itemInList){
        dropDownDurationBtn = webDriver.findElement(dropDownListHowLongLocator);
        Select dropDurationlist = new Select(dropDownDurationBtn);
        dropDurationlist.selectByVisibleText(itemInList);
    }

    public void addRoom(){
        addRoomBtn = webDriver.findElement(addRoomLocator);
        addRoomBtn.click();
    }
    public void selectAdultsInRoom(String adultAmount){
        dropDownAdultBtn = webDriver.findElement(dropDownListAdultLocator);
        Select droplist = new Select(dropDownAdultBtn);
        droplist.selectByVisibleText(adultAmount);
    }

    public void closePopup() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        closePopup = webDriver.findElement(closePopUpLocator);
        wait.until(ExpectedConditions.presenceOfElementLocated(closePopUpLocator));
        closePopup.click();
    }

    public void closeCookiesDialog(){
        closeCookiesBtn = webDriver.findElement(closeCookiesLocator);
        closeCookiesBtn.click();
    }

    public void closePopupAndCloseCookiesDialog(){
        closePopup();
        closeCookiesDialog();
    }

}



