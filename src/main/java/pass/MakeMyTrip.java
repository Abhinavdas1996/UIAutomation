package pass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MakeMyTrip {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/flights/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("fromCity")).sendKeys("Pat");

        List<WebElement> options = driver.findElements(By.xpath("//div[@class='makeFlex hrtlCenter']"));

        for (WebElement choose :options){
            if (choose.getText().equalsIgnoreCase("Lok Nayak Jayaprakash Airport")){
                choose.click();
                break;
            }
            else{
                System.out.println("Not availble!");
            }
        }


        driver.quit();
    }
}
