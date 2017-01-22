import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

WebDriver wd;
wd = new ChromeDriver()
//wd.get("http://litecart/en/")
wd.get("http://litecart/admin/")
wd.findElement(By.name("username")).click()
wd.findElement(By.name("username")).clear()
wd.findElement(By.name("username")).sendKeys("admin")
wd.findElement(By.name("password")).click()
wd.findElement(By.name("password")).clear()
wd.findElement(By.name("password")).sendKeys("admin")
wd.findElement(By.name("login")).click()

wd.findElement(By.cssSelector(".fa-external-link")).click()
wd.findElements(By.cssSelector(".fa-external-link")).size()
List<WebElement> els = wd.findElements(By.cssSelector("[type = 'checkbox']"))
wd.findElements(By.cssSelector("[type = 'checkbox']")).size()

String mainWindow = wd.getWindowHandle();
Set<String> oldWindows = wd.getWindowHandles();
link.click(); // открывает новое окно
// ожидание появления нового окна,
// идентификатор которого отсутствует в списке oldWindows,
// остаётся в качестве самостоятельного упражнения
String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
wd.switchTo().window(newWindow);
// ...
wd.close();
wd.switchTo().window(mainWindow);

wd.findElement(By.linkText("New customers click here"))