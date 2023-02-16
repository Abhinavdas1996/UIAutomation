package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavascriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


        //Window scroller will scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);


        //Scroll particular element
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
        List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));


        int sum = 0;
        for (int i = 0; i < amounts.size(); i++) {

            int a = Integer.parseInt(amounts.get(i).getText());
            sum = sum + a;
        }

        System.out.println(sum);



        //Retrieving the actual text and trim to 296 and converting from string to integer.
        int t = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());


        Assert.assertEquals(sum, t);


        driver.quit();
    }
}
