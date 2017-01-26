package net.litecart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends AbstractPage{

    @FindBy(name ="add_cart_product")
    private WebElement butonAddToCart;

    @FindBy(name="options[Size]")
    private List<WebElement> sizeDropdown;

    private final String url;

    public ProductPage(WebDriver wd, String url){
        super(wd);
        this.url = url;
        wd.get(url);
    }

    public boolean selectSizeIfPresent(int index){
        if(sizeDropdown.size()>0){
            Select s = new Select(sizeDropdown.get(0));
            s.selectByIndex(index);
            return true;
        }
        return false;
    }
    public void addToCart(){
        selectSizeIfPresent(1);
        butonAddToCart.click();
    }

    @Override
    public String getUrl() {
        return url;
    }
}
