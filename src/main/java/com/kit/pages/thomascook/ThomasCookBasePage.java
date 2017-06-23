package com.kit.pages.thomascook;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by AntonKa on 6/17/2017.
 */
public class ThomasCookBasePage {
    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;


    public ThomasCookBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil=new WebDriverUtil(webDriver);

    }

    public void open(String url){
        webDriver.get(url);
    }
}

