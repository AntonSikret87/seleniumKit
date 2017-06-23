package com.kit.core;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import java.util.concurrent.TimeUnit;

/**
 * Created by AntonKa on 6/9/2017.
 */
public class WebDriverTestBase {
    protected WebDriver webDriver;
    private String browser =  System.getProperty("browser");


    @BeforeClass
    public void setUp() throws Exception {
        //Manually
//        String pathToFileWindows = "src\\main\\resources\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", pathToFileWindows);
        //lib bonigarcia
//        ChromeDriverManager.getInstance().setup();
//        webDriver = new ChromeDriver();
        setBrowser();
        setWebDriverSettings();

    }

    private void setWebDriverSettings() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    public void setBrowser(){
        BrowserEnum runBrowser = browser == null ? BrowserEnum.CHROME : BrowserEnum.valueOf(browser);
        switch (runBrowser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;
            case FF:
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                break;
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        //close browser
        webDriver.close();
        //close browser's tab
//        webDriver.quit();

    }
}
