package net.litecart.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerTest {
    private WebDriver driver;
    private List<WebElement> products;
    private WebElement sticker;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void testSticker(){
        driver.get("http://litecart/en/");
        products = driver.findElements(By.className("product"));
//        sticker = products
    }

}
