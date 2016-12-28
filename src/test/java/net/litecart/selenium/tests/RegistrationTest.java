package net.litecart.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver wd;

    @BeforeMethod
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testRegistration(){
        wd.get("http://litecart/en/create_account");
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("Kirill");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("Remizov");
        wd.findElement(By.name("address1")).click();
        wd.findElement(By.name("address1")).clear();
        wd.findElement(By.name("address1")).sendKeys("test");
        wd.findElement(By.name("postcode")).click();
        wd.findElement(By.name("postcode")).clear();
        wd.findElement(By.name("postcode")).sendKeys("111111");
        wd.findElement(By.name("city")).click();
        wd.findElement(By.name("city")).clear();
        wd.findElement(By.name("city")).sendKeys("testCity");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("test@gmail.com");
        wd.findElement(By.name("phone")).click();
        wd.findElement(By.name("phone")).clear();
        wd.findElement(By.name("phone")).sendKeys("111");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("111");
        wd.findElement(By.name("confirmed_password")).click();
        wd.findElement(By.name("confirmed_password")).clear();
        wd.findElement(By.name("confirmed_password")).sendKeys("111");
        wd.findElement(By.name("create_account")).click();
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
