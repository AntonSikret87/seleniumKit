package com.kit.core.thomascook;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.thomascook.SearchResultDefaultPage;
import com.kit.pages.thomascook.ThomasCookHomePage;
import org.testng.annotations.Test;

/**
 * Created by AntonKa on 6/14/2017.
 */
public class DefaultSearchTest extends WebDriverTestBase {

    private String baseUrl = "https://www.thomascook.com/";

    @Test(enabled = false)
    public void defaultSearchTest(){
        ThomasCookHomePage thomasCookHomePage = new ThomasCookHomePage(webDriver);
        thomasCookHomePage.open(baseUrl);
        thomasCookHomePage.closePopupAndCloseCookiesDialog();
        thomasCookHomePage.clickSearchBtn();
        SearchResultDefaultPage searchResultDefaultPage = new SearchResultDefaultPage(webDriver);
        searchResultDefaultPage.checkPaginationIsDisplayed();
        //add assert "facets are available"
    }
}
