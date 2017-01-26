package net.litecart.pageobject;

import org.junit.Test;

import java.util.List;

public class BasketTest extends TestBase{

    @Test
    public void CartComplexTest() {
        List<String> productUrls =new MainPage(driver).PopularProductsUrls();
        BasketWidget basketWidget = new BasketWidget(driver);
        int totalCountProducts = 3;

        //add products
        for (int countProducts = 1; countProducts <= totalCountProducts; countProducts++){
            ProductPage productPage = new ProductPage(driver, productUrls.get(countProducts));
            productPage.addToCart();
            basketWidget.waitForCountUpdateTo(countProducts);
        }

        BasketPage basketPage = basketWidget.openCart();

        //remove products
        for (int countProducts = totalCountProducts; countProducts >= 0; --countProducts){
            basketPage.removeProduct();
            basketPage.waitForCountProductsToBe(countProducts);
        }
    }
}
