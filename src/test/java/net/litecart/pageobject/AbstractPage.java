package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractPageComponent{

    public AbstractPage(WebDriver wd){
        super(wd);
    }

    public abstract String getUrl();
}
