package net.litecart.selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private String browser;
    private NavigationHelper navigationHelper;
    private AdminMenuHelper adminMenuHelper;
    private BuyerHelper buyerHelper;
    private ProductHelper productHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            wd = new ChromeDriver(caps);
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        } else if (browser.equals(BrowserType.PHANTOMJS)) {
            wd = new PhantomJSDriver();
        }
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        adminMenuHelper = new AdminMenuHelper(wd);
        buyerHelper = new BuyerHelper(wd);
        productHelper = new ProductHelper(wd);
//        sessionHelper.loginByCookie();
    }

    public SessionHelper sessionHelper() {
        return sessionHelper;
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public BuyerHelper getBuyerHelper() {
        return buyerHelper;
    }

    public AdminMenuHelper getAdminMenuHelper() {
        return adminMenuHelper;
    }

    public ProductHelper getProductHelper() {
        return productHelper;
    }
}
