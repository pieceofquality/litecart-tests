package net.litecart.pageobject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    public static WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @Before
    public void start(){
        driver = getDriver();
    }


    @After
    public void finish(){
        driver.quit();
        driver = null;
    }
}
