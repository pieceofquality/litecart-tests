package net.litecart.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) { super(wd);
    }

    public void gotoProductsPage(){
        wd.get("http://litecart/en/");
    }

    public void gotoAdminAuthPage(){
        wd.get("http://litecart/admin/");
    }

    public void countElements (){
        wd.findElements(By.name("app-")).size();
    }

    public void verifyHeader(By locator){
        wd.findElement(locator).click();
        assertEquals(1, wd.findElements(By.tagName("h1")).size());
    }



    public static List<String> getListOfIds(List<WebElement> elements){
        List<String> elementsIds = new ArrayList<String>();
        for(WebElement el: elements){
            elementsIds.add(el.getAttribute("id"));
        }
        return elementsIds;
    }

    public void gotoCountriesPage() {
        wd.get("http://litecart/admin/?app=countries&doc=countries");
    }

    public void gotoGeoZonesPage() {
        wd.get("http://litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    public void gotoFirstCampaignsProduct() {
        click(By.cssSelector("#box-campaigns .product"));
    }

    public void gotoBuyerRegistrationPage() {
        wd.get("http://litecart/en/create_account");
    }

    public void gotoCatalogPage() { wd.get("http://litecart/admin/?app=catalog&doc=catalog");
    }

    public void gotoInformationTabProduct() {
        wd.findElement(By.linkText("Information")).click();
    }

    public void gotoPricesTabProduct() {
        wd.findElement(By.linkText("Prices")).click();
    }

    public void gotoCheckoutPage() {
        wd.findElement(By.cssSelector("#cart .link")).click();
    }

    public void gotoRubberDucksCategoryPage() {
        wd.get("http://litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }
}
