package net.litecart.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyerHelper extends HelperBase{

    public BuyerHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBuyerRegistrationForm() {
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
        wd.findElement(By.name("email")).sendKeys("test667@gmail.com");
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
        wd.findElement(By.linkText("Logout")).click();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("test667@gmail.com");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("111");
    }

    public void buyerLogOut() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void submitBuyerRegistration() {
        wd.findElement(By.name("login")).click();
    }

    public void initBuyerRegistration() {
        wd.findElement(By.linkText("New customers click here")).click();
    }
}
