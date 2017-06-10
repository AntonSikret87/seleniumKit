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

    private String baseUrl = "https://accounts.google.com/";
    private String myEmail = "testkitauto";
    private String myPassword = "Test1234*";
    private String titleIcon = "Аккаунт Google: test testovich  \n" + "(testkitauto@gmail.com)";


    @Test
    public void searchTest(){
        GmailPage gmailPage = new GmailPage(webDriver);
        gmailPage.open(baseUrl);
        gmailPage.login(myEmail,myPassword);
        GmailLoginPage gmailLoginPage = new GmailLoginPage(webDriver);
        assertTrue(gmailLoginPage.getTitleIcon().equals(titleIcon));
    }
}
