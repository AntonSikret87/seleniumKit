package com.kit.core.stylus;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/7/2017.
 */
public class StylusSearchOldTest extends WebDriverTestBase {
     private String baseUrl1 = "http://stylus.com.ua/";



    @Test(enabled = true)
    public void searchTestStylusOld() {
        webDriver.get(baseUrl1);
        String searchText = "Sony Xperia Z2";
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchField.submit();
        WebElement foundLink = webDriver.findElement(By.xpath(".//*[@id='search-list']/ul/li[5]/a/span"));
        assertTrue(foundLink.getText().contains(searchText));
        foundLink.click();
        String expectedURL = "https://stylus.ua/smartfony/sony-xperia-z2-black-198717.html";
        String actualURL = webDriver.getCurrentUrl();
        assertTrue(actualURL.equals(expectedURL));
        assertEquals(expectedURL, actualURL);
    }
}
