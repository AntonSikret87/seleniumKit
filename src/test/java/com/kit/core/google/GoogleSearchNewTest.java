package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;


import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/9/2017.
 */

//@Listeners({com.kit.core.TestListener.class})
public class GoogleSearchNewTest extends WebDriverTestBase {
    private String baseUrl = "https://www.google.com/";
    private String searchText = "Selenium";

    @Title("Title Test")
    @Description("Test Case google search positive case")
    @Test(enabled = true)
    public void searchTest(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);//PageFactory.initElements(webDriver, GoogleSearchPage.class);
        googleSearchPage.open(baseUrl);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);//PageFactory.initElements(webDriver, GoogleSearchResultPage.class);
        assertTrue(googleSearchResultPage.getTextLink().contains(searchText));
        googleSearchResultPage.clickLink();
    }
}
