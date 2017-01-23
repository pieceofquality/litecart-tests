package net.litecart.selenium.tests;

import org.testng.annotations.Test;

public class AdminTests extends TestBase{



    //Exercise #3: Admin Authorization
    @Test
    public void testLogin(){
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
    }

    //Exercise #7: Admin Sections
    @Test
    public void testSections(){
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getAdminMenuHelper().openAllMenuItems();
    }

//     Exercise #9.1: Countries sorting
    @Test
    public void testCountriesSorting(){
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoCountriesPage();
        app.getAdminMenuHelper().checkCountriesSorting();
    }

    //     Exercise #9.2: Geozones sorting
    @Test
    public void testGeoZonesSorting(){
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoGeoZonesPage();
        app.getAdminMenuHelper().checkGeoZonesSorting();
    }

    //    Exercise #12: Product Creation
    @Test
    public void testProductCreation(){
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoCatalogPage();
        app.getProductHelper().initProductCreation();
        app.getProductHelper().fillGeneralTabProduct();
        app.getNavigationHelper().gotoInformationTabProduct();
        app.getProductHelper().fillInformationTabProduct();
        app.getNavigationHelper().gotoPricesTabProduct();
        app.getProductHelper().fillPricesTabProduct();
        app.getProductHelper().submitProductCreation();
    }

    // Exercise #14: Links
    @Test
    public void testLinkOpening() throws InterruptedException {
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoCountriesPage();
        app.getAdminMenuHelper().initCountryCreation();
        app.getAdminMenuHelper().checkCountryPageExternalLinksPresence();
    }

    // Exercise #17: Console logs

    @Test
    public void testLogging() throws InterruptedException {
        app.getNavigationHelper().gotoAdminAuthPage();
        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoRubberDucksCategoryPage();
        app.getAdminMenuHelper().openAllRubberDuckProducts();

    }
}
