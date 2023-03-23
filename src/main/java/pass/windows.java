package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class windows {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://cnh-staging.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(".bsEYOm")).click();
        driver.findElement(By.xpath("(//a[text()='Privacy Policy'])[2]")).click();

        Set<String> multiWin = driver.getWindowHandles();
        Iterator<String> it = multiWin.iterator();

        String win1=it.next();
        String win2 = it.next();          //Next window

        Thread.sleep(400);
        driver.switchTo().window(win2);

        Thread.sleep(600);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");
        System.out.println(driver.findElement(By.cssSelector(".sc-dkzDqf.iajAHX.MuiTypography-root")).getText());
//        driver.findElement(By.cssSelector(".sc-dkzDqf.iajAHX.MuiTypography-root")).click();


        driver.close();

//        Thread.sleep(400);
//        String win3 = it.next();
//        driver.switchTo().window(win3);
//        driver.close();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();


//        Thread.sleep(800);
//        driver.switchTo().window(win1);


//        driver.quit();


    }

}
