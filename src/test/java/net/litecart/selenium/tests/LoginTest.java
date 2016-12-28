package net.litecart.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver wd;

    @BeforeMethod
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin(){
        wd.get("http://litecart/admin/login.php?redirect_url=%2Fadmin%2F");
        wd.findElement(By.name("username")).click();
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        wd.findElement(By.id("sidebar")).click();
        wd.manage().addCookie(new Cookie("LCSESSID", "ta68630muffuibgff6tc8rrqs5"));
        wd.navigate().refresh();
        assertTrue((isElementPresent(By.linkText("Apperarence"))));
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @AfterMethod
    public void stop() {
        wd.quit();
        wd = null;
    }
}
