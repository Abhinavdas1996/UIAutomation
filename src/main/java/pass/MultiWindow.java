package pass;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.*;

public class MultiWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

//        windows(driver);
        HRMPortal(driver);
//        driver.quit();
    }

    public static void windows(WebDriver driver) throws InterruptedException {

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

    }

    public static void HRMPortal(WebDriver driver) throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        Thread.sleep(400);
//        driver.findElement(By.xpath("//a[contains(@href,'/company/orangehrm/mycompany/')]")).click();

        Thread.sleep(400);
        Actions ac = new Actions(driver);


        ac.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'/orangehrm/mycompany/')]"))).click().build().perform();
        ac.moveToElement(driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']"))).click().build().perform();
        ac.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'/orangehrm?lang=en')]"))).click().build().perform();
        ac.moveToElement(driver.findElement(By.cssSelector("a[href='https://www.youtube.com/c/OrangeHRMInc']"))).click().build().perform();


        Set<String> wins = driver.getWindowHandles();

        List<String> winList = new ArrayList<>(wins);

        for (String w:winList){
           String Title=driver.switchTo().window(w).getTitle();
           if (Title.contains("Facebook")){
               driver.switchTo().window(Title);
           }

        }
    }
}
