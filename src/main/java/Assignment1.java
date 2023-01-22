import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("form div input[name='name']")).sendKeys("Abhinav Das");    //Entered name
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhinav@test.com");
        driver.findElement(By.xpath("//input[contains(@id,'Password1')]")).sendKeys("abhi123");
        driver.findElement(By.id("exampleCheck1")).click();

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println("Interupted excemtion");
        }
        WebElement option = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropDown = new Select(option);
        dropDown.selectByIndex(1);

        driver.findElement(By.cssSelector("input[id*='Radio1']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='Radio1']")).isEnabled());
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("30/05/1996");
        driver.findElement(By.className("btn-success")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

        driver.quit();

    }
}
