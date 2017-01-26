package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractPageComponent{

    public AbstractPage(WebDriver driver){
        super(driver);
    }

    public abstract String getUrl();
}
