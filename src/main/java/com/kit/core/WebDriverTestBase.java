package com.kit.core;


import com.kit.util.PropertiesCache;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import java.util.concurrent.TimeUnit;

/**
 * Created by AntonKa on 6/9/2017.
 */
@Listeners({com.kit.core.TestListener.class})
public class WebDriverTestBase {
    protected WebDriver webDriver;
    //How to pass System variable to Selenium Framework
    //mvn -Dbrowser = FF clean test  - to run test on different browsers
    private String browser =  System.getProperty("browser");
    //Loads settings from test.properties file
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long loadingPageTime = Long.parseLong(PropertiesCache.getProperty("wait.loadingPage"));
    long scriptSetTime = Long.parseLong(PropertiesCache.getProperty("wait.scriptSetTime"));


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
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(loadingPageTime, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(scriptSetTime, TimeUnit.SECONDS);
    }

    public void setBrowser(){
        BrowserEnum runBrowser = browser == null ? BrowserEnum.CHROME : BrowserEnum.valueOf(browser);
        switch (runBrowser){
            case CHROME:
                ChromeDriverManager.getInstance().version("2.28").setup();
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
