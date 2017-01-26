package net.litecart.pageobject;

import org.junit.Test;

import java.util.List;

public class BasketTest extends TestBase{

    @Test
    public void CartComplexTest() {
        List<String> productUrls = new MainPage(wd).PopularProductsUrls();
        BasketWidget basketWidget = new BasketWidget(wd);
        int n = 3;

        for (int i = 1; i <= n; i++){
            ProductPage productPage = new ProductPage(wd, productUrls.get(i));
            productPage.addToCart();
            basketWidget.waitForCountUpdateTo(i);
        }

        BasketPage basketPage = basketWidget.openCart();

        for (int i = n; i >= 0; --i){
            basketPage.removeProduct();
            basketPage.waitForCountProductsToBe(i);
        }
    }
}
