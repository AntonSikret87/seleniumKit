package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/2/2017.
 */
public class GoogleSearchOldTest extends WebDriverTestBase {

    private String baseUrl = "https://www.google.com/";

    @Test
    public void searchTest(){
        webDriver.get(baseUrl);
        String searchText = "Selenium";
        By searchFieldLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        WebElement firstLink = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a"));
        assertTrue(firstLink.getText().contains(searchText));
    }
}
