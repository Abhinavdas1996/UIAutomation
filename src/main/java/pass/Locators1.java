package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //Navigate to another url
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();     //Maximize the screen


        driver.navigate().back();             //Navigate back to previous url

        driver.navigate().forward();          //Navigate forward


        //Sibling - Child to parent traversal  :  Not possible with CSS selector
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText() + "\n");

        //Child - parent traversal  : Not possible with CSS selector
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText() + "\n");


        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());

        driver.quit();

    }
}
