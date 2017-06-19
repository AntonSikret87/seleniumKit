package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class GoogleSearchNewTest extends WebDriverTestBase {
    private String baseUrl = "https://www.google.com/";
    private String searchText = "Selenium";

    @Test
    public void searchTest(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);//PageFactory.initElements(webDriver, GoogleSearchPage.class);
        googleSearchPage.open(baseUrl);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);//PageFactory.initElements(webDriver, GoogleSearchResultPage.class);
        assertTrue(googleSearchResultPage.getTextLink().contains(searchText));
    }
}
