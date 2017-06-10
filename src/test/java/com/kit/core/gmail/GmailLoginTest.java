package com.kit.core.gmail;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.gmail.GmailLoginPage;
import com.kit.pages.gmail.GmailPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


/**
 * Created by AntonKa on 6/9/2017.
 */
public class GmailLoginTest extends WebDriverTestBase {

    private String baseUrl = "https://gmail.com/";
    private String baseUrlAfterEnter = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private String myEmail = "testkitauto";
    private String myPassword = "Test1234*";
    private String titleIcon = "Аккаунт Google: test testovich  \n" + "(testkitauto@gmail.com)";


    @Test
    public void searchTest(){
        GmailPage gmailPage = new GmailPage(webDriver);
        gmailPage.open(baseUrl);
        assertTrue(gmailPage.getActualUrl().equals(baseUrlAfterEnter));
        gmailPage.login(myEmail,myPassword);
        GmailLoginPage gmailLoginPage = new GmailLoginPage(webDriver);
        assertTrue(gmailLoginPage.getTitleIcon().equals(titleIcon));
        assertTrue(gmailLoginPage.checkIncomingLinkIsDisplayed());
    }
}
