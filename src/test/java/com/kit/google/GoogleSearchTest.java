package com.kit.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/2/2017.
 */
public class GoogleSearchTest {
    private WebDriver webDriver;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        webDriver.get(baseUrl + "/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest(){
        String searchText = "Selenium";
        By searchFieldLocator = By.cssSelector("#lst-ib");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[3]/div/div[1]/div/div/h3/a");
        WebElement firstLink = webDriver.findElement(linkLocator);
        assertTrue(firstLink.getText().contains(searchText));
    }

    @AfterClass
    public void tearDown() throws Exception {
        webDriver.quit();

    }
}
