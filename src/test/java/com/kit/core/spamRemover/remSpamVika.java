package com.kit.core.spamRemover;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by AntonKa on 6/27/2017.
 */
public class remSpamVika extends WebDriverTestBase{

    private String baseUrl1 = "http://chudesa.com.ua/admin/comments/list/0/0/-1/3";
    private String username = "7777";
    private String password = "8888";



    @Test(enabled = false)
    public void searchTestStylusOld() {
        webDriver.get(baseUrl1);
        WebElement userField = webDriver.findElement(By.id("login"));
        userField.sendKeys(username);
        WebElement passfieldField = webDriver.findElement(By.id("password"));
        passfieldField.sendKeys(password);
        WebElement signInBtn = webDriver.findElement(By.id("button_enter"));
        signInBtn.click();
        WebElement editBtn = webDriver.findElement(By.xpath(".//*[@id='content']/section/div[3]/a[2]"));
        editBtn.click();

        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(0));
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(1));

        WebElement commentsBtn = webDriver.findElement(By.xpath(".//*[@id='navigation']/ul/li[6]/a"));
        commentsBtn.click();

        while (true) {
            WebElement selectAllChBX = webDriver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[1]/td[1]/input"));
            selectAllChBX.click();
            Select dropdown = new Select(webDriver.findElement(By.id("p_comments_oper")));
            dropdown.selectByVisibleText("Удалить");
            WebElement performBtn = webDriver.findElement(By.id("p_comments_oper_submit"));
            performBtn.click();
            webDriver.switchTo().alert().accept();
        }
    }
}
