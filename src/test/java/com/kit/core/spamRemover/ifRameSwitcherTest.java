package com.kit.core.spamRemover;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/30/2017.
 */
public class ifRameSwitcherTest extends WebDriverTestBase {

    private String baseUrl1 = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";
    private String dropDownValue = "Saab";


    @Test(enabled = false)
    public void switchIfremeTest() {
        webDriver.get(baseUrl1);
        WebElement iFrame = webDriver.findElement(By.id("iframeResult"));
        webDriver.switchTo().frame(iFrame);
        Select selectDropDovn =  new Select(webDriver.findElement(By.cssSelector("html>body>select")));
        selectDropDovn.selectByVisibleText(dropDownValue);
        assertTrue(selectDropDovn.getFirstSelectedOption().getText().contains(dropDownValue));

    }

}
