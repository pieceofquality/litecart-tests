package net.litecart.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends AbstractPage{

    @FindBy(css = "td.item")
    List<WebElement> products;

    public BasketPage(WebDriver wd) {
        super(wd);
    }

    public void removeProduct(){
        wd.findElement(By.name("remove_cart_item")).click();
    }

    public void waitForCountProductsToBe(int count){
        WebDriverWait wait = new WebDriverWait(wd,5);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("td.item"), count));
    }
    @Override
    public String getUrl() {
        return "http://litecart/en/checkout";
    }

}