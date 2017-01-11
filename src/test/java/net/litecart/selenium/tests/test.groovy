import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

WebDriver wd;
wd = new ChromeDriver()
wd.get("http://litecart/admin/")


wd.get("http://litecart/en/")
wd.findElement(By.name("username")).click()
wd.findElement(By.name("username")).clear()
wd.findElement(By.name("username")).sendKeys("admin")
wd.findElement(By.name("password")).click()
wd.findElement(By.name("password")).clear()
wd.findElement(By.name("password")).sendKeys("admin")
wd.findElement(By.name("login")).click()



wd.findElement(By.linkText("New customers click here"))