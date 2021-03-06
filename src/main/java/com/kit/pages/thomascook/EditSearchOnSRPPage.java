package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by AntonKa on 6/16/2017.
 */
public class EditSearchOnSRPPage extends ThomasCookBasePage{

    By editBtnLocator = By.id("SearchbarReadonly-edit");
    private WebElement editBtn;

    By dropDownListAmountChildsLocator = By.cssSelector("#SearchbarRooms-children0");
    private WebElement dropDownAmountChilds;

    By firstDropDownChildLocator = By.cssSelector("#SearchbarChildAge-age0-0");
    private WebElement firstdropDownChilds;

    By secondDropDownChildLocator = By.cssSelector("#SearchbarChildAge-age0-1");
    private WebElement seconddropDownChilds;

    By applyLocator = By.id("SearchbarChildAge-apply");
    private WebElement applyBtn;

    By dropDownListHowLongLocator = By.id("SearchbarForm-duration");
    private WebElement dropDownDurationBtn;

    By toFieldLocator = By.xpath(".//*[@id='SearchbarForm-destinationContainer']/div/div/div/tc-typeahead/div");
    private WebElement toField;

    By fieldsLocators = By.cssSelector(".FormField-text.FormField-text--iconRight.SearchbarForm-inputForm");//.FormField-text.FormField-text--iconRight.SearchbarForm-inputForm
    private List<WebElement> fieldsFromAndToList;

    By airplainBtnLocator = By.cssSelector(".FormField-icon.FormField-icon--right.FormField-icon--link.icon.airplaneNE");
    private WebElement airplainBtn;

    By londonGrinwichCheckboxLocator = By.xpath(".//*[@id='PopularTooltip--airports']/div[2]/div/div[4]/div[4]/label");
    private WebElement LondonGrinwichChkbx;

    By searchBtnLocator = By.id("SearchbarForm-submitBtn");
    private WebElement searchBtn;


    public EditSearchOnSRPPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickEditButton() {
//        WebDriverWait w = new WebDriverWait(webDriver, 40);
//        editBtn = w.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
        editBtn = webDriver.findElement(editBtnLocator);
        webDriverUtil.actions.moveToElement(editBtn);
        webDriverUtil.jsClickByIdOrName("SearchbarReadonly-edit", "id");
//        editBtn = webDriver.findElement(editBtnLocator);
//        editBtn.click();


    }

    public void selectChildsInDropDown(String infantAge, String childAge){
        firstdropDownChilds = webDriver.findElement(firstDropDownChildLocator);
        Select droplist1 = new Select(firstdropDownChilds);
        droplist1.selectByVisibleText(infantAge);
        seconddropDownChilds = webDriver.findElement(secondDropDownChildLocator);
        Select droplist2 = new Select(seconddropDownChilds);
        droplist2.selectByVisibleText(childAge);
        applyBtn = webDriver.findElement(applyLocator);
        applyBtn.click();
    }

    public void selectChildlnRoom(String adultAmount){
        dropDownAmountChilds = webDriver.findElement(dropDownListAmountChildsLocator);
       // dropDownAmountChilds = webDriverUtil.waitForExpectedCondition(ExpectedConditions.elementToBeClickable(dropDownListAmountChildsLocator));
        Select droplist = new Select(dropDownAmountChilds);
        droplist.selectByVisibleText(adultAmount);
    }

    public void selectDuration(String itemInList){
        dropDownDurationBtn = webDriver.findElement(dropDownListHowLongLocator);
        Select dropDurationlist = new Select(dropDownDurationBtn);
        dropDurationlist.selectByVisibleText(itemInList);
    }

    public void clickOnNeededItemInDropDownField(String enteredVal){
        firstItemInFromDropLocator(enteredVal).click();
    }
    String optionXpathLocator = "//li[contains(@class, 'list-item needsclick') and contains(., %s')]";
    private WebElement firstItemInFromDropLocator(String text) {
        return webDriverUtil.waitForExpectedCondition(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionXpathLocator, text))));
    }
    private String lableFromField = "London Gatwick";
    public void flyFrom(String fromValue) {
        airplainBtn = webDriver.findElement(airplainBtnLocator);
        airplainBtn.click();
        LondonGrinwichChkbx = webDriver.findElement(londonGrinwichCheckboxLocator);
        LondonGrinwichChkbx.click();
        fieldsFromAndToList = webDriver.findElements(fieldsLocators);
        WebElement fieldFrom = fieldsFromAndToList.get(1);
        webDriverUtil.actions.click(fieldFrom).sendKeys(fromValue).perform();
        By firstItemInFromDropLocator = By.xpath("//li[contains(@class, 'list-item needsclick') and contains(., '"+fromValue+"')]");

        WebElement firstInlistItemFromField =webDriverUtil.waitForExpectedCondition(
                ExpectedConditions.elementToBeClickable(firstItemInFromDropLocator));
//        WebDriverWait w = new WebDriverWait(webDriver, 15);
//        WebElement firstInlistItemFromField =  w.until(ExpectedConditions.elementToBeClickable(firstItemInFromDropLocator));
        firstInlistItemFromField.click();


        fieldsFromAndToList = webDriver.findElements(fieldsLocators);
        //WebElement fieldTo = fieldsFromAndToList.get(0);
        //System.out.println("Fromd field " + fieldTo.getText());
        for(WebElement fieldNeededTo: fieldsFromAndToList) {
            //System.out.println("ToFIELD: "+fieldNeededTo.getText());
            if (fieldNeededTo.getText().contains(lableFromField)){
                webDriverUtil.actions.click(fieldNeededTo).sendKeys(fromValue).perform();
            }
        }
        clickOnNeededItemInDropDownField(fromValue);
    }

    public void flyTo(String toValue) {
        toField = webDriver.findElement(toFieldLocator);
        webDriverUtil.actions.click(toField).sendKeys(toValue).perform();
        By firstItemInToDropLocator = By.xpath("//li[text()[contains(.,'"+toValue+"')]]");
        WebElement firstInlistItemToField  =webDriverUtil.waitForExpectedCondition(
                ExpectedConditions.elementToBeClickable(firstItemInToDropLocator));
//        WebDriverWait w = new WebDriverWait(webDriver, 15);
//        WebElement firstInlistItemToField = w.until(ExpectedConditions.elementToBeClickable(firstItemInToDropLocator));
        firstInlistItemToField.click();
        //actions.click(firstInlistItemToField).build().perform();
    }

    public void clickSearchBtn() {
        searchBtn = webDriver.findElement(searchBtnLocator);
        searchBtn.click();
    }
}

