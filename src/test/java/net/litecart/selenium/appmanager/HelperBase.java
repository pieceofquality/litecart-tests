package net.litecart.selenium.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {

    protected WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public void attach(By locator, String path) {
        wd.findElement(locator).sendKeys(path);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void hover(By locator) {
        Actions action = new Actions(wd);
        action.moveToElement(wd.findElement(locator)).build()
                .perform();
    }

    public void insertTextToRedactor(final String locator, final String text) {
        ((JavascriptExecutor)wd).executeScript("$('" + locator + "').redactor('insert.html', '" + text + "');");
    }

    public void select(By locator, String category) {
        new Select(wd.findElement(locator)).selectByVisibleText(category);
    }

    public void accept(){
        wd.switchTo().alert().accept();
    }

    public static List<String> getElementsTexts(List<WebElement> elems){
        List<String> elemsTexts = new ArrayList<String>();
        for(WebElement el: elems){
            elemsTexts.add(el.getText());
        }
        return elemsTexts;
    }

    public static boolean isSorted(List<String> list){
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).compareTo(list.get(i-1)) < 0){
                return false;
            }
        }
        return true;
    }

}

