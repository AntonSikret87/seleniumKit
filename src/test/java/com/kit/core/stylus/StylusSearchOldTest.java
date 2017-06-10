package com.kit.core.stylus;

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
public class StylusSearchOldTest {
    private WebDriver webDriver;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "http://stylus.com.ua";
        webDriver.get(baseUrl + "/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest(){
        String searchText = "Sony Xperia Z2";
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchField.submit();
        WebElement foundLink = webDriver.findElement(By.xpath(".//*[@id='search-list']//span[text() ='Смартфон Sony Xperia Z2 Black']"));
        assertTrue(foundLink.getText().contains(searchText));
        foundLink.click();
        String expectedURL = "https://stylus.ua/smartfony/sony-xperia-z2-black-198717.html";
        String actualURL = webDriver.getCurrentUrl();
        assertTrue(actualURL.equals(expectedURL));
        assertEquals(expectedURL,actualURL);
    }
    @AfterClass
    public void tearDown() throws Exception {
        webDriver.quit();

    }
}
