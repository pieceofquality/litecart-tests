package net.litecart.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdminMenuHelper extends HelperBase {

    public AdminMenuHelper(WebDriver wd) {
        super(wd);
    }

    public static List<String> getListOfIds(List<WebElement> elems) {
        List<String> elemsIds = new ArrayList<String>();
        for (WebElement el : elems) {
            elemsIds.add(el.getAttribute("id"));
        }
        return elemsIds;
    }

    public void verifyMenuItemHeader(By locator) {
        wd.findElement(locator).click();
        assertEquals(1, wd.findElements(By.tagName("h1")).size());
    }



    public void openAllMenuItems() {
        int menuItemsCounter = wd.findElements(By.id("app-")).size();
        for (int i = 1; i < menuItemsCounter; i++) {
            verifyMenuItemHeader(By.cssSelector("[id=app-]:nth-of-type(" + i + ")"));
            List<WebElement> subMenuItems = wd.findElements(By.cssSelector("[id^=doc-]"));
            if (subMenuItems.size() > 0) {
                List<String> subMenuIds = getListOfIds(subMenuItems);
                subMenuIds.forEach((id) -> verifyMenuItemHeader(By.id(id))
                );
            }
        }
    }

    public void checkCountriesSorting(){
        List<String> columnHeaders = getElementsTexts((wd.findElements(By.tagName("th"))));
        int columnId = columnHeaders.indexOf("Name") + 1;
        List<WebElement> elements = wd.findElements(By.cssSelector(".row td:nth-child("+columnId+")"));
        List<String> countryNames = getElementsTexts(elements);
        assertTrue(isSorted(countryNames));
    }

    public void checkGeoZonesSorting(){
        List<WebElement> elems = wd.findElements(By.cssSelector("[name*=zone_code][selected]"));
        List<String> geoZonesNames = getElementsTexts(elems);
        Assert.assertEquals(true,isSorted(geoZonesNames));
    }
}