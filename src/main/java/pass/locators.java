package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locators {
    public static void main(String[] args) throws InterruptedException {

        String S1 = "Abhinav";

        System.setProperty("webdriver.chrome.driver","/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(S1);
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[value*='Username']")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Welcome to Rahul Shetty Academy");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello "+ S1+",");

        Thread.sleep(1000);
        driver.quit();
        Demo d = new Demo();
        System.out.println(d.test());
    }
}
