/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketWidget extends AbstractPageComponent{
    @FindBy(className = "quantity")
    private WebElement countProducts;
    @FindBy(css = "#cart a.link")
    private WebElement checkout;
    
    private final WebDriverWait wait;
    
    public BasketWidget(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }
    
    public int countProducts(){
        return Integer.parseInt(countProducts.getText());
    }
    public BasketPage openCart(){
        checkout.click();
        return new BasketPage(driver);
    }
    public void waitForCountUpdateTo(int value){
        wait.until(ExpectedConditions.textToBePresentInElement(countProducts, String.valueOf(value)));
    }
}
