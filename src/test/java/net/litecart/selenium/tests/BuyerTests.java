package net.litecart.selenium.tests;

import org.testng.annotations.Test;

public class BuyerTests extends TestBase {


//    Exercise #8: Stickers
    @Test
    public void testStickersPresence(){
        app.getNavigationHelper().gotoProductsPage();
        app.getProductHelper().checkStickerPresence();

    }

//    Exercise #10: Campaigns
    @Test
    public void testCampaignPage(){
        app.getNavigationHelper().gotoProductsPage();
        app.getProductHelper().checkFirstCampaignProductPriceStyles();
    }

//    Exerscise #11: Registration
    @Test
    public void testUserRegistration(){
        app.getNavigationHelper().gotoProductsPage();
        app.getBuyerHelper().initBuyerRegistration();
        app.getBuyerHelper().fillBuyerRegistrationForm();
        app.getBuyerHelper().submitBuyerRegistration();
        app.getBuyerHelper().buyerLogOut();
    }

//     Exercise #13: Basket waiting
    @Test
    public void testBasketWaiting(){
        app.getNavigationHelper().gotoProductsPage();
        app.getProductHelper().addProductsToBasket();
        app.getNavigationHelper().gotoCheckoutPage();
        app.getProductHelper().removeProductsFromBasket();
}


}
