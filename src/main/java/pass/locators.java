package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Abhinav");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[value*='Username']")).click();
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(4000);
        driver.quit();
        Demo d = new Demo();
        System.out.println(d.test());
    }
}
