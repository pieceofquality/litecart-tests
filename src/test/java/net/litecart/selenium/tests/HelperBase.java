package net.litecart.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    WebDriver driver;

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void authByAdmin(){
        type(By.name("username"), "admin");
        type(By.name("password"), "admin");
        click(By.name("login"));
    }
}
