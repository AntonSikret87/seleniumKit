package com.kit.core.thomascook;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.thomascook.EditSearchOnSRPPage;
import com.kit.pages.thomascook.SearchResultWithCriteriaPage;
import com.kit.pages.thomascook.ThomasCookHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/16/2017.
 */
public class EditSearchOnSRPTest extends WebDriverTestBase{
    private String baseUrl = "https://www.thomascook.com/";
    private String adultsCount = "2";
    private String childCount = "2";
    private String forHowLongPrecondition = "8-13 Nights";
    private String forHowLongChangedTo = "7 Nights";
    private String flyingFromPrecondition = "London Gatwick";
    private String flyingFromChangeTo = "Manchester";
    private String flyingToChangeTo = "Cuba, Any";
    private String expectedAdultsAndRooms = "Room 1: 2 Adults, 1 Child, 1 Infant\n" + "Room 2: 2 Adults";



//    @BeforeTest
//    public void preconditionForEditSearchonSRPTest(){
//
//    }

    @Test
    public void editSearchonSRPTest(){
        //Preconditions
        ThomasCookHomePage thomasCookHomePage = new ThomasCookHomePage(webDriver);
        thomasCookHomePage.open(baseUrl);
        thomasCookHomePage.closePopupAndCloseCookiesDialog();
        thomasCookHomePage.addRoom();
        thomasCookHomePage.selectAdultsInRoom(adultsCount);
        thomasCookHomePage.selectDuration(forHowLongPrecondition);
        thomasCookHomePage.flyFrom(flyingFromPrecondition);
        thomasCookHomePage.clickSearchBtn();
        //Steps
        EditSearchOnSRPPage editSearchOnSRPPage = new EditSearchOnSRPPage(webDriver);
        editSearchOnSRPPage.clickEditButton();
        editSearchOnSRPPage.selectChildlnRoom(childCount);
        editSearchOnSRPPage.selectChildsInDropDown("<2", "7");
        editSearchOnSRPPage.selectDuration(forHowLongChangedTo);
        editSearchOnSRPPage.flyFrom(flyingFromChangeTo);
        editSearchOnSRPPage.flyTo(flyingToChangeTo);
        editSearchOnSRPPage.clickSearchBtn();
        SearchResultWithCriteriaPage searchResultWithCriteriaPagePage = new SearchResultWithCriteriaPage(webDriver);
        assertTrue(searchResultWithCriteriaPagePage.getDepartureAirportText().contains(flyingFromChangeTo));
        assertTrue(searchResultWithCriteriaPagePage.getDestinationsText().contains(flyingToChangeTo));
        assertTrue(searchResultWithCriteriaPagePage.getDurationText().contains(forHowLongChangedTo));
        assertTrue(searchResultWithCriteriaPagePage.getWithText().contains(expectedAdultsAndRooms));
    }
}
