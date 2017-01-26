package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageComponent {
    protected WebDriver wd;

    public AbstractPageComponent(WebDriver wd){
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }
}
