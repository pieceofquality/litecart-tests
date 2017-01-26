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

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void removeProduct(){
        driver.findElement(By.name("remove_cart_item")).click();
    }

    public int countProducts(){
        return products.size();
    }

    public void waitForCountProductsToBe(int count){
        WebDriverWait wait = new WebDriverWait(driver,5);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(table)));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("td.item"), count));
    }
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/en/checkout";
    }

}