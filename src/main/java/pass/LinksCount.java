package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LinksCount {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

/*        //One way to find total links present in a page.
        List<WebElement> hyperLink = driver.findElements(By.xpath("//a"));
        int count = 0;
        for (WebElement h : hyperLink) {
        count++;
        }
        System.out.println("Total links are "+ count);

 */
        //another way to find total links
        System.out.println("Total links in a page: "+ driver.findElements(By.tagName("a")).size());

        Thread.sleep(5);

        //Find total links present in footer section of a page.
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        System.out.println(footer.findElements(By.tagName("a")).size());

        driver.quit();
    }
}
