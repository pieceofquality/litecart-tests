package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageComponent {
    protected WebDriver driver;

    public AbstractPageComponent(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
