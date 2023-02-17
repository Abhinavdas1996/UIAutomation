package pass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultiWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parent = it.next();                  //ParentId
        String child = it.next();                   //ChildId


        //Switch to parent window
        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        String name = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();


        Thread.sleep(1000);
        driver.switchTo().window(parent);
        driver.findElement(By.name("name")).sendKeys(name);


        driver.quit();
    }
}
