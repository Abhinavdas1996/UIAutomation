package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Assignment_4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));

//        w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Multiple Windows")));
        Thread.sleep(2000);
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> win= driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parent= it.next();
        String child = it.next();


        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

        driver.quit();
    }
}
