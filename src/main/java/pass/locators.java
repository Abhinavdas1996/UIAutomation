package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class locators {
    public static void main(String[] args) throws InterruptedException {

        String S1 = "Abhinav";

        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(S1);
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value*='Username']")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Welcome to Rahul Shetty Academy");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello " + S1 + ",");
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();


        driver.quit();
        Demo d = new Demo();
        System.out.println(d.test());
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class*='reset']")).click();
        String pwd = driver.findElement(By.tagName("p")).getText();
        String[] PasswordArray = pwd.split("'");
        String[] PasswordArray2 = PasswordArray[1].split("'");
        return PasswordArray2[0];

        //0th index - Please use temporary password
        //1st index - rahulshettyacademy' to Login.

        //0th index - rahulshettyacademy
        //1st index - to Login.

    }
}
