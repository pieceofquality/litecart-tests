import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

WebDriver wd;
wd = new ChromeDriver()
wd.get("http://litecart/en/")
wd.findElement(By.linkText("New customers click here"))