package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> win = driver.getWindowHandles();              //[ParentId, ChildId]
        Iterator<String> it = win.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);                          //Switch to child window
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();


        driver.switchTo().window(parentId);                             //Switch to Parent window
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(email);
        System.out.println(driver.findElement(By.cssSelector(".text-center.text-white")).getText());
        String password = driver.findElement(By.cssSelector(".text-center.text-white")).getText().split("and")[1].split("is")[1].trim();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();



        driver.quit();
    }
}
