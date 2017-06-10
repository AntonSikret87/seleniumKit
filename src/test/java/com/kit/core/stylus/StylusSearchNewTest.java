package com.kit.core.stylus;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.stylus.StylusPage;
import com.kit.pages.stylus.StylusSearchResultPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class StylusSearchNewTest extends WebDriverTestBase{
    private String baseUrl = "http://stylus.com.ua";
    String searchText = "Sony Xperia Z2";
    String expectedURL = "https://stylus.ua/smartfony/sony-xperia-z2-black-198717.html";

    @Test
    public void searchStylusTest(){
        StylusPage stylusPage = new StylusPage(webDriver);
        stylusPage.open(baseUrl);
        stylusPage.fillAndSubmitSearchData(searchText);
        StylusSearchResultPage stylusSearchResultPage = new StylusSearchResultPage(webDriver);
        assertTrue(stylusSearchResultPage.getTextLink().contains(searchText));
        stylusSearchResultPage.clickLink();
        assertEquals(expectedURL,stylusSearchResultPage.getActualUrl());

    }

}
