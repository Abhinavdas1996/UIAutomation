package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("Abhinav Das");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText()+"\n");
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input[value='Confirm']")).click();
        System.out.println(driver.switchTo().alert().getText()+": No");
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
