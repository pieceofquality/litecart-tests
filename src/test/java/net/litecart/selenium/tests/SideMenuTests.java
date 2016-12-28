package net.litecart.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SideMenuTests {

    WebDriver driver;
    HelperBase h = new HelperBase();

    @Test
    public void testSideMenu(){

       h.authByAdmin();
       int n = driver.findElements(By.id("app-")).size();

    }


}
