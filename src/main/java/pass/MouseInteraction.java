package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class MouseInteraction {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='_2KpZ6l _2doB4z']")));
        driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
        Actions nav = new Actions(driver);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='xtXmba'])[4]")));
        nav.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Appliances")));
        Thread.sleep(1000);
        nav.moveToElement(driver.findElement(By.linkText("Appliances"))).contextClick().build().perform();


        driver.quit();
    }
}
