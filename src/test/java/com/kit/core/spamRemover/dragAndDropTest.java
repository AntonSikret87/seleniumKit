package com.kit.core.spamRemover;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 6/30/2017.
 */
public class dragAndDropTest extends WebDriverTestBase {
    private String baseUrl1 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop";

    @Test(enabled = false)
    public void switchIfremeTest() throws Exception {
        webDriver.get(baseUrl1);
        WebElement iFrame = webDriver.findElement(By.id("iframeResult"));
        webDriver.switchTo().frame(iFrame);
        WebElement elementToDragAndDrop = webDriver.findElement(By.id("drag1"));//(By.xpath(".//*[@id='drag1']"))
        WebElement toElement = webDriver.findElement(By.id("div1"));//(By.xpath(".//*[@id='div1']"));

//        Actions builder = new Actions(webDriver);
//        builder.moveToElement(elementToDragAndDrop)
//                .clickAndHold()
//                .moveToElement(toElement)
//                .release()
//                .build()
//                .perform();
        DragAndDropJS(elementToDragAndDrop,toElement,webDriver );
        WebElement elementAfterDragAndDrop = webDriver.findElement(By.xpath("//div[img[@src ='img_logo.gif']]//child::img"));
        assertTrue(elementAfterDragAndDrop.isDisplayed());
        assertTrue(elementAfterDragAndDrop.getAttribute("src").equals("https://www.w3schools.com/html/img_logo.gif"));
    }

    public static void DragAndDropJS(WebElement source, WebElement destination, WebDriver webDriver) throws Exception
    {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);
        Thread.sleep(1500);
    }
}
