package com.kit.core.thomascook;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.thomascook.SearchResultWithCriteriaPage;
import com.kit.pages.thomascook.ThomasCookHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/14/2017.
 */
public class SearchByCriteriaTest extends WebDriverTestBase {
    private String baseUrl = "https://www.thomascook.com/";
    private String flyingFrom = "Any London";
    private String whereTo = "Mexico, Any";
    private String forHowLong = "7 Nights";
    private String adultsCount = "2";
    private String expectedAdultsAndRooms = "Room 1: 2 Adults\n" + "Room 2: 2 Adults";

    @Test(enabled = false)
    public void searchWithCriteriaTest() {
        ThomasCookHomePage thomasCookHomePage = new ThomasCookHomePage(webDriver);
        thomasCookHomePage.open(baseUrl);
        thomasCookHomePage.closePopupAndCloseCookiesDialog();
        thomasCookHomePage.flyFrom(flyingFrom);
        thomasCookHomePage.flyTo(whereTo);
        thomasCookHomePage.selectDuration(forHowLong);
        assertEquals(forHowLong, thomasCookHomePage.getSelectedValue());
        thomasCookHomePage.addRoom();
        thomasCookHomePage.selectAdultsInRoom(adultsCount);
        thomasCookHomePage.clickSearchBtn();
        SearchResultWithCriteriaPage searchResultWithCriteriaPagePage = new SearchResultWithCriteriaPage(webDriver);
        assertTrue(searchResultWithCriteriaPagePage.getDepartureAirportText().contains(flyingFrom));
        assertTrue(searchResultWithCriteriaPagePage.getDestinationsText().contains(whereTo));
        assertTrue(searchResultWithCriteriaPagePage.getDurationText().contains(forHowLong));
        assertTrue(searchResultWithCriteriaPagePage.getWithText().contains(expectedAdultsAndRooms));
    }
}
