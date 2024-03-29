package pass;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment_5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));


        //Click on Nested Frames
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='nested_frames']")));
        driver.findElement(By.cssSelector("a[href*='nested_frames']")).click();


        //Nested frames :- First switch to base frame
        driver.switchTo().frame("frame-top");


        //Second switch to frame which is top of base frame.
        driver.switchTo().frame("frame-middle");


        //Grab the content of top middle frame
        System.out.println(driver.findElement(By.id("content")).getText());

        Price(driver);


        driver.quit();

//        SSLCheck(driver);


    }

    public static void SSLCheck(WebDriver driver) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver1 = new ChromeDriver(options);
        Thread.sleep(5);
        driver1.get("https://expired.badssl.com/");
        System.out.println(driver1.getTitle());

        driver1.quit();
    }

    public static void Price(WebDriver driver) {

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //Page scroll
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,800)");

        List<WebElement> s = driver.findElements(By.xpath("//table[@name='courses']//td[3]"));

        int sum = 0;
        for (WebElement course : s) {
            sum = sum + Integer.parseInt(course.getText());

        }
        System.out.println(sum);
    }
}
