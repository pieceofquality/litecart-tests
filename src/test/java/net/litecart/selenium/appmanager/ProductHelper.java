package net.litecart.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Colors;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductHelper extends HelperBase {
    public ProductHelper(WebDriver wd) {
        super(wd);
    }


    public void checkStickerPresence() {
        List<WebElement> products = wd.findElements(By.className("product"));
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.className("sticker"));
            assertEquals(1, stickers.size());
        }
    }

    public void verifyRegularPriceStyles(WebElement price){
        Color color = Color.fromString(price.getCssValue("color"));
        assertTrue(isGrey(getColorName(color.asHex())));

        assertEquals("s", price.getTagName());
    }
    public void verifyNewPriceStyles(WebElement price){
        Color color = Color.fromString(price.getCssValue("color"));
        assertEquals("RED", getColorName(color.asHex()));

        assertEquals("strong", price.getTagName());
    }
    public void isCampaignPriceBigger(WebElement oldPrice, WebElement newPrice){
        assertTrue(oldPrice.getSize().height < newPrice.getSize().height);
    }

    public static boolean isGrey(String name){
        List<String> greys = (new ArrayList<>());
        greys.add(Colors.GRAY.name());
        greys.add(Colors.GREY.name());
        greys.add(Colors.DIMGRAY.name());
        greys.add(Colors.DIMGREY.name());
        return greys.contains(name);
    }

    public static String getColorName(String hex){
        float dist = Float.MAX_VALUE;
        String nearestColor = "";
        for(Colors c: Colors.values()){
            float tdist = computeDistance(c.getColorValue().asHex(),hex);
            if(tdist < dist){
                dist = tdist;
                nearestColor = c.name();
            }
        }
        return nearestColor;
    }

    private static float computeDistance(String hexColor1, String hexColor2){
        float[] colors1 = getComponentsFromHex(hexColor1);
        float[] colors2 = getComponentsFromHex(hexColor2);
        float diff=0;
        for(int i=0; i<colors1.length;i++){
            diff+=Math.abs(colors1[i]-colors2[i]);
        }
        return diff;
    }
    private static float[] getComponentsFromHex(String hex){
        java.awt.Color color1 = java.awt.Color.decode(hex);
        float[] components = new float[4];
        return color1.getRGBComponents(components);
    }


    public void checkFirstCampaignProductPriceStyles(){
        WebElement firstCampaignProduct = wd.findElement(By.cssSelector("#box-campaigns li:first-child"));

        WebElement regularPriceElementProductsPage = firstCampaignProduct.findElement(By.className("regular-price"));
        verifyRegularPriceStyles(regularPriceElementProductsPage);

        WebElement campaignPriceElementProductsPage = firstCampaignProduct.findElement(By.className("campaign-price"));
        verifyNewPriceStyles(campaignPriceElementProductsPage);

        isCampaignPriceBigger(regularPriceElementProductsPage, campaignPriceElementProductsPage);

        String firstCampaignProductName = firstCampaignProduct.findElement(By.className("name")).getText();
        String firstCampaignProductLink = firstCampaignProduct.findElement(By.tagName("a")).getAttribute("href");
        String regularPriceElementProductsPageText = regularPriceElementProductsPage.getText();
        String campaignPriceProductsPage = campaignPriceElementProductsPage.getText();

        firstCampaignProduct.click();

        assertEquals(firstCampaignProductLink,wd.getCurrentUrl());
        assertEquals(firstCampaignProductName, wd.findElement(By.tagName("h1")).getText());

        WebElement regularPriceElementProductPage = wd.findElement(By.className("regular-price"));
        verifyRegularPriceStyles(regularPriceElementProductPage);

        WebElement campaignPriceElementProductPage = wd.findElement(By.className("campaign-price"));
        verifyNewPriceStyles(campaignPriceElementProductPage);

        isCampaignPriceBigger(regularPriceElementProductPage, campaignPriceElementProductPage);

        assertEquals(regularPriceElementProductsPageText, regularPriceElementProductPage.getText());
        assertEquals(campaignPriceProductsPage, campaignPriceElementProductPage.getText());
    }

}
