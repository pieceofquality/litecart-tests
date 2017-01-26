/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AbstractPage{
    @FindBy(css = "#box-most-popular a.link")
    List<WebElement> popularProducts;
    
    public MainPage(WebDriver wd) {
        super(wd);
        wd.get(getUrl());
    }

    public List<String> PopularProductsUrls(){
        return getListOfUrls(popularProducts);
    }

    public static List<String> getListOfUrls(List<WebElement> els){
        List<String> urls = new ArrayList();
        els.forEach(p->urls.add(p.getAttribute("href")));
        return urls;
    }
    
    @Override
    public String getUrl() {
        return "http://litecart/en/";
    }
    
}
